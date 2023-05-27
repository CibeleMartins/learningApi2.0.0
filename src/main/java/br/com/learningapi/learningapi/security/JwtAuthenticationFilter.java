package br.com.learningapi.learningapi.security;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import br.com.learningapi.learningapi.common.ConvertDate;
import br.com.learningapi.learningapi.domain.exception.ResourceNotFoundException;
import br.com.learningapi.learningapi.domain.model.ErrorMessageResponse;
import br.com.learningapi.learningapi.domain.model.UserLearner;
import br.com.learningapi.learningapi.domain.repository.UserLearnerRepository;
import br.com.learningapi.learningapi.dto.UserLearner.UserLearnerLoginReqDTO;
import br.com.learningapi.learningapi.dto.UserLearner.UserLearnerLoginRespDTO;
import br.com.learningapi.learningapi.dto.UserLearner.UserLearnerResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    // essa classe é um filter e vai extender outra para sobrescrever alguns métodos
    // essa classe é utilizada pelo spring para filtrar alguma coisa na autenticação

    private UserLearnerRepository userLearnerRepository;

    private AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;

    // esses atributos vão ser recebidos no construtor dessa classe
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserLearnerRepository userLearnerRepository) {
        // chama os métodos da classe pai
        super();
        // constrói a propriedades de acordo com os parâmetros recebidos
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userLearnerRepository = userLearnerRepository;
        // esse método recebe uma url que fará com que só chegue 
        // nesse filtro de autenticação criado, caso acesse o usuário acesse essa url
        setFilterProcessesUrl("/api/users");
    }

    // existe um método da classe extendida 
    // que é utilizado para receber requisição
    // toda vez que uma requisição chegar nesse filtro
    // chegará dentro desse método
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException{
                                                                                                     // esse me´todo pode lançar um exception
        try {
            // Pega o que vem no corpo da requisição, mais especificamente a stream de dados
            // e transforma em um modelo DTO do usuário, parecido com model mapper
            UserLearnerLoginReqDTO userLogin = new ObjectMapper().readValue(request.getInputStream(), UserLearnerLoginReqDTO.class);

            // manda o security do spring validar esse usuário através do email e senha
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userLogin.getEmailUser(), userLogin.getPasswordUser());
            // veriica se está tudo ok para autenticar
            Authentication auth = authenticationManager.authenticate(authToken);

            return auth;

        }catch(BadCredentialsException e) {
            throw new BadCredentialsException("Usuário ou senha inválidos.");
        } catch (Exception e) {
            throw new InternalAuthenticationServiceException("Erro interno: " + e.getMessage());
        }
    }

    // deu certo autenticação?
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,Authentication authResult) throws IOException {
        // toda autenticação filtrada e retornada com sucesso cairá aqui dentro

        // qual é o usuário autenticado
        // getPrincipal() retorna um objeto, por isso é feito um cast
        UserLearner user = (UserLearner) authResult.getPrincipal();

        // gerar um token para o usuário com base na classe criada c/ o método que gera o token
        String token = jwtUtil.generateToken(authResult);

        // cria um usuário response com base no usuário autenticado
        UserLearnerResponse userResponse = new UserLearnerResponse();
        userResponse.setId(user.getId());
        userResponse.setEmailUser(user.getEmailUser());
        userResponse.setNameUser(user.getNameUser());
        userResponse.setPhotoUser(user.getPhotoUser());
        userResponse.setInactivationDate(user.getInactivationDate());
        userResponse.setDateRegister(user.getDateRegister());
        // Optional<UserLearner> userOptModel = userLearnerRepository.findByEmailUser(userResponse.getEmailUser());
        userResponse.setIsFirstLogin(isFirstLogin(user.getFirstLoginDate(), user));   
     
        // cria um usuário login response com o token e as infos do usuário response dto
        UserLearnerLoginRespDTO userLoginResponse = new  UserLearnerLoginRespDTO();
        userLoginResponse.setTokenAuthorization("Bearer" + token);
        userLoginResponse.setUser(userResponse);

        // altera a resposta
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        // escreve a resposta como json
        response.getWriter().write(new Gson().toJson(userLoginResponse));

    }

    // se algo der errado chegará nesse método
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,AuthenticationException failed) throws IOException, ServletException  {
        // as exceções aqui não chegam no handler que foi criado, não é possível utilizar exceções escutada pelo handler
        // porque essas exceções aqui acontecem antes do usuário chegar na aplicação

        String dateHour = ConvertDate.convertDateForDateHour(new Date());

        ErrorMessageResponse error = new ErrorMessageResponse(dateHour, 401, "Unauthorized",failed.getMessage());

        response.setStatus(401);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(error));
    }


    public Boolean isFirstLogin(Date dataFirstLogin, UserLearner userOptModel) {

        if(dataFirstLogin == null) {
            userOptModel.setFirstLoginDate(new Date());
           this.userLearnerRepository.save(userOptModel);

            return true;
        }

        return false;
    }
}
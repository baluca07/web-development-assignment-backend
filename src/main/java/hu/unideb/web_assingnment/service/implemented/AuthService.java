package hu.unideb.web_assingnment.service.implemented;

import hu.unideb.web_assingnment.data.entities.Role;
import hu.unideb.web_assingnment.data.entities.UserEntity;
import hu.unideb.web_assingnment.data.repositories.UserRepository;
import hu.unideb.web_assingnment.service.JwtService;
import hu.unideb.web_assingnment.service.dto.LoginDTO;
import hu.unideb.web_assingnment.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    public void register(UserDTO user) throws Exception {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new Exception("User already exists with this email: " + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        UserEntity entity = new UserEntity();
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        entity.setRole(Role.USER);

        entity = userRepository.save(entity);

        jwtService.generateToken(entity);


    }

    public String login(LoginDTO bejelentkezesDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(bejelentkezesDto.getEmail(),
                        bejelentkezesDto.getPassword())
        );
        var user = userRepository.findByEmail(bejelentkezesDto.getEmail());
        return jwtService.generateToken(user); //token
    }
}


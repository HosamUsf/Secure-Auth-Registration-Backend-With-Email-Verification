package com.hossam.login_tutorial.user;

import com.hossam.login_tutorial.registration.token.ConfirmationToken;
import com.hossam.login_tutorial.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder encoder;
    private ConfirmationTokenService confirmationTokenService;

    public String signUpUser(User user) {
        boolean userExist =
                userRepository.findByEmail(user.getEmail()).isPresent();

        if (userExist) {
            throw new IllegalStateException("email already taken ");

        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);


        return token;
    }



    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }
}

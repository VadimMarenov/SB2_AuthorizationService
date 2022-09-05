package ru.maren.sb2authorizationservice.service;

import org.springframework.stereotype.Service;
import ru.maren.sb2authorizationservice.exception.InvalidCredentials;
import ru.maren.sb2authorizationservice.exception.UnauthorizedUser;
import ru.maren.sb2authorizationservice.model.Authorities;
import ru.maren.sb2authorizationservice.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}

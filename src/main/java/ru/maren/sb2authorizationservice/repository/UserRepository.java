package ru.maren.sb2authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.maren.sb2authorizationservice.model.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("admin") && password.equals("admin")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("writer") && password.equals("writer")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else if (user.equals("reader") && password.equals("reader")) {
            Collections.addAll(authorities, Authorities.READ);
        }
        return authorities;
    }
}

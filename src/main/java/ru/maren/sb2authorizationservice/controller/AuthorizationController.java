package ru.maren.sb2authorizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.maren.sb2authorizationservice.exception.InvalidCredentials;
import ru.maren.sb2authorizationservice.exception.UnauthorizedUser;
import ru.maren.sb2authorizationservice.model.Authorities;
import ru.maren.sb2authorizationservice.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials e){
        return new ResponseEntity<>("InvalidCredentials " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuHandler(UnauthorizedUser e){
        System.out.println(e.getMessage());
        return new ResponseEntity<>("UnauthorizedUser " + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }


}
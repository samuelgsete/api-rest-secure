package br.com.samuel.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.samuel.app.infra.config.security.Authority;

@RestController
@RequestMapping("welcome")
public class WelcomeController {
    
    @PreAuthorize(Authority.USER)
    @GetMapping("/user-console")
    public ResponseEntity<String> welcomeUser() {
        return ResponseEntity.ok("Hi... Welcome at User Console :)");
    }

    @PreAuthorize(Authority.ADMIN)
    @GetMapping("/admin-console")
    public ResponseEntity<String> welcomeAdmin() {
        return ResponseEntity.ok("Hi... Welcome at Admin Console :)");
    }

    @GetMapping("/anonymous-console")
    public ResponseEntity<String> welcomeAnonymous() {
        return ResponseEntity.ok("Hi... Welcome Anonymous :)");
    }
}
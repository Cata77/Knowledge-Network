package com.knowledge_network.controller;

import com.knowledge_network.dto.AuthenticatedUserDto;
import com.knowledge_network.model.User;
import com.knowledge_network.service.AuthenticationService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/authenticate")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final Logger logger = LogManager.getLogger(AuthenticationController.class.getName());

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<User> authenticateUser(@RequestBody AuthenticatedUserDto authenticatedUserDto) {
        User user = authenticationService.authenticateUser(authenticatedUserDto);
        logger.log(Level.INFO, "Authenticated user: {}.", user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }
}

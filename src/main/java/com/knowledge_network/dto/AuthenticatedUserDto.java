package com.knowledge_network.dto;

public record AuthenticatedUserDto(
        String userName,
        String password
) {}

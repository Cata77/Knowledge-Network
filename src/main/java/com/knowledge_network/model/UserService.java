package com.knowledge_network.model;

public interface UserService {
    void saveUser(User user);
    Record convertUserToDto(User user);
}

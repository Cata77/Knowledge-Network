package com.knowledge_network.service;

import com.knowledge_network.model.User;

public interface UserService {
    void saveUser(User user);
    Record convertUserToDto(User user);
    void createRelationship(Long userId, Long subjectId);
}

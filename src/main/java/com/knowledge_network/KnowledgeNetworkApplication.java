package com.knowledge_network;

import com.knowledge_network.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KnowledgeNetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowledgeNetworkApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

package com.eduardofbom.spring_api_rest.service;

import com.eduardofbom.spring_api_rest.domain.User;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String helloWorld(String name) {
        return "Hello World: " + name;
    }

    public String helloWorldWithUser(User user) {
        return "Hello World " + user.getName() + "(" + user.getEmail() + ")";
    }

    public String helloWorldWithUser(User body, String id) {
        return String.format("Hello World %s (%s : %s)%n",
                body.getName(),
                body.getEmail(),
                id);
    }

    public String helloWorldWithUser(User body, String id, String filter) {
        return String.format("Hello World %s (%s : %s) | filter=%s%n",
                body.getName(),
                body.getEmail(),
                id,
                filter);
    }
}

package com.eduardofbom.spring_api_rest.controller;

import com.eduardofbom.spring_api_rest.domain.User;
import com.eduardofbom.spring_api_rest.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping
    public String helloWorld() {
        return this.helloWorldService.helloWorld("Eduardo");
    }

    @PostMapping("")
    public String helloWorldPost (@RequestBody User body) {
        return this.helloWorldService.helloWorldWithUser(body);
    }

    @PostMapping("/{id}")
    public String helloWorldPost (@PathVariable("id") String id, @RequestParam(value="filter", defaultValue="none") String filter, @RequestBody User body) {
        return this.helloWorldService.helloWorldWithUser(body, id, filter);
    }
}

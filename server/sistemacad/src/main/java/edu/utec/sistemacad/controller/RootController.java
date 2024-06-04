package edu.utec.sistemacad.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RootController {

    @GetMapping
    public String home(){
        return "API";
    }
}

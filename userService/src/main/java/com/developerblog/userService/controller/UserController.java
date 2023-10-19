package com.developerblog.userService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.developerblog.userService.constants.EndPoints.*;

@RestController
@RequestMapping(API_USER)
public class UserController {
    @GetMapping(STATUS)
    public String status(){
        return "working";
    }
}

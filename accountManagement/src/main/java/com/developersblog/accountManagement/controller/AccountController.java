package com.developersblog.accountManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.developersblog.accountManagement.constants.Endpoints.*;
@RestController
@RequestMapping(API_ACCOUNT)
public class AccountController {
    @GetMapping
    public String accountInfo(){
        return "Account info";
    }
}

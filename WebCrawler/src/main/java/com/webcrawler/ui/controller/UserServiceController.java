package com.webcrawler.ui.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webcrawler.dao.UserDetailsModel;
import com.webcrawler.services.UserService;
import com.webcrawler.ui.model.AjaxResponseBody;
import com.webcrawler.ui.model.UserCriteria;

@RestController
public class UserServiceController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/userservice")
    public ResponseEntity<?> saveAndSendEmail(@Valid @RequestBody UserCriteria userCriteria, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }

        String email = userService.saveAndEmailUser(userCriteria);
        
        if (StringUtils.isEmpty(email)) {
            result.setMsg("Failed to send email");
        } else {
            result.setMsg("Email sent. Verify your email");
        }
        return ResponseEntity.ok(result);
    }

 // Find
    @GetMapping("/userservice")
    List<UserDetailsModel> getAllDetails() {
        return userService.getAllDetails();
    }
    
}

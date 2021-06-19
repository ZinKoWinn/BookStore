package com.zinko.bookstore.controller;

import com.zinko.bookstore.dto.RegisterDto;
import com.zinko.bookstore.models.entities.User;
import com.zinko.bookstore.services.AuthService;
import com.zinko.bookstore.services.UserService;
import com.zinko.bookstore.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;


    @GetMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("userRegister", new RegisterDto());
        return "authentication/register";
    }

    @PostMapping("/register")
    public String register(RegisterDto registerDto, BindingResult bindingResult, @RequestParam("userImage") MultipartFile multipartFile) throws ServletException, IOException {
        if (bindingResult.hasErrors()) {
            return "authentication/register";
        } else {
            if (userService.exitsByEmail(registerDto.getEmail())) {
                throw new IllegalStateException("Email is already taken!" + HttpStatus.BAD_REQUEST);
            }
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            registerDto.setImageUrl(fileName);
            User user = userService.register(registerDto);
            String uploadDir = "appImages/" + "users/Profile Images/" + user.getName();
            FileUploadUtils.saveFile(uploadDir, fileName, multipartFile);
            authService.loginProcess(registerDto.getEmail(), registerDto.getPassword());

        }
        return "redirect:/home";

    }

    @GetMapping("/login")
    public String loginUser() {
        return "authentication/login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "authentication/login";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/home";
    }


}

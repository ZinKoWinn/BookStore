package com.zinko.bookstore.controller;

import com.zinko.bookstore.dto.UserDto;
import com.zinko.bookstore.models.Cart;
import com.zinko.bookstore.services.AuthService;
import com.zinko.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class OrderController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;
    @Autowired
    private Cart cart;

    @GetMapping("/cart/user/books/checkout")
    public String checkOut(Model model, HttpServletResponse response) throws IOException {
        if (cart.getCartItems().isEmpty()) {
            return "redirect:/user/books";
        }

        if (authService.isLogged()) {
            UserDto user = userService.findByEmail(authService.findLoggedInUsername());
            model.addAttribute("user", user);
            model.addAttribute("cart", new Cart());
            model.addAttribute("books", cart.getCartItems());
            model.addAttribute("tax", cart.getTax());
            model.addAttribute("total", cart.getTotal());
            return "user/checkout";
        } else {
            response.sendRedirect("/register");
        }
        return null;

    }

    @GetMapping("/payment")
    public String payment() {
        return "user/payment";
    }

    @PostMapping("/user/payment")
    public String paymentProcess() {
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success() {
        return "user/success";
    }
}

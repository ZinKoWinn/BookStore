package com.zinko.bookstore.controller;

import com.zinko.bookstore.models.Cart;
import com.zinko.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
    @Autowired
    private BookService bookService;
    @Autowired
    private Cart cart;

    @GetMapping("carts")
    public String carts(Model model) {
        model.addAttribute("cartItem", cart);
        return "user/cart-view";
    }

    @GetMapping("carts/cart/add/{id}")
    public String addToCart(@PathVariable int id, @RequestParam(value = "qty", required = false, defaultValue = "1") int qty) {
        cart.addToCart(bookService.findById(id), qty);
        return "redirect:/carts";
    }


    @GetMapping("carts/cart/{id}/remove")
    public String removeCartItem(@PathVariable int id) {
        cart.removeItem(bookService.findById(id));
        return "redirect:/carts";
    }

    @GetMapping("carts/clear")
    public String clearCart(){
        cart.clear();
        return "redirect:/carts";
    }


}

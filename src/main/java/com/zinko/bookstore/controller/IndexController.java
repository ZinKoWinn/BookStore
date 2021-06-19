package com.zinko.bookstore.controller;

import com.zinko.bookstore.services.AuthorService;
import com.zinko.bookstore.services.BookService;
import com.zinko.bookstore.services.CategoryService;
import com.zinko.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;


    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {
        model.addAttribute("categoryList", categoryService.findAll().stream().count() > 4 ? categoryService.findAll().subList(0, 4) : categoryService.findAll());
        model.addAttribute("authorList", authorService.findAll().stream().count() > 4 ? authorService.findAll().subList(0, 4) : authorService.findAll());
        model.addAttribute("bookList", bookService.findAll().stream().count() > 4 ? bookService.findAll().subList(0, 4) : bookService.findAll());
        return "home";
    }
}


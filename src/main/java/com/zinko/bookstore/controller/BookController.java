package com.zinko.bookstore.controller;

import com.zinko.bookstore.dto.AuthorDto;
import com.zinko.bookstore.dto.BookDto;
import com.zinko.bookstore.dto.CategoryDto;
import com.zinko.bookstore.models.entities.Author;
import com.zinko.bookstore.models.entities.Book;
import com.zinko.bookstore.models.entities.Category;
import com.zinko.bookstore.services.AuthorService;
import com.zinko.bookstore.services.BookService;
import com.zinko.bookstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/user/books")
    public ModelAndView findAll() {
        return new ModelAndView("user/books", "books", bookService.findAll());
    }

    @GetMapping("/admin/books")
    public ModelAndView findAllByAdmin() {
        return new ModelAndView("admin/books", "adminBooks", bookService.findAll());
    }

    @GetMapping("/admin/books/book/add")
    public String create(Model model) {
        model.addAttribute("book", new BookDto());
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/book-create";
    }

    @PostMapping("/admin/books/book/add")
    public String create(BookDto book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/book-create";
        } else {
            AuthorDto author = authorService.findById(book.getAuthor().getId());
            CategoryDto category = categoryService.findById(book.getCategory().getId());
            book.setAuthor(AuthorDto.toEntity(author));
            book.setCategory(CategoryDto.toEntity(category));
            bookService.create(book);
            return "redirect:/admin/books";
        }

    }

    @GetMapping("/admin/books/book/update/{id}")
    public String update(Model model, @PathVariable int id) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/book-update";
    }

    @PostMapping("/admin/books/book/update")
    public String update(BookDto book) {
        bookService.update(book);
        return "redirect:admin/books";

    }

    @GetMapping("/user/books/book/details/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("book",bookService.findById(id));
        return "user/book-detail";
    }

    @GetMapping("/admin/books/book/delete/{id}")
    public String delete(@PathVariable int id) {
        if (bookService.existsById(id)) {
            bookService.delete(id);
        }
        return "redirect:/admin/books";
    }

    @GetMapping("/books/count")
    public long count() {
        return bookService.count();
    }

}

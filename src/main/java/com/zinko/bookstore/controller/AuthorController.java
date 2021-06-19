package com.zinko.bookstore.controller;

import com.zinko.bookstore.dto.AuthorDto;
import com.zinko.bookstore.models.entities.Author;
import com.zinko.bookstore.services.AuthorService;
import com.zinko.bookstore.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/user/authors")
    public ModelAndView findAll() {
        return new ModelAndView("user/authors", "authors", authorService.findAll());
    }

    @GetMapping("/admin/authors")
    public ModelAndView findAllByAdmin() {
        return new ModelAndView("admin/authors", "adminAuthors", authorService.findAll());
    }


    @GetMapping("/admin/authors/author/add")
    public ModelAndView create() {
        return new ModelAndView("admin/author-create", "author", new AuthorDto());
    }

    @PostMapping("/admin/authors/author/add")
    public String create(AuthorDto author, BindingResult bindingResult, @RequestParam("authorImage") MultipartFile multipartFile) throws IOException {
        if (bindingResult.hasErrors()) {
            return "admin/author-create";
        } else {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            author.setImageUrl(fileName);
            Author a = authorService.create(author);
            String uploadDir = "appImages/" + "authors/" + a.getName();
            FileUploadUtils.saveFile(uploadDir, fileName, multipartFile);
            return "redirect:/admin/authors";
        }

    }

    @GetMapping("/admin/authors/author/update/{id}")
    public String update(Model model, @PathVariable int id) {
        model.addAttribute("author", authorService.findById(id));
        return "admin/author-update";
    }

    @PostMapping("/admin/authors/author/update/{id}")
    public String update(AuthorDto author,@PathVariable int id,BindingResult bindingResult,@RequestParam("authorUpdateImage") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        author.setId(id);
        author.setImageUrl(fileName);
        Author a = authorService.update(author);
        String uploadDir = "appImages/" + "authors/" + a.getName();
        FileUploadUtils.saveFile(uploadDir, fileName, multipartFile);
        return "redirect:/admin/authors";


    }

    @GetMapping("/admin/authors/author/delete/{id}")
    public String delete(@PathVariable int id) {
        if (authorService.existsById(id)) {
            authorService.delete(id);
        }
        return "redirect:/admin/authors";
    }

    @GetMapping("/authors/count")
    public long count() {
        return authorService.count();
    }


}

package com.zinko.bookstore.controller;

import com.zinko.bookstore.dto.CategoryDto;
import com.zinko.bookstore.models.entities.Category;
import com.zinko.bookstore.services.CategoryService;
import com.zinko.bookstore.utils.FileUploadUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Value("file.upload.location")
    private String location;

    @GetMapping("/user/categories")
    public ModelAndView findAll() {
        return new ModelAndView("user/categories", "categories", categoryService.findAll());
    }

    @GetMapping("/admin/categories")
    public ModelAndView findAllByAdmin() {
        return new ModelAndView("admin/categories", "adminCategories", categoryService.findAll());
    }


    @GetMapping("/admin/categories/category/add")
    public ModelAndView create() {
        return new ModelAndView("admin/category-create", "category", new CategoryDto());
    }

    @PostMapping("/admin/categories/category/add")
    public String create(CategoryDto category, BindingResult bindingResult, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
        if (bindingResult.hasErrors()) {
            return "admin/category-create";
        } else {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            category.setImageUrl(fileName);
            Category c = categoryService.create(category);
            String uploadDir = "appImages/" + "categories/" + c.getName();
            FileUploadUtils.saveFile(uploadDir, fileName, multipartFile);

            return "redirect:/admin/categories";
        }

    }

    @GetMapping("/admin/categories/category/update/{id}")
    public String update(Model model, @PathVariable int id) {
        model.addAttribute("category", categoryService.findById(id));
        return "admin/category-update";
    }

    @PostMapping("/admin/categories/category/update/{id}")
    public String update(@ModelAttribute CategoryDto category, BindingResult result, @PathVariable int id, @RequestParam("categoryUpdateImage") MultipartFile multipartFile) throws IOException {
        category.setId(id);
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        category.setImageUrl(fileName);
        Category c = categoryService.update(category);
        String uploadDir = "appImages/" + "categories/" + c.getName();
        FileUploadUtils.saveFile(uploadDir, fileName, multipartFile);
        return "redirect:/admin/categories";


    }

    @GetMapping("/admin/categories/category/delete/{id}")
    public String delete(@PathVariable int id) throws IOException {
        if (categoryService.existsById(id)) {
            CategoryDto categoryDto = categoryService.findById(id);
            categoryService.delete(id);

        }
        return "redirect:/admin/categories";
    }

    @GetMapping("/categories/count")
    public long count() {
        return categoryService.count();
    }


}

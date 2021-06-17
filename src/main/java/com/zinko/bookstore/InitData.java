package com.zinko.bookstore;

import com.zinko.bookstore.dto.AuthorDto;
import com.zinko.bookstore.dto.BookDto;
import com.zinko.bookstore.dto.CategoryDto;
import com.zinko.bookstore.models.entities.*;
import com.zinko.bookstore.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;


@Configuration
public class InitData {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @Bean
    public CommandLineRunner initRunner() {
        return args -> {

            if (categoryService.emptyCategory()) {
                CategoryDto category = new CategoryDto();
                category.setName("Programming");
                category.setDescription("Programming is a ......");
                categoryService.create(category);
            } else {
                System.out.println("Category is already define!");
            }

            if (authorService.emptyAuthor()) {
                AuthorDto author1 = new AuthorDto();
                author1.setId(1);
                author1.setName("Zaw Min Lwin");
                author1.setImageUrl("https://avatars.githubusercontent.com/u/1300121?v=4");
                author1.setAbout("Zaw Min Lwin is a technical trainer, founder of Java Developer Class and blog writer of Myanmar Java user.");
                authorService.create(author1);

                AuthorDto author2 = new AuthorDto();
                author2.setId(2);
                author2.setName("Kyaw Kyaw Lwin");
                author2.setImageUrl("https://scontent-sin6-4.xx.fbcdn.net/v/t1.6435-9/54362925_2012689858779148_1736899420340879360_n.jpg?_nc_cat=101&ccb=1-3&_nc_sid=8bfeb9&_nc_ohc=IckjJNeF_REAX-Rkx1r&_nc_ht=scontent-sin6-4.xx&oh=d8be27595fdacadcd471d8508d992e4b&oe=60CE0E17");
                author2.setAbout("Kyaw Kyaw lwin is a technical trainer.");
                authorService.create(author2);

                AuthorDto author3 = new AuthorDto();
                author3.setId(3);
                author3.setName("Zin Ko Win");
                author3.setImageUrl("https://scontent-sin6-4.xx.fbcdn.net/v/t1.6435-9/81252603_469166764023332_2837318420087701504_n.jpg?_nc_cat=101&ccb=1-3&_nc_sid=174925&_nc_ohc=Uqm_DAKUx4AAX_uh8CT&_nc_ht=scontent-sin6-4.xx&oh=3dbaedf6e1103a74b3084ac91edb66f4&oe=60CD6AFC");
                author3.setAbout("Zin Ko Win is a junior Java Developer");
                authorService.create(author3);
            }


            if (bookService.emptyBook()) {
                CategoryDto category = categoryService.findById(1);
                AuthorDto author1 = authorService.findById(1);
                AuthorDto author2 = authorService.findById(2);
                AuthorDto author3 = authorService.findById(3);

                BookDto book1 = new BookDto();
                book1.setId(1);
                book1.setName("Java Language Fundamental");
                book1.setAuthor(AuthorDto.toEntity(author1));
                book1.setCategory(CategoryDto.toEntity(category));
                book1.setDescription("This Book is designed for absolute beginner to professional. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Euismod lacinia at quis risus sed vulputate odio. Amet consectetur adipiscing elit duis tristique. Nunc vel risus commodo viverra maecenas accumsan. Tristique senectus et netus et. Euismod lacinia at quis risus sed vulputate odio ut enim. Mauris in aliquam sem fringilla ut morbi tincidunt augue interdum. Tellus mauris a diam maecenas sed enim ut sem viverra. Eu facilisis sed odio morbi quis commodo. Ultricies mi eget mauris pharetra et. Nunc consequat interdum varius sit. Netus et malesuada fames ac turpis egestas sed tempus. Vitae elementum curabitur vitae nunc sed velit. Morbi tempus iaculis urna id volutpat lacus laoreet. Lectus quam id leo in vitae turpis massa. Viverra nam libero justo laoreet sit amet cursus sit amet. Amet nulla facilisi morbi tempus iaculis urna id volutpat lacus. Massa vitae tortor condimentum lacinia quis vel eros donec. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Euismod lacinia at quis risus sed vulputate odio. Amet consectetur adipiscing elit duis tristique. Nunc vel risus commodo viverra maecenas accumsan. Tristique senectus et netus et. Euismod lacinia at quis risus sed vulputate odio ut enim. Mauris in aliquam sem fringilla ut morbi tincidunt augue interdum. Tellus mauris a diam maecenas sed enim ut sem viverra. Eu facilisis sed odio morbi quis commodo. Ultricies mi eget mauris pharetra et. Nunc consequat interdum varius sit. Netus et malesuada fames ac turpis egestas sed tempus. Vitae elementum curabitur vitae nunc sed velit. Morbi tempus iaculis urna id volutpat lacus laoreet. Lectus quam id leo in vitae turpis massa. Viverra nam libero justo laoreet sit amet cursus sit amet. Amet nulla facilisi morbi tempus iaculis urna id volutpat lacus. Massa vitae tortor condimentum lacinia quis vel eros donec.");
                book1.setContent("1.What is java? \n 2. Types of java edition \n Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Euismod lacinia at quis risus sed vulputate odio. Amet consectetur adipiscing elit duis tristique. Nunc vel risus commodo viverra maecenas accumsan. Tristique senectus et netus et. Euismod lacinia at quis risus sed vulputate odio ut enim. Mauris in aliquam sem fringilla ut morbi tincidunt augue interdum. Tellus mauris a diam maecenas sed enim ut sem viverra. Eu facilisis sed odio morbi quis commodo. Ultricies mi eget mauris pharetra et. Nunc consequat interdum varius sit. Netus et malesuada fames ac turpis egestas sed tempus. Vitae elementum curabitur vitae nunc sed velit. Morbi tempus iaculis urna id volutpat lacus laoreet. Lectus quam id leo in vitae turpis massa. Viverra nam libero justo laoreet sit amet cursus sit amet. Amet nulla facilisi morbi tempus iaculis urna id volutpat lacus. Massa vitae tortor condimentum lacinia quis vel eros donec.");
                book1.setPrice(26000);
                book1.setPublishedDate(LocalDate.now());
                book1.setRate(4);
                bookService.create(book1);


                BookDto book2 = new BookDto();
                book2.setId(2);
                book2.setName("Spring Complete");
                book2.setAuthor(AuthorDto.toEntity(author2));
                book2.setCategory(CategoryDto.toEntity(category));
                book2.setDescription("This Book is designed for absolute beginner to professional . Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Euismod lacinia at quis risus sed vulputate odio. Amet consectetur adipiscing elit duis tristique. Nunc vel risus commodo viverra maecenas accumsan. Tristique senectus et netus et. Euismod lacinia at quis risus sed vulputate odio ut enim. Mauris in aliquam sem fringilla ut morbi tincidunt augue interdum. Tellus mauris a diam maecenas sed enim ut sem viverra. Eu facilisis sed odio morbi quis commodo. Ultricies mi eget mauris pharetra et. Nunc consequat interdum varius sit. Netus et malesuada fames ac turpis egestas sed tempus. Vitae elementum curabitur vitae nunc sed velit. Morbi tempus iaculis urna id volutpat lacus laoreet. Lectus quam id leo in vitae turpis massa. Viverra nam libero justo laoreet sit amet cursus sit amet. Amet nulla facilisi morbi tempus iaculis urna id volutpat lacus. Massa vitae tortor condimentum lacinia quis vel eros donec. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Euismod lacinia at quis risus sed vulputate odio. Amet consectetur adipiscing elit duis tristique. Nunc vel risus commodo viverra maecenas accumsan. Tristique senectus et netus et. Euismod lacinia at quis risus sed vulputate odio ut enim. Mauris in aliquam sem fringilla ut morbi tincidunt augue interdum. Tellus mauris a diam maecenas sed enim ut sem viverra. Eu facilisis sed odio morbi quis commodo. Ultricies mi eget mauris pharetra et. Nunc consequat interdum varius sit. Netus et malesuada fames ac turpis egestas sed tempus. Vitae elementum curabitur vitae nunc sed velit. Morbi tempus iaculis urna id volutpat lacus laoreet. Lectus quam id leo in vitae turpis massa. Viverra nam libero justo laoreet sit amet cursus sit amet. Amet nulla facilisi morbi tempus iaculis urna id volutpat lacus. Massa vitae tortor condimentum lacinia quis vel eros donec.");
                book2.setContent("1.Spring Core \n 2. Spring Boot \n Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Euismod lacinia at quis risus sed vulputate odio. Amet consectetur adipiscing elit duis tristique. Nunc vel risus commodo viverra maecenas accumsan. Tristique senectus et netus et. Euismod lacinia at quis risus sed vulputate odio ut enim. Mauris in aliquam sem fringilla ut morbi tincidunt augue interdum. Tellus mauris a diam maecenas sed enim ut sem viverra. Eu facilisis sed odio morbi quis commodo. Ultricies mi eget mauris pharetra et. Nunc consequat interdum varius sit. Netus et malesuada fames ac turpis egestas sed tempus. Vitae elementum curabitur vitae nunc sed velit. Morbi tempus iaculis urna id volutpat lacus laoreet. Lectus quam id leo in vitae turpis massa. Viverra nam libero justo laoreet sit amet cursus sit amet. Amet nulla facilisi morbi tempus iaculis urna id volutpat lacus. Massa vitae tortor condimentum lacinia quis vel eros donec.");
                book2.setPrice(28500);
                book2.setPublishedDate(LocalDate.now());
                book2.setRate(4);
                bookService.create(book2);

                BookDto book3 = new BookDto();
                book3.setId(3);
                book3.setName("Effective java");
                book3.setAuthor(AuthorDto.toEntity(author3));
                book3.setCategory(CategoryDto.toEntity(category));
                book3.setDescription("This Book is designed for absolute beginner to professional. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Euismod lacinia at quis risus sed vulputate odio. Amet consectetur adipiscing elit duis tristique. Nunc vel risus commodo viverra maecenas accumsan. Tristique senectus et netus et. Euismod lacinia at quis risus sed vulputate odio ut enim. Mauris in aliquam sem fringilla ut morbi tincidunt augue interdum. Tellus mauris a diam maecenas sed enim ut sem viverra. Eu facilisis sed odio morbi quis commodo. Ultricies mi eget mauris pharetra et. Nunc consequat interdum varius sit. Netus et malesuada fames ac turpis egestas sed tempus. Vitae elementum curabitur vitae nunc sed velit. Morbi tempus iaculis urna id volutpat lacus laoreet. Lectus quam id leo in vitae turpis massa. Viverra nam libero justo laoreet sit amet cursus sit amet. Amet nulla facilisi morbi tempus iaculis urna id volutpat lacus. Massa vitae tortor condimentum lacinia quis vel eros donec. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Euismod lacinia at quis risus sed vulputate odio. Amet consectetur adipiscing elit duis tristique. Nunc vel risus commodo viverra maecenas accumsan. Tristique senectus et netus et. Euismod lacinia at quis risus sed vulputate odio ut enim. Mauris in aliquam sem fringilla ut morbi tincidunt augue interdum. Tellus mauris a diam maecenas sed enim ut sem viverra. Eu facilisis sed odio morbi quis commodo. Ultricies mi eget mauris pharetra et. Nunc consequat interdum varius sit. Netus et malesuada fames ac turpis egestas sed tempus. Vitae elementum curabitur vitae nunc sed velit. Morbi tempus iaculis urna id volutpat lacus laoreet. Lectus quam id leo in vitae turpis massa. Viverra nam libero justo laoreet sit amet cursus sit amet. Amet nulla facilisi morbi tempus iaculis urna id volutpat lacus. Massa vitae tortor condimentum lacinia quis vel eros donec.");
                book3.setContent("1.Spring Core \n 2. Spring Boot \n Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Euismod lacinia at quis risus sed vulputate odio. Amet consectetur adipiscing elit duis tristique. Nunc vel risus commodo viverra maecenas accumsan. Tristique senectus et netus et. Euismod lacinia at quis risus sed vulputate odio ut enim. Mauris in aliquam sem fringilla ut morbi tincidunt augue interdum. Tellus mauris a diam maecenas sed enim ut sem viverra. Eu facilisis sed odio morbi quis commodo. Ultricies mi eget mauris pharetra et. Nunc consequat interdum varius sit. Netus et malesuada fames ac turpis egestas sed tempus. Vitae elementum curabitur vitae nunc sed velit. Morbi tempus iaculis urna id volutpat lacus laoreet. Lectus quam id leo in vitae turpis massa. Viverra nam libero justo laoreet sit amet cursus sit amet. Amet nulla facilisi morbi tempus iaculis urna id volutpat lacus. Massa vitae tortor condimentum lacinia quis vel eros donec.");
                book3.setPrice(27500);
                book3.setPublishedDate(LocalDate.now());
                book3.setRate(3);
                bookService.create(book3);
            } else {
                System.out.println("Book is already define!");
            }
        };

    }


}

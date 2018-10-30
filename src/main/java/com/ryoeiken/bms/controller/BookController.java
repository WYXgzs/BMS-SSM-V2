package com.ryoeiken.bms.controller;

import com.ryoeiken.bms.pojo.BookInfo;
import com.ryoeiken.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/allbooks.action")
    public String allBook(Model model) {
        List<BookInfo> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "admin_books";
    }
}

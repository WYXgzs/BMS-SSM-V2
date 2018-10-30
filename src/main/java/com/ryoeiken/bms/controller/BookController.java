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
        List<BookInfo> books = this.bookService.getAllBooks();
        model.addAttribute("books", books);
        return "admin_books";
    }

    @RequestMapping("/querybook.action")
    public String queryBookDo(String searchWord, Model model) {
        boolean exist = this.bookService.matchBook(searchWord);
        if (exist) {
            List<BookInfo> books = this.bookService.queryBook(searchWord);
            model.addAttribute("books", books);
            return "admin_books";
        } else {
            model.addAttribute("error", "没有匹配的图书");
            return "admin_books";
        }
    }

    @RequestMapping("/book_add.action")
    public String addBook() {
        return "admin_book_add";

    }

    @RequestMapping("/book_add_do.action")
    public String addBookDo(BookInfo bookInfo, Model model) {

        boolean succ = this.bookService.addBook(bookInfo);
        if (succ) {
            model.addAttribute("succ", "图书添加成功！");
            return "redirect:/allbooks.action";
        } else {
            model.addAttribute("succ", "图书添加失败！");
            return "redirect:/allbooks.action";
        }
    }

    @RequestMapping("/bookdetail.action")
    public String bookDetail(Long bookId, Model model) {
        BookInfo book = this.bookService.getBook(bookId);
        model.addAttribute("detail", book);
        return "admin_book_detail";
    }
}

package com.ryoeiken.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("book")
public class BookController {

    @RequestMapping("list")
    public String bookShow() {
        return "books";
    }
}

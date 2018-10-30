package com.ryoeiken.bms.service;

import com.ryoeiken.bms.pojo.BookInfo;

import java.util.List;

public interface BookService {
    List<BookInfo> getAllBooks();

    boolean matchBook(String searchWord);

    List<BookInfo> queryBook(String searchWord);

    boolean addBook(BookInfo bookInfo);

    BookInfo getBook(Long bookId);
}

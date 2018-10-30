package com.ryoeiken.bms.service.impl;

import com.ryoeiken.bms.mapper.BookInfoMapper;
import com.ryoeiken.bms.pojo.BookInfo;
import com.ryoeiken.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookInfoMapper bookInfoMapper;

    @Override
    public List<BookInfo> getAllBooks() {
        List<BookInfo> books = this.bookInfoMapper.selectByExample(null);
        return books;
    }
}

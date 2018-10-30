package com.ryoeiken.bms.service.impl;

import com.ryoeiken.bms.mapper.BookInfoMapper;
import com.ryoeiken.bms.pojo.BookInfo;
import com.ryoeiken.bms.pojo.BookInfoExample;
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

    @Override
    public boolean matchBook(String searchWord) {
        BookInfoExample bookInfoExample = new BookInfoExample();
        BookInfoExample.Criteria criteria = bookInfoExample.createCriteria();
        criteria.andNameLike("%" + searchWord + "%");
        return this.bookInfoMapper.countByExample(bookInfoExample) > 0;
    }

    @Override
    public List<BookInfo> queryBook(String searchWord) {
        BookInfoExample bookInfoExample = new BookInfoExample();
        BookInfoExample.Criteria criteria = bookInfoExample.createCriteria();
        criteria.andNameLike("%" + searchWord + "%");
        List<BookInfo> books = this.bookInfoMapper.selectByExample(bookInfoExample);
        return books;
    }

    @Override
    public boolean addBook(BookInfo bookInfo) {
        return this.bookInfoMapper.insertSelective(bookInfo) > 0;
    }
}

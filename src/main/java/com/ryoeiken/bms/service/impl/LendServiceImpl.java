package com.ryoeiken.bms.service.impl;

import com.ryoeiken.bms.mapper.BookInfoMapper;
import com.ryoeiken.bms.mapper.LendListMapper;
import com.ryoeiken.bms.pojo.BookInfo;
import com.ryoeiken.bms.pojo.BookInfoExample;
import com.ryoeiken.bms.pojo.LendList;
import com.ryoeiken.bms.pojo.LendListExample;
import com.ryoeiken.bms.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LendServiceImpl implements LendService {
    @Autowired
    private LendListMapper lendListMapper;

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Override
    public List<LendList> myLendList(Integer readerId) {
        LendListExample lendListExample = new LendListExample();
        LendListExample.Criteria criteria = lendListExample.createCriteria();
        criteria.andReaderIdEqualTo(readerId);
        List<LendList> lendLists = this.lendListMapper.selectByExample(lendListExample);
        return lendLists;
    }

    @Override
    public List<LendList> lendList() {
        List<LendList> list = this.lendListMapper.selectByExample(null);
        return list;
    }

    @Override
    public boolean deleteLog(Long sernum) {
        return this.lendListMapper.deleteByPrimaryKey(sernum) > 0;
    }

    @Override
    public boolean matchLog(Integer searchWord) {
        LendListExample lendListExample = new LendListExample();
        LendListExample.Criteria criteria = lendListExample.createCriteria();
        criteria.andReaderIdEqualTo(searchWord);
        return this.lendListMapper.countByExample(lendListExample) > 0;
    }


    @Override
    public boolean bookLend(Long bookId, Integer readerId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        try {
            Date lendDate = sdf.parse(date);

            LendList lendList = new LendList();
            lendList.setBookId(bookId);
            lendList.setReaderId(readerId);
            lendList.setLendDate(lendDate);
            int addSuc = this.lendListMapper.insertSelective(lendList);

            BookInfoExample bookInfoExample = new BookInfoExample();
            BookInfoExample.Criteria criteria = bookInfoExample.createCriteria();
            criteria.andBookIdEqualTo(bookId);

            BookInfo bookInfo = new BookInfo();
            bookInfo.setState((short) 0);
            int updateSuc = this.bookInfoMapper.updateByExampleSelective(bookInfo, bookInfoExample);

            return addSuc > 0 && updateSuc > 0;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean bookReturn(Long bookId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());

        try {
            Date backDate = sdf.parse(date);

            LendList lendList = new LendList();
            lendList.setBackDate(backDate);

            LendListExample lendListExample = new LendListExample();
            LendListExample.Criteria lendCriteria = lendListExample.createCriteria();
            lendCriteria.andBookIdEqualTo(bookId);

            int updateLendSuc = this.lendListMapper.updateByExampleSelective(lendList, lendListExample);

            BookInfo bookInfo = new BookInfo();
            bookInfo.setState((short) 1);

            BookInfoExample bookInfoExample = new BookInfoExample();
            BookInfoExample.Criteria bookCriteria = bookInfoExample.createCriteria();
            bookCriteria.andBookIdEqualTo(bookId);
            int updateBookSuc = this.bookInfoMapper.updateByExampleSelective(bookInfo, bookInfoExample);

            return updateLendSuc > 0 && updateBookSuc > 0;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}

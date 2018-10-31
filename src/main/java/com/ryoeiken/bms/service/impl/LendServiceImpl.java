package com.ryoeiken.bms.service.impl;

import com.ryoeiken.bms.mapper.LendListMapper;
import com.ryoeiken.bms.pojo.LendList;
import com.ryoeiken.bms.pojo.LendListExample;
import com.ryoeiken.bms.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendServiceImpl implements LendService {
    @Autowired
    private LendListMapper lendListMapper;


    @Override
    public List<LendList> myLendList(Integer readerId) {
        LendListExample lendListExample = new LendListExample();
        LendListExample.Criteria criteria = lendListExample.createCriteria();
        criteria.andReaderIdEqualTo(readerId);
        List<LendList> lendLists = this.lendListMapper.selectByExample(lendListExample);
        return lendLists;
    }
}

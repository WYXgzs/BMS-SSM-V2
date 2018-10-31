package com.ryoeiken.bms.service;

import com.ryoeiken.bms.pojo.LendList;

import java.util.List;

public interface LendService {
    List<LendList> myLendList(Integer readerId);

    List<LendList> lendList();

    boolean deleteLog(Long sernum);

    boolean matchLog(Integer searchWord);

    List<LendList> queryLog(Integer searchWord);
}

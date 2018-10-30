package com.ryoeiken.bms.service;

import com.ryoeiken.bms.pojo.ReaderInfo;

import java.util.List;

public interface ReaderInfoService {
    List<ReaderInfo> readerInfos();

    boolean deleteReaderInfo(Integer readerId);

    ReaderInfo getReaderInfo(Integer readerId);

    boolean editReader(ReaderInfo readerInfo);
}

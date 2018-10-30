package com.ryoeiken.bms.service.impl;

import com.ryoeiken.bms.mapper.ReaderInfoMapper;
import com.ryoeiken.bms.pojo.ReaderInfo;
import com.ryoeiken.bms.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderInfoServiceImpl implements ReaderInfoService {
    @Autowired
    private ReaderInfoMapper readerInfoMapper;

    @Override
    public List<ReaderInfo> readerInfos() {
        List<ReaderInfo> readerInfos = this.readerInfoMapper.selectByExample(null);
        return readerInfos;
    }
}

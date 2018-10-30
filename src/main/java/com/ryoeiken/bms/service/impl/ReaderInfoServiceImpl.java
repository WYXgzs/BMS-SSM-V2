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

    @Override
    public boolean deleteReaderInfo(Integer readerId) {
        return this.readerInfoMapper.deleteByPrimaryKey(readerId) > 0;
    }

    @Override
    public ReaderInfo getReaderInfo(Integer readerId) {
        return this.readerInfoMapper.selectByPrimaryKey(readerId);
    }

    @Override
    public boolean editReader(ReaderInfo readerInfo) {
        return this.readerInfoMapper.updateByPrimaryKeySelective(readerInfo) > 0;
    }

    @Override
    public boolean addReader(ReaderInfo readerInfo) {
        return this.readerInfoMapper.insertSelective(readerInfo) > 0;
    }
}

package com.ryoeiken.bms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ryoeiken.bms.mapper.ClassInfoMapper;
import com.ryoeiken.bms.pojo.ClassInfo;
import com.ryoeiken.bms.pojo.PageResult;
import com.ryoeiken.bms.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassInfoServiceImpl implements BookTypeService {
    @Autowired
    private ClassInfoMapper classInfoMapper;

    @Override
    public PageResult<ClassInfo> classInfos(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ClassInfo> classInfos = this.classInfoMapper.selectByExample(null);
        PageInfo<ClassInfo> pageInfo = new PageInfo<>(classInfos);
        long total = pageInfo.getTotal();
        int pages = pageInfo.getPages();
        PageResult<ClassInfo> page = new PageResult<>();
        page.setList(classInfos);
        page.setPageNum(pageNum);
        page.setPages(pages);
        page.setPageSize(pageSize);
        page.setTotal(total);

        return page;
    }

    @Override
    public boolean deleteClassInfo(Integer readerId) {
        return this.classInfoMapper.deleteByPrimaryKey(readerId) > 0;
    }

    @Override
    public ClassInfo getClassInfo(Integer readerId) {
        return this.classInfoMapper.selectByPrimaryKey(readerId);
    }

    @Override
    public boolean editBookType(ClassInfo classInfo) {
        return this.classInfoMapper.updateByPrimaryKeySelective(classInfo) > 0;
    }

    @Override
    public boolean addBookType(ClassInfo classInfo) {
        return this.classInfoMapper.insertSelective(classInfo) > 0;
    }
}

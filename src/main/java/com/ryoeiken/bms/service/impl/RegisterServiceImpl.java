package com.ryoeiken.bms.service.impl;

import com.ryoeiken.bms.mapper.ReaderCardMapper;
import com.ryoeiken.bms.mapper.ReaderInfoMapper;
import com.ryoeiken.bms.pojo.ReaderCard;
import com.ryoeiken.bms.pojo.ReaderInfo;
import com.ryoeiken.bms.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private ReaderCardMapper readerCardMapper;

    @Autowired
    private ReaderInfoMapper readerInfoMapper;

    @Override
    public boolean addReaderCard(Integer readerId, String name, String passwd, String sex, Date birth, String address,
                                 String telcode) {
        ReaderCard readerCard = new ReaderCard();
        readerCard.setReaderId(readerId);
        readerCard.setName(name);
        readerCard.setPasswd(passwd);

        ReaderInfo readerInfo = new ReaderInfo();
        readerInfo.setReaderId(readerId);
        readerInfo.setName(name);
        readerInfo.setSex(sex);
        readerInfo.setBirth(birth);
        readerInfo.setAddress(address);
        readerInfo.setTelcode(telcode);

        try {
            this.readerInfoMapper.insertSelective(readerInfo);
            this.readerCardMapper.insertSelective(readerCard);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

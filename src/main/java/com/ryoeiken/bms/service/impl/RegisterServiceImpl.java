package com.ryoeiken.bms.service.impl;

import com.ryoeiken.bms.mapper.ReaderCardMapper;
import com.ryoeiken.bms.pojo.ReaderCard;
import com.ryoeiken.bms.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private ReaderCardMapper readerCardMapper;

    @Override
    public boolean addReaderCard(Integer readerId, String name, String passwd) {
        ReaderCard readerCard = new ReaderCard();
        readerCard.setReaderId(readerId);
        readerCard.setName(name);
        readerCard.setPasswd(passwd);

        try {
            this.readerCardMapper.insertSelective(readerCard);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

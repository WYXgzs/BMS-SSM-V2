package com.ryoeiken.bms.service;

public interface RegisterService {
    boolean addReaderCard(Integer readerId, String name, String passwd);
}

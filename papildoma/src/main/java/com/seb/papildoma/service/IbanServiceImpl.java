package com.seb.papildoma.service;

import com.seb.papildoma.dao.IbanRepository;
import com.seb.papildoma.entity.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IbanServiceImpl implements IbanService {

    @Autowired
    IbanRepository ibanRepository;

    @Override
    public List<Iban> findAll() {
        return ibanRepository.findAll();
    }

    @Override
    public void save(Iban iban) {
        ibanRepository.save(iban);
    }
}

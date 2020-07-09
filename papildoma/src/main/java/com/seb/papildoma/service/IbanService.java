package com.seb.papildoma.service;

import com.seb.papildoma.entity.Iban;
import java.util.*;
public interface IbanService {

    List<Iban> findAll();

    void save(Iban iban);
}

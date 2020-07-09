package com.seb.papildoma.rest;


import com.seb.papildoma.entity.Iban;
import com.seb.papildoma.service.IbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/")
public class IbanRestController {


    @Autowired
    IbanService ibanService;

    @GetMapping("/ibans")
    public List<Iban> findAll(){
        return ibanService.findAll();
    }

    @PostMapping("/ibans")
    public Iban addIban(@Valid @RequestBody Iban iban){
        iban.setIbanId(0);

        ibanService.save(iban);

        return iban;
    }
}

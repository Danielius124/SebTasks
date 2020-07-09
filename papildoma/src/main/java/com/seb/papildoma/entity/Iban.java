package com.seb.papildoma.entity;

import com.seb.papildoma.validations.IbanValid;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ibans")
public class Iban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long ibanId;

    @IbanValid
    @Column(name = "iban")
    private String iban;

    public Iban(){}
}

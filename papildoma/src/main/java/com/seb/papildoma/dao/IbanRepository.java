package com.seb.papildoma.dao;

import com.seb.papildoma.entity.Iban;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IbanRepository extends JpaRepository<Iban, Long> {
}

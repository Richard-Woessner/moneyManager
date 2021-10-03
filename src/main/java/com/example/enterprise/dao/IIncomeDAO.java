package com.example.enterprise.dao;

import com.example.enterprise.dto.Income;

import java.util.List;

public interface IIncomeDAO {
    void save(Income income) throws Exception;
    List<Income> listAll();
}

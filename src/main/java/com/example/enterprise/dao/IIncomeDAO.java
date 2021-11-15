package com.example.enterprise.dao;

import com.example.enterprise.dto.Income;

import java.util.List;


public interface IIncomeDAO {
    Income save(Income income) throws Exception;
    List<Income> listAll();
    Income getIncome(int id);
    void delete(int id);
}

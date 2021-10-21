package com.example.enterprise.dao;

import com.example.enterprise.dto.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class IncomeSQLDAO implements IIncomeDAO{

    @Autowired
    IncomeRepository incomeRepository;


    @Override
    public void save(Income income) throws Exception {
        Income newIncome = incomeRepository.save(income);

    }

    @Override
    public List<Income> listAll() {
        return null;
    }
}

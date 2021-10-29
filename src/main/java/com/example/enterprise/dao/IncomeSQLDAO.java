package com.example.enterprise.dao;

import com.example.enterprise.dto.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class IncomeSQLDAO implements IIncomeDAO {

    @Autowired
    IncomeRepository incomeRepository;

    @Override
    public Income save(Income income) throws Exception {
        Income newIncome = incomeRepository.save(income);
        return newIncome;
    }

    @Override
    public List<Income> listAll() {
        List<Income> incomeArr = new ArrayList<Income>();
        incomeRepository.toString();
        System.out.println(incomeRepository.toString());
        return incomeArr;
    }
}

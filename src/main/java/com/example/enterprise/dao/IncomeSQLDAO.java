package com.example.enterprise.dao;

import com.example.enterprise.dto.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile({"dev", "default"})
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
        List<Income> incomeArr = new ArrayList<>();
        Iterable<Income> incomeIterable = incomeRepository.findAll();
        for (Income income : incomeIterable) {
            incomeArr.add(income);
        }
        System.out.println(incomeRepository.toString());
        return incomeArr;
    }

    @Override
    public Income getIncome(int id) {
        return incomeRepository.findById(id).get();
    }

    @Override
    public void delete(Income income) {
        incomeRepository.delete(income);
    }
}

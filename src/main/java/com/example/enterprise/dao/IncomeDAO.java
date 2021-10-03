package com.example.enterprise.dao;

import com.example.enterprise.dto.Income;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IncomeDAO implements IIncomeDAO{

    List<Income> allIncomeSources = new ArrayList<>();

    @Override
    public void save(Income income) throws Exception {
        allIncomeSources.add(income);
    }

    @Override
    public List<Income> listAll() {
        return allIncomeSources;
    }
}

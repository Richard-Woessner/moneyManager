package com.example.enterprise.dao;

import com.example.enterprise.dto.Income;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("test")
public class IncomeDAO implements IIncomeDAO{

    List<Income> allIncomeSources = new ArrayList<>();

    @Override
    public Income save(Income income) throws Exception {
        allIncomeSources.add(income);
        return income;
    }

    @Override
    public List<Income> listAll() {
        return allIncomeSources;
    }
}

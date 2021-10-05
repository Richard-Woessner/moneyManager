package com.example.enterprise.dao;

import com.example.enterprise.dto.Income;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IncomeDAO implements IIncomeDAO{

    List<Income> allIncomeSources = new ArrayList<>();

    /**
     * Save an income to the allIncomeSources arraylist
     * @param income an expense given by user
     * @throws Exception
     */
    @Override
    public void save(Income income) throws Exception {
        allIncomeSources.add(income);
    }

    /**
     * List all entered incomes in allIncomeSources arraylist
     * @return allIncomeSources arraylist
     */
    @Override
    public List<Income> listAll() {
        return allIncomeSources;
    }
}

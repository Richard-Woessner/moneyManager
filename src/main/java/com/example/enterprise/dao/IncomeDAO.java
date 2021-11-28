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

    /**
     * Save an income to the allIncomeSources arraylist
     * @param income an expense given by user
     * @throws Exception
     */
    @Override
    public Income save(Income income) throws Exception {
        allIncomeSources.add(income);
        return income;
    }

    /**
     * List all entered incomes in allIncomeSources arraylist
     * @return allIncomeSources arraylist
     */
    @Override
    public List<Income> listAll() {
        return allIncomeSources;
    }

    @Override
    public Income getIncome(int id) {
        return allIncomeSources.get(id);
    }

    @Override
    public Income updateIncome(Income income) {
        return allIncomeSources.set(income.getIncomeID(), income);
    }

    @Override
    public void delete(int id) {
        allIncomeSources.remove(id);
    }
}

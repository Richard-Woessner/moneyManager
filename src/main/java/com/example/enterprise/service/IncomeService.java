package com.example.enterprise.service;

import com.example.enterprise.dao.IIncomeDAO;
import com.example.enterprise.dto.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService implements IIncomeService{

    @Autowired
    private IIncomeDAO incomeSourceDAO;

    public IncomeService(){

    }

    public IncomeService(IIncomeDAO incomeDAO){
        this.incomeSourceDAO = incomeDAO;
    }

    @Override
    public void save(Income income) {
        try {
            incomeSourceDAO.save(income);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Income> listAll() {
        return incomeSourceDAO.listAll();
    }

    @Override
    public Income searchByID(int id) {
        Income income = new Income();
        income.setSource("Savings Interest");
        income.setIncomeID(25);
        return income;
    }
}

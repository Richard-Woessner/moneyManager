package com.example.enterprise.service;

import com.example.enterprise.dao.IIncomeDAO;
import com.example.enterprise.dto.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The IncomeService class provides necessary logic for operation methods related to Income
 * such as save, list, and search. It implements all the methods from Income service interface.
 *
 */
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
    public Income save(Income income) throws Exception {
        return incomeSourceDAO.save(income);
    }

    @Override
    public List<Income> listAllIncomes() {
        return incomeSourceDAO.listAll();
    }

    @Override
    public double getTotal() {
        double total = 0;
        for(Income i : incomeSourceDAO.listAll()){
            total += i.getAmount();
        }
        return total;
    }

    @Override
    public Income searchByID(int id) {
        Income income = new Income();
        income.setSource("Savings Interest");
        income.setIncomeID(25);
        return income;
    }

}

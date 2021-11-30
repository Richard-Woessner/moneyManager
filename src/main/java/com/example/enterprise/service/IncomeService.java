package com.example.enterprise.service;

import com.example.enterprise.dao.IIncomeDAO;
import com.example.enterprise.dto.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    public Income save(Income income) throws Exception {
        return incomeSourceDAO.save(income);
    }

    @Override
    @Cacheable("incomeItems")
    public List<Income> listAll() {
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
    @Cacheable(value="income", key = "#id")
    public Income searchByID(int id) {
        Income income = incomeSourceDAO.getIncome(id);
        return income;
    }

    @Override
    @CacheEvict(value="income", key = "#id")
    public void deleteByID(int id) {
        incomeSourceDAO.delete(id);
    }

    @Override
    public Income updateIncome(Income income) {
        return incomeSourceDAO.updateIncome(income);
    }

    @Override
    public double calcIncAverage(Income income) {
        int freq = income.getFrequency();
        double amt = income.getAmount();
        double monthlyAverage = (amt / freq) * 30.4167;
        return monthlyAverage;
    }


}

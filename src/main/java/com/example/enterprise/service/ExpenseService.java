package com.example.enterprise.service;

import com.example.enterprise.dao.ExpenseDAO;
import com.example.enterprise.dao.IExpenseDAO;
import com.example.enterprise.dto.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService implements IExpenseService{

    @Qualifier("expenseSQLDAO")
    @Autowired
    private IExpenseDAO expenseDAO;

    public ExpenseService(){

    }

    public ExpenseService(ExpenseDAO expenseDAO){
        this.expenseDAO = expenseDAO;
    }

    @Override
    @Cacheable("expenses")
    public void save(Expense expense) {
        expenseDAO.save(expense);
    }

    @Override
    public List<Expense> showAll() {
        return expenseDAO.showAll();
    }

    @Override
    @Cacheable(value="expense", key = "#id")
    public Expense searchByID(int id) {
        Expense expense = expenseDAO.getExpense(id);
        return expense;
    }

    @Override
    public double getTotal() {
        double total = 0;
        for(Expense i : expenseDAO.showAll()){
            total += i.getAmount();
        }
        return total;
    }

    @Override
    public List<Expense> listAll() { return expenseDAO.showAll(); }

    @Override
    public Expense updateExpense(Expense expense) {
        expenseDAO.updateExpense(expense);
        return expense;
    }

    @Override
    @CacheEvict(value="expense", key = "#id")
    public void deleteByID(int id) {
        expenseDAO.delete(id);
    }
}

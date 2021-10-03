package com.example.enterprise.service;

import com.example.enterprise.dao.ExpenseDAO;
import com.example.enterprise.dao.IExpenseDAO;
import com.example.enterprise.dto.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService implements IExpenseService{

    @Autowired
    private IExpenseDAO expenseDAO;

    public ExpenseService(){

    }

    public ExpenseService(ExpenseDAO expenseDAO){
        this.expenseDAO = expenseDAO;
    }

    @Override
    public void save(Expense expense) {
        expenseDAO.save(expense);
    }

    @Override
    public List<Expense> showAll() {
        return expenseDAO.showAll();
    }
}

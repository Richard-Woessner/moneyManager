package com.example.enterprise.dao;

import com.example.enterprise.dto.Expense;
import com.example.enterprise.dto.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExpenseSQLDAO implements IExpenseDAO{

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public void save(Expense expense) { expenseRepository.save(expense); }

    @Override
    public List<Expense> showAll() {
        List<Expense> expenseArr = new ArrayList<>();
        Iterable<Expense> expenseIterable = expenseRepository.findAll();
        for (Expense expense : expenseIterable){
            expenseArr.add(expense);
        }
        return expenseArr;
    }


    @Override
    public Expense getExpense(int id) {
        return expenseRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        expenseRepository.deleteById(id);
    }
}

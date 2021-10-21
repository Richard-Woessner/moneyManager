package com.example.enterprise.dao;

import com.example.enterprise.dto.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class ExpenseSQLDAO implements IExpenseDAO{



   @Autowired
   ExpenseRepository expenseRepository;

    @Override
    public void save(Expense expense) {
        Expense newExpense = expenseRepository.save(expense);

    }

    @Override
    public List<Expense> showAll() {
        return null;
    }
}

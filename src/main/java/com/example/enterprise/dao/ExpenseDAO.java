package com.example.enterprise.dao;

import com.example.enterprise.dto.Expense;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExpenseDAO implements IExpenseDAO{

    List<Expense> allExpenses = new ArrayList<>();

    @Override
    public void save(Expense expense){
        allExpenses.add(expense);
    }

    @Override
    public List<Expense> showAll(){
        return allExpenses;
    }

    @Override
    public Expense getExpense(int id) {
        return allExpenses.get(id);
    }

    @Override
    public void delete(int id) {
        allExpenses.remove(id);
    }
}

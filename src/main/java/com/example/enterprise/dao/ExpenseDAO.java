package com.example.enterprise.dao;

import com.example.enterprise.dto.Expense;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExpenseDAO implements IExpenseDAO{

    List<Expense> allExpenses = new ArrayList<>();

    /**
     * Save an expense to the allExpenses arraylist
     * @param expense an expense given by user
     * @throws Exception
     */
    @Override
    public void save(Expense expense) throws Exception {
        allExpenses.add(expense);
    }

    /**
     * List all entered expenses in allExpenses arraylist
     * @return allExpense arraylist
     */
    @Override
    public List<Expense> showAll(){
        return allExpenses;
    }
}

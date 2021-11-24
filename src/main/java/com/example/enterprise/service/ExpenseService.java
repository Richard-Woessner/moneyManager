package com.example.enterprise.service;

import com.example.enterprise.dao.ExpenseDAO;
import com.example.enterprise.dao.IExpenseDAO;
import com.example.enterprise.dto.Expense;
import com.example.enterprise.dto.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The ExpenseService class provides necessary logic for operation methods related to Expense
 * such as save, list, and search. It implements all the methods from Expense service interface.
 *
 */
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
    public void save(Expense expense) {
        try {
            expenseDAO.save(expense);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Expense> showAllExpenses() {
        return expenseDAO.showAll();
    }

    @Override
    public Expense searchByID(int id) {
        Expense expense = new Expense();
        expense.setName("Rent");
        expense.setExpenseID(1);
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
}

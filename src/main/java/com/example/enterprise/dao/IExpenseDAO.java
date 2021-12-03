package com.example.enterprise.dao;

import com.example.enterprise.dto.Expense;

import java.util.List;

public interface IExpenseDAO {
    /**
     * @param expense expense object to add to DB
     */
    void save(Expense expense);

    /**
     * @return A List of all Expense records from the db
     */
    List<Expense> showAll();

    /**
     * @param id Expense id
     * @return Expense record with id given
     */
    Expense getExpense(int id);

    /**
     * @param expense Expense object to Update in DB
     * @return Updated Expense record
     */
    Expense updateExpense(Expense expense);

    /**
     * @param id Expense id to remove from DB
     */
    void delete(int id);
}

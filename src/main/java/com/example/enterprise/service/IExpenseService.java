package com.example.enterprise.service;

import com.example.enterprise.dto.Expense;

import java.util.List;

/**
 * Expense Service handles business logic for Expense DTOs.
 */
public interface IExpenseService {

    /**
     * Save a new expense
     * @param expense the entry to save.
     */
    void save(Expense expense);

    /**
     * Return all saved expenses.
     * @return a collection of all expense entries.
     */
    List<Expense> showAll();


    /**
     * @param id expense record ID
     * @return expense record
     */
    Expense searchByID(int id);

    /**
     * @return the total of all income amounts
     */
    double getTotal();

    /**
     * Return all saved expense sources.
     * @return a collection of all expense entries.
     */
    List<Expense> listAll();

    /**
     * Updates a Expense record in the DB
     * @param expense Expense object in DB to update
     * @return Updated Expense Object
     */
    Expense updateExpense(Expense expense);

    /**
     * Deletes Expense object from DB
     * @param id Expense ID
     */
    void deleteByID(int id);
}

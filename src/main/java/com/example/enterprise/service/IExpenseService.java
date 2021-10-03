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

    Expense searchByID(int id);
}

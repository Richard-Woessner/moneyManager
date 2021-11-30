package com.example.enterprise.service;

import com.example.enterprise.dto.Income;

import java.util.List;

/**
 * Income Service handles business logic for Income DTOs.
 */
public interface IIncomeService {
    /**
     * Save a new income source
     * @param income the entry to save.
     * @return
     */
    Income save (Income income) throws Exception;

    /**
     * Return all saved income sources.
     * @return a collection of all income entries.
     */
    List<Income> listAll();


    /**
     * @return the total of all income amounts
     */
    double getTotal();

    /**
     * Return an income source with a given ID.
     * @param id a unique identifier for a specific income source.
     * @return a matching income, or null if no matches are found.
     */
    Income searchByID(int id);

    void deleteByID(int id);

    Income updateIncome(Income income);

    public double calcIncAverage(Income income);
}

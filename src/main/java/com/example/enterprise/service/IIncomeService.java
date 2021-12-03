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


    /**
     * Deletes a single Income Record
     * @param id Income ID
     */
    void deleteByID(int id);

    /**
     * @param income A income Object in the Database
     * @return Updated Income Object
     */
    Income updateIncome(Income income);

    /**
     * @param income Income Object
     * @return Income's average total for a month
     */
    double calcIncAverage(Income income);
}

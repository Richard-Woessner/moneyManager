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
     */
    void save (Income income);

    /**
     * Return all saved income sources.
     * @return a collection of all income entries.
     */
    List<Income> listAll();
}

package com.example.enterprise.dao;

import com.example.enterprise.dto.Income;

import java.util.List;


public interface IIncomeDAO {
    /**
     * @param income Income Object to insert into the DB
     * @return new Income Object from DB
     */
    Income save(Income income) throws Exception;

    /**
     * @return List of all Income Records from DB
     */
    List<Income> listAll();

    /**
     * @param id Income id
     * @return Income Object from DB with id provided
     */
    Income getIncome(int id);

    /**
     * @param income altered Income object to update
     * @return updated Income Object
     */
    Income updateIncome(Income income);

    /**
     * @param id id of Income record to delete
     */
    void delete(int id);
}

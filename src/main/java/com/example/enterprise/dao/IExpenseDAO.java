package com.example.enterprise.dao;

import com.example.enterprise.dto.Expense;

import java.util.List;

public interface IExpenseDAO {
    void save(Expense expense);
    List<Expense> showAll();
}

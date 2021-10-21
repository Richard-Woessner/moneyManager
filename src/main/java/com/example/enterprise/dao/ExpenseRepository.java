package com.example.enterprise.dao;

import com.example.enterprise.dto.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, String> {
}

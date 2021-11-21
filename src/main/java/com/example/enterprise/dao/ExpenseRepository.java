package com.example.enterprise.dao;

import com.example.enterprise.dto.Expense;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Profile("!test")
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {

    //List<Expense> findByExpenseId(int expenseId);

}

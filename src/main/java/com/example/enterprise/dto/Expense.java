package com.example.enterprise.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public @Data class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int expenseID;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private double amount;
    private String dueDate;
    private String category;
    private String note;
}

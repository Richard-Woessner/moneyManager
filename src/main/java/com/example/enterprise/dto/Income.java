package com.example.enterprise.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public @Data class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int incomeID;

    private String source;
    private double amount;
    private int frequency;
    private String depositDate;
    private String note;
}

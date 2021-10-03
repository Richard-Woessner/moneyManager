package com.example.enterprise.service;

import com.example.enterprise.dto.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyMakerServiceStub implements IMoneyMakerService {

    public static void save(Income income) {
    }

    @Override
    public Income fetchById(int id) {
        return null;
    }
}

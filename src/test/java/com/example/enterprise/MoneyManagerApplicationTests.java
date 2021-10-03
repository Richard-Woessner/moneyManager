package com.example.enterprise;

import com.example.enterprise.dto.Expense;
import com.example.enterprise.dto.Income;
import com.example.enterprise.service.IExpenseService;
import com.example.enterprise.service.IIncomeService;
import com.example.enterprise.service.IncomeService;
import com.example.enterprise.service.MoneyMakerServiceStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MoneyManagerApplicationTests {

    @Autowired
    IIncomeService incomeService;

    @Autowired
    IExpenseService expenseService;

    @Test
    void contextLoads() {

    }
//    Test idea

//    Add income
    @Test
    void addAndSaveANewIncome(){
        String incomeSource = "Employment";
        int id = 0;
        double incomeAmount = 500.00;
        int incomeFrequency = 7;
        Date nextDepositDate = new Date("October 08, 2021");
        String notes = "Full time job.";


        Income income = new Income();
        income.setSource(incomeSource);
        income.setIncomeID(id);
        income.setAmount(incomeAmount);
        income.setFrequency(incomeFrequency);
        income.setDepositDate(nextDepositDate);
        income.setNote(notes);

        incomeService.save(income);

        List<Income> incomeEntries =incomeService.listAll();
        boolean checkNewIncome = false;
        for(Income i : incomeEntries){
            if(i.getSource().equals(incomeSource) && i.getIncomeID() == id){
                checkNewIncome = true;
                break;
            }
        }
    }
//    Add expense
    @Test
    void addAndSaveANewExpense(){
        String expenseName = "Phone Bill";
        int id = 0;
        double cost = 120.00;
        Date dueDate = new Date("November 01, 2021");
        String category = "Necessity";
        String notes = "Verizon";

        Expense newExpense = new Expense();
        newExpense.setName(expenseName);
        newExpense.setExpenseID(id);
        newExpense.setAmount(cost);
        newExpense.setCategory(category);
        newExpense.setNote(notes);

        expenseService.save(newExpense);

        List<Expense> expenseEntries = expenseService.showAll();
        boolean checkNewExpense = false;
        for(Expense e : expenseEntries){
            if(e.getName().equals(expenseName) && e.getAmount() == cost){
                checkNewExpense = true;
                break;
            }
        }
    }
//    Delete income
//    Delete expense
//    Get Income
    @Test
    void checkReturnIncomeList(){
        incomeService.listAll();
    }
//    Get Expense
    @Test
    void checkReturnExpensesList(){
        expenseService.showAll();
    }
//    Update Income
//    Update Expense

}

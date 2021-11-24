package com.example.enterprise;

import com.example.enterprise.dto.Expense;
import com.example.enterprise.dto.Income;
import com.example.enterprise.service.IExpenseService;
import com.example.enterprise.service.IIncomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MoneyManagerApplicationTests {

    @Autowired
    private IIncomeService incomeService;
    private Income income;

    @Autowired
    private IExpenseService expenseService;
    private Expense expense;

    @Test
    void contextLoads() {

    }

    //    Add income
    @Test
    void addAndSaveANewIncome() {
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

        List<Income> incomeEntries = incomeService.listAllIncomes();
        boolean checkNewIncome = false;
        for (Income i : incomeEntries) {
            if (i.getSource().equals(incomeSource) && i.getIncomeID() == id) {
                checkNewIncome = true;
                break;
            }
        }
    }

    //    Add expense
    @Test
    void addAndSaveANewExpense() {
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

        List<Expense> expenseEntries = expenseService.showAllExpenses();
        boolean checkNewExpense = false;
        for (Expense e : expenseEntries) {
            if (e.getName().equals(expenseName) && e.getAmount() == cost) {
                checkNewExpense = true;
                break;
            }
        }
    }

    //    TODO: Delete income
//    TODO: Delete expense
//    Get Income
    @Test
    void checkReturnIncomeList() {
        incomeService.listAllIncomes();
    }

    //    Get Expense
    @Test
    void checkReturnExpensesList() {
        expenseService.showAllExpenses();
    }

    @Test
    void viewIncomeItemDetails() {
        givenIncomeItemsExist();
        whenSearchForID25();
        thenReturnOneIncomeItemWithID25();

    }

    private void givenIncomeItemsExist() {
    }

    private void whenSearchForID25() {
        income = incomeService.searchByID(25);
    }

    private void thenReturnOneIncomeItemWithID25() {
        String name = income.getSource();
        assertEquals("Savings Interest", name);
    }

    @Test
    void viewExpenseItemDetails() {
        givenExpenseItemsExist();
        whenSearchForID1();
        thenReturnOneExpenseItemWithID1();
    }

    private void givenExpenseItemsExist() {
    }

    private void whenSearchForID1() {
        expense = expenseService.searchByID(1);
    }

    private void thenReturnOneExpenseItemWithID1() {
        String name = expense.getName();
        assertEquals("Rent", name);
    }
//    TODO: Update Income
//    TODO: Update Expense

}

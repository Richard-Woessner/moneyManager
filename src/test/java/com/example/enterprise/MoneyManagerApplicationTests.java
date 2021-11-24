package com.example.enterprise;

import com.example.enterprise.dao.IIncomeDAO;
import com.example.enterprise.dto.Expense;
import com.example.enterprise.dto.Income;
import com.example.enterprise.service.IExpenseService;
import com.example.enterprise.service.IIncomeService;
import com.example.enterprise.service.IncomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MoneyManagerApplicationTests {

    private IIncomeService incomeService;
    private Income income = new Income();

    private IExpenseService expenseService;
    private Expense expense = new Expense();

    @MockBean
    private IIncomeDAO incomeDAO;

    @Test
    void contextLoads() {

    }

//    Add income
    @Test
    void addAndSaveANewIncome() throws Exception {
        givenIncomeDataIsAvailable();
        String incomeSource = "Employment";
        int id = 0;
        double incomeAmount = 500.00;
        int incomeFrequency = 7;
        String nextDepositDate = "October 08, 2021";
        String notes = "Full time job.";


        Income income = new Income();
        income.setSource(incomeSource);
        income.setIncomeID(id);
        income.setAmount(incomeAmount);
        income.setFrequency(incomeFrequency);
        income.setDepositDate(nextDepositDate);
        income.setNote(notes);

        Income newIncome = incomeService.save(income);

        assertEquals(income, newIncome);
    }

    private void givenIncomeDataIsAvailable() throws Exception {
        Mockito.when(incomeDAO.save(income)).thenReturn(income);
        incomeService = new IncomeService(incomeDAO);
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

        List<Expense> expenseEntries = expenseService.showAllExpenses();
        boolean checkNewExpense = false;
        for(Expense e : expenseEntries){
            if(e.getName().equals(expenseName) && e.getAmount() == cost){
                checkNewExpense = true;
                break;
            }
        }
    }
//    TODO: Delete income
//    TODO: Delete expense
//    Get Income
    @Test
    void checkReturnIncomeList(){
        incomeService.listAllIncomes();
    }
//    Get Expense
    @Test
    void checkReturnExpensesList(){
        expenseService.showAllExpenses();
    }

    @Test
    void viewIncomeItemDetails(){
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
    void viewExpenseItemDetails(){
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

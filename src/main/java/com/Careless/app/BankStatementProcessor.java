package com.Careless.app;

import java.time.Month;
import java.util.List;
import java.util.ArrayList;

public class BankStatementProcessor {
    private List<BankTransaction> transactions;

    public BankStatementProcessor(List<BankTransaction> transactions){
        this.transactions = transactions;
    }

    private double truncate(double value){
        value=value*Math.pow(10,3);
        value = Math.floor(value);
        value = value/Math.pow(10,3);
        return value;
    }

    public double calculateTotalAmount(){
        double amount = 0d;
            for(BankTransaction transaction: transactions){
                amount += transaction.getAmount();       
            }
        amount = truncate(amount);
        return amount;
    }

    public double selectInMonth(final Month month){
        final List<BankTransaction> bankTRansactionsInMonth = new ArrayList<>(); 
        double total = 0d;
            for(final BankTransaction bk : transactions){
            if(bk.getDate().getMonth() == month){
                bankTRansactionsInMonth.add(bk);
                total += bk.getAmount();
            }
        }
        return total;
    }
    public double calculateTotalForCategory(final String category){
        double total = 0d; 
        for(BankTransaction trans: transactions){
            if(trans.getDescription().equals(category)){
                total+=trans.getAmount();
            }
        }
        return total;
    }

}

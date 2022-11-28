package com.Careless.app;

import java.time.Month;
import java.util.List;
import java.util.ArrayList;

public class BankStatementProcessor {

    private static double truncate(double value){
        value=value*Math.pow(10,3);
        value = Math.floor(value);
        value = value/Math.pow(10,3);
        return value;
    }

    public static double calculateTotalAmount(final List<BankTransaction> transactions){
        double amount = 0d;
            for(BankTransaction transaction: transactions){
                amount += transaction.getAmount();       
            }
        amount = truncate(amount);
        return amount;
    }

    public static double selectInMonth(final List<BankTransaction> banktransactions, final Month month){
        final List<BankTransaction> bankTRansactionsInMonth = new ArrayList<>(); 
        double total = 0d;
            for(final BankTransaction bk : banktransactions){
            if(bk.getDate().getMonth() == month){
                bankTRansactionsInMonth.add(bk);
                total += bk.getAmount();
            }
        }
        return total;
    }

}

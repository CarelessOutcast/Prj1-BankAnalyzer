package com.Careless.app;

import java.time.Month;
import java.util.List;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

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


    public Summarizer summarizeTransactions(){
        DoubleSummaryStatistics summary = transactions.stream().mapToDouble(BankTransaction::getAmount)
                .summaryStatistics();
        return new Summarizer(summary.getSum(), summary.getMax(), summary.getMin(),summary.getAverage());
    }

    public List<BankTransaction> findTransaction(final InterfaceTransactionFilter filter){
        List<BankTransaction> result = new ArrayList<>();
        for(BankTransaction transaction: transactions){
            if (filter.test(transaction)) {
                result.add(transaction);
            }
        }
        return result; 
    }

    public double summarizeTransactions(final InterfaceTransactionSummarizer summarizer){
    double result = 0d;
        for(final BankTransaction transaction: transactions){
            result = summarizer.summarize(result, transaction);
        }
        return result;
    }
    public double totalInMonth(final Month month){
        return summarizeTransactions((acc,trans) -> {
          return trans.getDate().getMonth() == month ? acc + trans.getAmount():acc;
        });
    }


}

    // public double calculateTotalAmount(){
    //     double amount = 0d;
    //         for(BankTransaction transaction: transactions){
    //             amount += transaction.getAmount();       
    //         }
    //     amount = truncate(amount);
    //     return amount;
    // }

    // public double selectInMonth(final Month month){
    //     final List<BankTransaction> bankTRansactionsInMonth = new ArrayList<>(); 
    //     double total = 0d;
    //         for(final BankTransaction bk : transactions){
    //         if(bk.getDate().getMonth() == month){
    //             bankTRansactionsInMonth.add(bk);
    //             total += bk.getAmount();
    //         }
    //     }
    //     return total;
    // }

    // public double calculateTotalForCategory(final String category){
    //     double total = 0d; 
    //     for(BankTransaction trans: transactions){
    //         if(trans.getDescription().equals(category)){
    //             total+=trans.getAmount();
    //         }
    //     }
    //     return total;
    // }

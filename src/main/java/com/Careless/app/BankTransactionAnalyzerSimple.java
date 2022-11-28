package com.Careless.app;

import java.io.IOException;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;

class BankTransactionAnalyzerSimple {
    // private static final String RESOURCES = "src/main/resources/";
    private static BankTransactionParser bankTransactionParser = new BankTransactionParser();

    public static void main(String[] args) throws 
        IOException {
            // final Path path = Paths.get(RESOURCES + args[0]);
            final Path path = Paths.get("transactions.csv");
            final List<String> lines = Files.readAllLines(path);

            List<BankTransaction> transactions = bankTransactionParser.parseLineSFromCSV(lines);
            
            System.out.println("The amount is "+ BankStatementProcessor.calculateTotalAmount(transactions));
            System.out.println("The amount for November is "+ BankStatementProcessor.selectInMonth(transactions,Month.NOVEMBER));
        }
}


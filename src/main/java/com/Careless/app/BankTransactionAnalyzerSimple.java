package com.Careless.app;

import java.io.IOException;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;

class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";
    private static final String FILE = "transaction.csv";

    public static void analyze(String args, InnerBankTransactionParser Parser) throws 
        IOException {
            // final Path path = Paths.get(RESOURCES + args[0]);
            final Path path = Paths.get(RESOURCES + FILE);
            final List<String> lines = Files.readAllLines(path);

            List<BankTransaction> transactions = Parser.parseLineSFrom(lines);
            BankStatementProcessor processor  = new BankStatementProcessor(transactions);

            CollectSummary(processor);
        }

    private static void CollectSummary(final BankStatementProcessor processor){
            System.out.println("The amount is "+ processor.calculateTotalAmount());
            System.out.println("The amount for November is "+ processor.selectInMonth(Month.NOVEMBER));
        
    }
    
}



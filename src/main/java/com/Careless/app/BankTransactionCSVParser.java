package com.Careless.app;

import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


public class BankTransactionCSVParser implements InnerBankTransactionParser {
            final static DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("MM/dd/yyyy");

            // Line parsing commas for fields 
            public BankTransaction parseLineFrom(final String line){
                    final String[] columns = line.split(",");

                    final LocalDate date = LocalDate.parse(columns[0],DATE_PATTERN);
                    final String description = columns[1];
                    final double amount = Double.parseDouble(columns[2]);

                    BankTransaction Transaction = new BankTransaction(date, amount, description);
                    return Transaction;
                }
            // Parsing entire file
            public List<BankTransaction> parseLineSFrom(final List<String> Lines){
                    final List<BankTransaction> bankTransactions = new ArrayList<>();
                    for (final String line : Lines){
                        bankTransactions.add(parseLineFrom(line));
                    }
                    return bankTransactions;
                }

            }

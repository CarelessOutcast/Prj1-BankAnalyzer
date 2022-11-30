package com.Careless.app;

@FunctionalInterface
public interface InterfaceTransactionSummarizer {
    double summarize(double accumulator,BankTransaction bankTransaction);
}

package com.Careless.app;

import java.io.IOException;

public class Main{
public static void main(String[] args) throws IOException {
    
    final String FILE = "transaction.csv";

    final InterfaceBankTransactionParser Parser = new BankTransactionCSVParser();
    final InterfaceExporter exporter = new HtmlExporter();

    BankTransactionAnalyzerSimple.analyze(FILE,Parser,exporter);
}}

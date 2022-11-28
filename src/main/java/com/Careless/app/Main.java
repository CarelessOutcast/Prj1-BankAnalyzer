package com.Careless.app;

import java.io.IOException;

public class Main{
public static void main(String[] args) throws IOException {

    final InnerBankTransactionParser Parser = new BankTransactionCSVParser();

    BankTransactionAnalyzerSimple.analyze("",Parser);

}}

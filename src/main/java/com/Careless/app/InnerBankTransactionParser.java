package com.Careless.app;

import java.util.List;

public interface InnerBankTransactionParser {
    public BankTransaction parseLineFrom(final String line);
    public List<BankTransaction> parseLineSFrom(final List<String> lines);
}

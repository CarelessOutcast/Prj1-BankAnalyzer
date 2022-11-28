package com.Careless.app;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import java.time.Month;

public class BankTransactionCSVParserTest{
    private final InnerBankTransactionParser Parser = new BankTransactionCSVParser();

    @Test
    public void shouldParseOneCoorectLine() throws Exception {
        final String line = "11/01/2022,DescriptionSomething,100";
        final BankTransaction result = Parser.parseLineFrom(line);

        final BankTransaction expected = new BankTransaction(LocalDate.of(2022, Month.NOVEMBER,01), 100, "DescriptionSomething");
        final double tolerance = 0.0d;

        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(),tolerance);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
        }

    }


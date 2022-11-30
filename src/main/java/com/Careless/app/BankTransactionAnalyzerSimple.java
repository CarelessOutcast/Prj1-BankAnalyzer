package com.Careless.app;

import java.io.IOException;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void analyze(
        final String filename,
        final InterfaceBankTransactionParser Parser,
        final InterfaceExporter exporter) throws IOException {
        
            final Path path = Paths.get(RESOURCES + filename);
            final List<String> lines = Files.readAllLines(path);

            final List<BankTransaction> listTransactions = Parser.parseLineSFrom(lines);

            final BankStatementProcessor processor  = new BankStatementProcessor(listTransactions);

            final Summarizer summary = processor.summarizeTransactions();

            System.out.println(exporter.export(summary));
        }

    }
    



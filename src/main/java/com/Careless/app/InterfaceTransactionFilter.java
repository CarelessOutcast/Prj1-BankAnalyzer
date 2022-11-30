package com.Careless.app;

//The reason you are adding interfaces is to decouple 
//These things from the actual Main file

@FunctionalInterface
public interface InterfaceTransactionFilter {
   public boolean test(BankTransaction transaction);
}

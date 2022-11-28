package com.Careless.app; 

import java.time.LocalDate;
import java.util.Objects;

    //A common BankTransaction
public class BankTransaction {
        private final LocalDate date;
        private final double amount;
        private final String description;
        
        public BankTransaction(final LocalDate dt,final double amt,final String desc){
                this.date = dt;
                this.amount = amt;
                this.description = desc;
            }

        public LocalDate getDate() {
            return date;
        }
        public String getDescription() {
            return description;
        }
        public double getAmount() {
            return amount;
        }
    //this is for the json parsing 
        public String toString(){
            return "BankTransaction {"+"date="+date+"amount="+amount+", description='"+description+'\''+'}';

        }
    //this is for the test
        public boolean equals(Object o){
            if (this== o) return true; 
            if (this == null || getClass() != o.getClass())return false; 
            BankTransaction that = (BankTransaction) o; 
            return Double.compare(that.amount,amount) ==0 && date.equals(that.date) && description.equals(that.description);
        }       
        public int hashCode(){
            return Objects.hash(date,amount,description);
        }

    }

package com.Careless.app;

public class Summarizer {
    private final double sum,max,min,avg; 

    public Summarizer(final double sum,final double max,final double min,final double avg){
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.avg = avg;
    }
    public double getSum(){return sum;}
    public double getMax(){return max;}
    public double getMin(){return min;}
    public double getAvg(){return avg;}

}

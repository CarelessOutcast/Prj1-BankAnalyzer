package com.Careless.app;

public class HtmlExporter implements InterfaceExporter{
    public String export(Summarizer summary){
        String result  = "";
        result += "<!doctype html>";
        result += "<html lang='en'>";
        result += "<head><title> Bank Transactions Report </title></head>";
        result += "<body> ";
        result += "<ul>";
        result += "<li> The Sum is:";
        result += summary.getSum() + "</li>";
        result += "<li> The Max is:";
        result += summary.getMax() + "</li>";
        result += "<li> The Min is:";
        result += summary.getMin() + "</li>";
        result += "<li> The Average is:";
        result += summary.getAvg() + "</li>";
        result += "</ul>";
        result += "</body></html> ";
    return result;
    }
}

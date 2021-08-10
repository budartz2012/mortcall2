package com.company;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currencyInstance;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currencyInstance = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println("\n" + "PAYMENT SCHEDULE" + "\n" +"------------");
        for (double balance : calculator.getRemainingBalance())
            System.out.println(currencyInstance.format(balance));

        }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currencyInstance.format(mortgage);
        System.out.println("\n" + " MORTGAGE" + "\n" + "----------" + "\n" + "Monthly Payments: " + mortgageFormatted);
    }
}

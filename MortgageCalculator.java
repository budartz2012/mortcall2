package com.company;

public class MortgageCalculator {

    private final static byte MONTHS_IN_A_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualInterests;
    private byte years;

    public MortgageCalculator(int principal, float annualInterests, byte years) {
        this.principal = principal;
        this.annualInterests = annualInterests;
        this.years = years;
    }
    public double calculateBalance(
            short numberOfPaymentsMade
    ){
        float monthlyInterests = getMonthlyInterests();
        float numberOfPayments = getNumberOfPayments(years, MONTHS_IN_A_YEAR);

        double balance = principal
                * (Math.pow(1 + monthlyInterests, numberOfPayments) - (Math.pow(1 + monthlyInterests, numberOfPaymentsMade)))
                / (Math.pow(1 + monthlyInterests, numberOfPayments) - 1 );
        return balance;
    }
    public double calculateMortgage(){

        int numberOfPayments = getNumberOfPayments(years, MONTHS_IN_A_YEAR);
        float monthlyInterests = getMonthlyInterests();

        double mortgage = principal
                * (getNumberOfPayments(monthlyInterests, Math.pow(1 + monthlyInterests, numberOfPayments)))
                / (Math.pow(1 + monthlyInterests, numberOfPayments) - 1);
        return mortgage;
    }
    public double [] getRemainingBalance(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances [month -1] = calculateBalance(month);
        return balances;
    }

    private float getMonthlyInterests() {
        return annualInterests / PERCENT / MONTHS_IN_A_YEAR;
    }
    private int getNumberOfPayments(float years, double monthsInAYear) {
        return (int) (years * monthsInAYear);
    }
    private int getNumberOfPayments() {
        return 0;
    }
}

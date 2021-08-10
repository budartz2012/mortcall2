package com.company;


public class Main {




    public static void main(String[] args) {



        int principal = (int) Console.readNumber("Principal:", 1000, 1_000_000);
        float annualInterests = (float) Console.readNumber("Annual Interests:", 1.5, 3.5);
        byte years = (byte) Console.readNumber("Years:", 1, 40 );

        var calculator = new MortgageCalculator(principal, annualInterests, years);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();


    }









    }




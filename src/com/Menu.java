package com.aluracursos.conversormonedas;

import java.util.Scanner;

public class Menu {
    private CurrencyConverter converter;
    private Scanner scanner;

    public Menu(CurrencyConverter converter){
        this.converter = converter;
        scanner = new Scanner(System.in);
    }

    public void displayMenu(){
        boolean exit = false;
        while (!exit) {
            System.out.println("**** Tipos de monedas a convertir ****");
            System.out.println("1) Dolar -> Peso argentino");
            System.out.println("2) Peso Argentino -> Dolar");
            System.out.println("3) Dolar -> Real Brasileño");
            System.out.println("4) Real Brasileño -> Dolar");
            System.out.println("5) Dolar -> Peso Mexicano");
            System.out.println("6) Peso Mexicano -> Dolar");
            System.out.println("7) Salir");
            System.out.println("Seleccione la opcion deseada");

            int option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("Ingrese la cantidad en dolares a convertir");
                    double amount1 = scanner.nextDouble();
                    double conversionRate1 = converter.getConversionRate("USD", "ARS");
                    System.out.println(amount1 + " USD equivale a= " + (amount1 * conversionRate1) + " ARS");
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad en pesos Argentinos a convertir");
                    double amount2 = scanner.nextDouble();
                    double conversionRate2 = converter.getConversionRate("ARS", "USD");
                    System.out.println(amount2 + " ARS equivale a= " + (amount2 * conversionRate2) + " USD");
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad en dolares a convertir");
                    double amount3 = scanner.nextDouble();
                    double conversionRate3 = converter.getConversionRate("USD", "BRL");
                    System.out.println(amount3 + " USD equivale a= " + (amount3 * conversionRate3) + " BRL");
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad en reales brasileños a convertir");
                    double amount4 = scanner.nextDouble();
                    double conversionRate4 = converter.getConversionRate("BRL", "USD");
                    System.out.println(amount4 + " BRL equivale a= " + (amount4 * conversionRate4) + " USD");
                    break;
                case 5:
                    System.out.println("Ingrese la cantidad en dolares a convertir");
                    double amount5 = scanner.nextDouble();
                    double conversionRate5 = converter.getConversionRate("USD", "MXN");
                    System.out.println(amount5 + " USD equivale a= " + (amount5 * conversionRate5) + " MXN");
                    break;
                case  6:
                    System.out.println("Ingrese la cantidad en pesos mexicanos a convertir");
                    double amount6 = scanner.nextDouble();
                    double conversionRate6 = converter.getConversionRate("MXN", "USD");
                    System.out.println(amount6 + "MXN equivale a= " + (amount6 * conversionRate6) + "USD");
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Por favor, ingrese una opcion valida");
            }
        }
        System.out.println("Hasta Luego!");
    }

    public CurrencyConverter getConverter() {
        return converter;
    }

    public void setConverter(CurrencyConverter converter) {
        this.converter = converter;
    }
}

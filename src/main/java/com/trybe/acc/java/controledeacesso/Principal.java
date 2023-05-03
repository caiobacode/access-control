package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    Scanner scannerInstance = new Scanner(System.in);

    boolean runSystem = true;
    ArrayList<Short> customers = new ArrayList<Short>();

    while (runSystem) {
      String firstOutput = "Entre com o número correspondente à opção desejada:\n" 
                      + "1 - Acessar o estabelecimento\n"
                      + "2 - Finalizar o sistema e mostrar relatório";
      System.out.println(firstOutput);
      String userResponse = scannerInstance.next();

      if (userResponse.equals("1")) {
        System.out.println("Entre com a idade:");
        String customerAge = scannerInstance.next();
        short ageInt = Short.parseShort(customerAge);

        if (ageInt < 18) {
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        } else if (ageInt > 49) {
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
        } else {
          System.out.println("Pessoa adulta, catraca liberada!");
        }
        
        customers.add(ageInt);
      } else if (userResponse.equals("2")) {
        runSystem = false;
      } else {
        System.out.println("Entre com uma opção válida");
      }
    }
    scannerInstance.close();
    
    int totalMinors = 0;
    int totalAdults = 0;
    int totalElderlys = 0;
    
    for (int customerAge : customers) {
      if (customerAge < 18) {
        totalMinors++;
      } else if (customerAge > 49) {
        totalElderlys++;
      } else {
        totalAdults++;
      }
    }

    float totalCustomers = customers.size();

    DecimalFormat decimal = new DecimalFormat("0.00");
    String minorsPercentage = decimal.format((totalMinors * 100) / totalCustomers);
    String adultsPercentage = decimal.format((totalAdults * 100) / totalCustomers);
    String elderlysPercentage = decimal.format((totalElderlys * 100) / totalCustomers);
    
    String finalOutput = "----- Quantidade -----\n"
            + "menores: " + totalMinors + "\n"
            + "adultas: " + totalAdults + "\n"
            + "a partir de 50: " + totalElderlys + "\n\n"
            + "----- Percentual -----\n"
            + "menores: " + minorsPercentage + "%\n"
            + "adultas: " + adultsPercentage + "%\n"
            + "a partir de 50: " + elderlysPercentage + "%\n";
    
    System.out.println(finalOutput);
  }
}

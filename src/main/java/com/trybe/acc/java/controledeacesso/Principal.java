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
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Acessar o estabelecimento");
      System.out.println("2 - Finalizar o sistema e mostrar relatório");
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
    
    for (int i = 0; i < customers.size(); i++) {
      if (customers.get(i) < 18) {
        totalMinors++;
      } else if (customers.get(i) > 49) {
        totalElderlys++;
      } else {
        totalAdults++;
      }
    }

    float minorsFloat = totalMinors;
    float adultsFloat = totalAdults;
    float elderlysFloat = totalElderlys;
    
    DecimalFormat decimal = new DecimalFormat("0.00");
    String minorsPercentage = decimal.format((minorsFloat * 100) / customers.size());
    String adultsPercentage = decimal.format((adultsFloat * 100) / customers.size());
    String elderlysPercentage = decimal.format((elderlysFloat * 100) / customers.size());
    
    System.out.println("----- Quantidade -----");
    System.out.println("menores: " + totalMinors);
    System.out.println("adultas: " + totalAdults);
    System.out.println("a partir de 50: " + totalElderlys);
    
    System.out.println("");

    System.out.println("----- Percentual -----");
    System.out.println("menores: " + minorsPercentage + "%");
    System.out.println("adultas: " + adultsPercentage + "%");
    System.out.println("a partir de 50: " + elderlysPercentage + "%");
    
  }
}

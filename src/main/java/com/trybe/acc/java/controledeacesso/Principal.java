package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    Scanner scannerInstance = new Scanner(System.in);

    boolean runSystem = true;
    ArrayList<String> customers = new ArrayList<String>();

    while (runSystem) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Acessar o estabelecimento");
      System.out.println("2 - Finalizar o sistema e mostrar relatório");
      String userResponse = scannerInstance.next();

      if (userResponse.equals("1")) {
        System.out.print("Entre com a idade:");
        String customerAge = scannerInstance.next();
        short ageInt = Short.parseShort(customerAge);

        if (ageInt < 18) {
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        } else if (ageInt > 49) {
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
        } else {
          System.out.println("Pessoa adulta, catraca liberada!");
        }
        
        customers.add(customerAge);
      }
      if (userResponse.equals("2")) {
        runSystem = false;
      }
    }
    
    scannerInstance.close();
    
    System.out.print("Voce finalizou o sistema" + customers);
    
  }
}



import java.util.Scanner;
public class AplikaciaBU {
public static void main  (String[] args)  {
    Scanner citac;
    citac = new Scanner(System.in);
    
    String meno;
    String heslo;
    double pocvklad;
    double vklad;
    double zostatok;
    String overHeslo;
    double vyber;
    
    System.out.println("Vitame Vas a otvorime Vam ucet");
    System.out.println("Zadajte prosim meno uctu");
    meno = citac.nextLine();
    System.out.println("Zadajte prosim heslo k uctu");
    heslo = citac.nextLine();
    System.out.println("Zadaj prosim pociatocny vklad");
    pocvklad = citac.nextDouble();
    
    citac.nextLine();
    
    //vytvorenie uctu
    
    BankovyUcet mojUcet; // objektova lokalna premenna, preto zaciatok velkym pismenom 
    mojUcet = new BankovyUcet(meno, pocvklad, heslo);
    System.out.println("Vas ucet bol vytvoreny");
    //vypis uctu
    System.out.println(mojUcet.toString());
    System.out.println("Zadajte prosim sumu v celych eurach");
    vklad = citac.nextDouble();
    System.out.format("Na ucet bolo vlozene : %10.0f%n", vklad );
    zostatok = pocvklad + vklad;
    System.out.format("Na ucte mate  : %10.4f ", zostatok );
    
    
        System.out.println("Zadajte vyberanu sumu");
        vyber = citac.nextDouble();
        //if ( heslo.equals(overHeslo)){
        // System.out.format("Z vasho uctu bolo vybrate %10.4", vyber);   
              
  //  } else {
   //     System.out.format("Zle heslo");
   // }
}
}








import java.util. ArrayList;

public class Banka {
    
    private ArrayList <BankovyUcet> aBanka;
   
   
    
    public Banka() {
        aBanka = new ArrayList<BankovyUcet>(); 
}

public boolean vlozBankovyUcet (BankovyUcet paBankovyUcet) {
    return aBanka.add(paBankovyUcet);

}

public String vlozNaKonkretnyUcet (int paPoradoveCislo, int paSuma) {
  BankovyUcet pomUcet;  
  pomUcet = aBanka.get(paPoradoveCislo);
    if (paPoradoveCislo <0 || paPoradoveCislo > aBanka.size() ) {
       return "Ucet neexistuje";
    } else {
      return pomUcet.vklad(paSuma);
        
    }
}

public String vyberZKonkretnehoUctu (int paPoradoveCislo, int paSuma, String paHeslo) {
    BankovyUcet pomUcet;
     
    
    if (paPoradoveCislo >= 0 && paPoradoveCislo <= aBanka.size()) {
        pomUcet = aBanka.get(paPoradoveCislo);
       return pomUcet.vyber(paSuma,paHeslo);
    } else {
      
        return "Chyba";
    }
}

public double celkovyStavVBanke() {
    double stav = 0;
    for (BankovyUcet pom: aBanka) {
        
        stav  += pom.dajStavNaUcte();
        
    }
    return stav;
}
/*
public BankovyUcet zrusKonkretnyUcet() {
    
    if (BankovyUcet.aZostatok == 0) {
        return aBanka.remove(paBankovyUcet);
    }
    
    
}
*/    
}

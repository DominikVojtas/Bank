public class BankovyUcet {
    //atributy instancii
    private double aZostatok;
    private String aNazovUctu;
    private double aUrokovaSadzba = 0;
    private BezpecnostnyPrvok aBP;
    
    //atributy triedy
    private static final double  MAX_UROKOVA_SADZBA = 1.5;
    public BankovyUcet(String paNazovUctu, double paPociatocnyVklad) {
        aNazovUctu = paNazovUctu;
        if ( paPociatocnyVklad < 0) {
            aZostatok = paPociatocnyVklad * (-1);
        } else {
             aZostatok = paPociatocnyVklad;
        }
        aBP = new BezpecnostnyPrvok("");
    }
    
    
    public BankovyUcet(String paNazovUctu) {
        this(paNazovUctu, 0);
      
    }
    
    public BankovyUcet(String paNazovUctu, double paPociatocnyVklad, String paHeslo) {
        
        //if (aBP.equals(paHeslo)) {
            aNazovUctu = paNazovUctu;
            aZostatok = paPociatocnyVklad;
            aBP = new BezpecnostnyPrvok(paHeslo);
          //  else {
                
            }
        
       
    
    
    public boolean nastavUrokovuSadzbu(double paNovaSadzba) {
       
        if (paNovaSadzba <= MAX_UROKOVA_SADZBA && paNovaSadzba > 0) {
            aUrokovaSadzba = paNovaSadzba;
            return true;
        } else {
            return false;
        }
                    
    }
    
    public double dajStavNaUcte(){
                return aZostatok;
        
    }
    
    public String toString() {
    String vysledok=String.format ("[Ucet %s ma aZostatok:%10.2f a urokovu sadzbu:%5.2f]", aNazovUctu, aZostatok, aUrokovaSadzba );
    return vysledok;
    }
    
    public String  vklad(double paSuma) {
      
        
        if (paSuma > 0) {
          aZostatok = aZostatok + paSuma;  
          String vysledok=String.format ("[Bolo vlozene %10.2f € ]", paSuma );   
          return vysledok;
        } else {
          String vysledok=String.format ("[Operacia bola zamietnuta, zly vklad  ]");   
          return vysledok;
        }
    }
    
    
    /* public String vyberZUctu(int paVyberanaSuma, String paHeslo) {
     * if (this.overenieBezpecnostnehoPrvku(paHeslo)) {
     *     return this.vyberZUctu(paVyberanaSuma);
     *  } else {
     *      return "Pozor ! Overenie bezpecnosti prebehlo s chybou.";
     *  }
     */
    /*  }*/
     public String  vyber (double paSuma, String paHeslo) {
      
        
        if ((paSuma > 0) && (paSuma <= aZostatok)) {
          aZostatok = aZostatok - paSuma;  
          String vysledok=String.format ("[Bolo vybrate %10.2f € ]", paSuma );   
          return vysledok;
        } else  if (paSuma < 0) {
          String vysledok=String.format ("[Operacia bola zamietnuta, zly vyber ]");   
          return vysledok;
        } else  {
            String vysledok=String.format ("[Operacia bola zamietnuta, mate malo penazi na ucte  ]");
            return vysledok;
        } 
    }
    
    public void nastavNoveHeslo(String paNoveHeslo) {
       aBP.setHeslo(paNoveHeslo);  
    }
    //nefunguje :
    public boolean  overBezpecnostnyPrvok (String paHeslo){
        return aBP.getHeslo().equals(paHeslo) ;
        /*
        if (aBP.overBezpecnostnyPrvok() == true) {
            return true;
        } else {
            return false;
        }
        return aBP.overHeslo(paHeslo);
    } */
    
    
   }
   
   private double vypocitajUrok() {
       double urok;
       urok = (aZostatok/100) *  aUrokovaSadzba/12;
       return urok;
    }
    
  public int kedyNasporim(double paCislovaSuma, double paMesacnyVklad)  {
      int pocetMesiacov = 0;
      int cielovaSuma = 800;
      
     double pomZostatok = aZostatok;
      while (aZostatok <= cielovaSuma) {
      aZostatok = aZostatok + paMesacnyVklad;  
      pocetMesiacov ++;
      aZostatok += this.vypocitajUrok();
      } 
      aZostatok = pomZostatok;
      return pocetMesiacov;
    }
  
  public double kolkoNasetrim(int paPocetMesiacov, double paMesacnyVklad) {
      
      int mesiace = 0;
      double pomZostatok = aZostatok;
      while (mesiace  != paPocetMesiacov)
      {pomZostatok = pomZostatok + paMesacnyVklad;
          mesiace ++;
          pomZostatok += this.vypocitajUrok();
        }
         
      return pomZostatok;
    } 
    
    
}

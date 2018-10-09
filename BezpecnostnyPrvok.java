import java.util. Random;
import java.util. Scanner;
public class BezpecnostnyPrvok {
    private String aHeslo;
    public BezpecnostnyPrvok(String paHeslo) {
        aHeslo = paHeslo;
    }
    
    //public String toString() {
       // return "Heslo:" + aHeslo;
    //}
    
    public String getHeslo() {
        return aHeslo;
    }
    
    public void setHeslo(String paNoveHeslo) {
        aHeslo = paNoveHeslo;
    }
    
    public String toString() {
        return "Heslo:" + this.getHeslo();
    }
    
    public boolean overHeslo(String paHeslo) {
        //if (aHeslo.equals(paHeslo)) {
            // return true;
            // } else {
                // return false;
            //}
        return (aHeslo.equals(paHeslo));
    }
    
    public boolean overBezpecnostnyPrvok(String paHeslo) {
        //if (aHeslo.equals(paHeslo))
        return (aHeslo.equals(paHeslo) && this.overPodpornyPrvok());
        // return this.overHeslo (paHeslo);
    }
    
    public boolean overPodpornyPrvok() {
        Random generator;
        generator = new Random();
        generator.nextInt(10000);
        System.out.println("Scitaj tieto cisla " + generator);
        int zgen;
        zgen = generator.nextInt(9000) + 1000;
        Scanner citac;
        citac = new Scanner(System.in);
        int captcha;
        captcha = citac.nextInt(); 
        
        int sucetCifier = this.dajSucetCifier(zgen);
        int sucetPouzivatela = citac.nextInt();
        if (sucetPouzivatela == sucetCifier  ) {
            return true;
        } else {
            
            return false;
            
        }
        
        
        
    }
    
    public int dajSucetCifier(int paCislo) {
            
            int pomCislo = 0;
            int pomCislo2 = 0;
            while (paCislo > 0) {
                pomCislo = paCislo%10;                
                paCislo = paCislo/10;
                pomCislo2 = pomCislo + pomCislo2;
                 
            }
            return pomCislo2;
        }
}

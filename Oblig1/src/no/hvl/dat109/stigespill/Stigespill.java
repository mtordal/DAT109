package no.hvl.dat109.stigespill;

import no.hvl.dat109.hjelpemetoder.Setup;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse som definerer et stigespill
 */
public class Stigespill {
    private List<Spiller> spillere;
    private Brett brett;
    private Kopp kopp;
    private Spiller vinner;
    private final static int MAAL = 100;

    /**
     * Konstruktør for å lage et stigespill
     */
    public Stigespill(){
        spillere = new ArrayList<>();
        brett = new Brett();
        kopp = new Kopp();
        vinner = null;
    }

    /**
     * Starter stigespillet
     */
    public void startSpill() {
        spillere = Setup.spillSetup(brett);

        while (vinner == null) {
            for (Spiller spiller : spillere) {
                spiller.spillRunde(kopp);
                if (spiller.getBrikke().getRute().getNummer() == MAAL) {
                    vinner = spiller;
                }
            }
        }

        System.out.println(vinner.getBrikke().getFarge() + " vant spillet!");
    }
}

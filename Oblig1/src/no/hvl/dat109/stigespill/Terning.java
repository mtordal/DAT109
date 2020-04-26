package no.hvl.dat109.stigespill;

/**
 * Klasse som definerer en terning
 */
public class Terning {
    private Integer verdi;

    /**
     * Konstruktør for å lage en terning
     */
    public Terning() {
    }

    /**
     * Triller terningen
     */
    public void trill() {
        verdi = (int)(Math.random()*6+1);
    }

    public Integer getVerdi() {
        return verdi;
    }
}
package no.hvl.dat109.stigespill;

/**
 * Klasse som definerer en kopp
 */
public class Kopp {
    private Terning terning;

    /**
     * Konstruktør for å lage en kopp
     */
    public Kopp() {
        terning = new Terning();
    }

    /**
     * Triller terningene i koppen
     */
    public void trill() {
        terning.trill();
    }

    public Integer getSum() {
        return terning.getVerdi();
    }
}
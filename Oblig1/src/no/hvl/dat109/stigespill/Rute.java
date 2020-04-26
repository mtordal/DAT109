package no.hvl.dat109.stigespill;

/**
 * Klasse som definerer en rute
 */
public class Rute {
    private Integer nummer;

    /**
     * Konstruktør for å lage en rute
     * @param nummer nummeret på ruten
     */
    public Rute(Integer nummer) {
        this.nummer = nummer;
    }

    public Integer getNummer() {
        return nummer;
    }
}
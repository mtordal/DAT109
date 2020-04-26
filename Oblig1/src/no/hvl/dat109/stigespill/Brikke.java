package no.hvl.dat109.stigespill;

/**
 * Klasse som definerer en brikke
 */
public class Brikke {
    private Farge farge;
    private Rute rute;
    private Brett brett;

    /**
     * Konstruktør for å lage en brikke
     * @param farge fargen på brikken
     * @param brett brettet brikke er på
     * @param rute ruten brikken står i
     */
    public Brikke(Farge farge, Brett brett, Rute rute) {
        this.farge = farge;
        this.brett = brett;
        this.rute = rute;
    }

    /**
     * Flytter brikken et gitt antall steg
     * @param sum antall steg brikken skal flyttes
     */
    public void flytt(Integer sum) {
        Rute nyRute = brett.finnRute(rute, sum);
        setRute(nyRute);
    }

    /**
     * Flytter brikken til start
     */
    public void flyttTilStart() {
        setRute(brett.getRuter().get(0));
    }

    /**
     * Flytter brikken til en gitt rute
     * @param nummer nummeret på ruten
     */
    public void flyttTil(Integer nummer) {
        setRute(brett.getRuter().get(nummer - 1));
    }

    private void setRute(Rute nyRute) {
        this.rute = nyRute;
    }

    public Rute getRute() {
        return rute;
    }

    public Farge getFarge() {
        return farge;
    }

    public Brett getBrett() {
        return brett;
    }
}
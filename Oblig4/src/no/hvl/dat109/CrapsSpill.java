package no.hvl.dat109;

/**
 * Klasse som definerer et CrapsSpill
 */
public class CrapsSpill {
    private Terning terning1;
    private Terning terning2;

    /**
     * Konstruktør for et CrapsSpill
     */
    public CrapsSpill() {
        this.terning1 = new Terning();
        this.terning2 = new Terning();
    }

    /**
     * Starter spillet
     */
    public void startSpill() {
        System.out.println("Starter Craps...");
        terning1.trill();
        terning2.trill();

        int verdi1 = terning1.getVerdi();
        int verdi2 = terning2.getVerdi();
        int sum = verdi1 + verdi2;
        System.out.println("Triller " + sum + ":");

        if (sum == 7) {
            System.out.println("Gratulerer, du vant!");
        } else {
            System.out.println("Beklager, du tapte.");
        }
    }
}
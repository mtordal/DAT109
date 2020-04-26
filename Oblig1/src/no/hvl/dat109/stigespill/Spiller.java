package no.hvl.dat109.stigespill;

import static java.lang.Thread.sleep;

/**
 * Klasse som definerer en spiller
 */
public class Spiller {
    private Brikke brikke;
    private boolean laast;

    /**
     * Konstruktør for å lage en spiller
     * @param brikke brikken til spilleren
     */
    public Spiller(Brikke brikke) {
        this.brikke = brikke;
        laast = false;
    }

    /**
     * Spiller en runde
     */
    public void spillRunde(Kopp kopp) {
        Integer pos = brikke.getRute().getNummer();
        System.out.println();
        System.out.println(brikke.getFarge() + " sitt trekk:");
        kopp.trill();
        Integer sum = kopp.getSum();

        // Sjekker om spiller er låst og kan låse seg opp
        if (laast) {
            if (sum == 6) {
                laast = false;
                System.out.println("Triller 6, og er ikke lenger låst");
            } else {
                System.out.println("Triller " + sum + ", og er fortsatt låst");
            }
        }

        // Sjekker om spiller ikke er låst og triller 6
        if (!laast) {
            if (sum == 6) {
                System.out.println("Triller 6, må trille på nytt");
                Integer teller = 1;
                while (sum == 6 && teller < 3) {
                    kopp.trill();
                    sum = kopp.getSum();
                    if (sum == 6) {
                        System.out.println("Triller 6, må trille på nytt");
                        teller++;
                    }
                }

                // Sjekker om spiller triller 6 tre ganger på rad og blir låst
                if (teller == 3) {
                    System.out.println("Triller 6 tre ganger på rad, flyttes tilbake til start og er låst");
                    brikke.flyttTilStart();
                    laast = true;
                }
            }
        }

        // Sjekker om spiller treffer slange eller stige
        if (!laast) {
            System.out.println("Triller " + sum);
            if ((pos + sum) <= 100) {
                brikke.flytt(sum);
                Integer nyPos = brikke.getRute().getNummer();
                System.out.println("Flytter fra " + pos + " til " + nyPos);
                if (brikke.getBrett().getSlanger().containsKey(nyPos)) {
                    Integer value = brikke.getBrett().getSlanger().get(nyPos);
                    System.out.println("Ny posisjon er hodet til en slange, flyttes tilbake til rute " + value);
                    brikke.flyttTil(value);
                } else if (brikke.getBrett().getStiger().containsKey(nyPos)) {
                    Integer value = brikke.getBrett().getStiger().get(nyPos);
                    System.out.println("Ny posisjon er bunnen av en stige, flyttes fremover til rute " + value);
                    brikke.flyttTil(value);
                }
            } else {
                System.out.println("Står i ro i rute " + pos);
            }
        }

        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Brikke getBrikke() {
        return brikke;
    }
}
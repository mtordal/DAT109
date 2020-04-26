package no.hvl.dat109.hjelpemetoder;

import no.hvl.dat109.stigespill.Brett;
import no.hvl.dat109.stigespill.Brikke;
import no.hvl.dat109.stigespill.Farge;
import no.hvl.dat109.stigespill.Spiller;
import java.util.*;

/**
 * Klasse som tar hånd om spillere i stigespillet
 */
public class Setup {
    private static final Scanner IN = new Scanner(System.in);

    /**
     *
     * @param brett brettet det blir spilt på
     * @return liste av spillere
     */
    public static List<Spiller> spillSetup(Brett brett) {
        List<Spiller> spillere = new ArrayList<>();
        System.out.println("Starter stigespill...");

        // Finner antall spillere
        boolean gyldigAntall = false;
        int input = 0;
        while (!gyldigAntall) {
            System.out.println("Hvor mange spillere? (2-4)");
            input = Integer.parseInt(IN.nextLine());
            if (input > 1 && input < 5) {
                gyldigAntall = true;
            } else {
                System.out.println("Ugyldig antall spillere.");
            }
        }

        List<Farge> farger = new LinkedList<>(Arrays.asList(Farge.values()));

        // Lager et spillerobjekt med brikke for hver spiller
        for (int i = 0; i < input; i++) {
            System.out.println();
            System.out.println("Spiller " + (i+1) + ", velg farge:");
            System.out.println(farger);

            Farge farge = Farge.valueOf(IN.nextLine());
            farger.remove(farge);
            Brikke brikke = new Brikke(farge, brett, brett.getRuter().get(0));
            spillere.add(new Spiller(brikke));
        }
        return spillere;
    }
}

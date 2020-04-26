package no.hvl.dat109.stigespill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Klasse som definerer et brett
 */
public class Brett {
    private List<Rute> ruter;
    private Map<Integer, Integer> slanger;
    private Map<Integer, Integer> stiger;

    /**
     * Konstruktør for å lage et brett
     */
    public Brett() {
        ruter = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ruter.add(new Rute(i+1));
        }

        slanger = new HashMap<>();
        slanger.put(62, 18);
        slanger.put(16, 6);
        slanger.put(48, 11);
        slanger.put(47, 26);
        slanger.put(56, 53);
        slanger.put(64, 60);
        slanger.put(86, 24);
        slanger.put(95, 75);
        slanger.put(92, 73);
        slanger.put(98, 78);

        stiger = new HashMap<>();
        stiger.put(2, 38);
        stiger.put(4, 14);
        stiger.put(8, 31);
        stiger.put(21, 42);
        stiger.put(28, 84);
        stiger.put(36, 44);
        stiger.put(51, 67);
        stiger.put(71, 91);
        stiger.put(80, 100);
    }

    /**
     * Finner og returnerer ny rute
     * @param rute forrige rute
     * @param sum antall steg fra forrige rute
     */
    public Rute finnRute(Rute rute, Integer sum) {
        int nyPos = rute.getNummer() + sum - 1;
        if (nyPos > 99) {
            return ruter.get(99);
        } else {
            return ruter.get(nyPos);
        }
    }

    public List<Rute> getRuter() {
        return ruter;
    }

    public Map<Integer, Integer> getSlanger() {
        return slanger;
    }

    public Map<Integer, Integer> getStiger() {
        return stiger;
    }
}

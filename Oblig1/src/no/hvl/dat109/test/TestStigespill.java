package no.hvl.dat109.test;

import no.hvl.dat109.stigespill.Brett;
import no.hvl.dat109.stigespill.Brikke;
import no.hvl.dat109.stigespill.Farge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStigespill {
    private Brett brett;
    private Brikke brikke;

    @BeforeEach
    public void setup() {
        brett = new Brett();
        brikke = new Brikke(Farge.blå, brett, brett.getRuter().get(0));
    }

    @Test
    public void sjekkAntallRuterPaaBrettet() {
        assertEquals(100, brett.getRuter().size());
    }

    @Test
    public void sjekkStartposisjonTilBrikke() {
        assertEquals(1, brikke.getRute().getNummer());
    }

    @Test
    public void sjekkFlytt() {
        brikke.flytt(5);
        assertEquals(6, brikke.getRute().getNummer());
    }

    @Test
    public void sjekkFlyttTilStart() {
        brikke.flytt(5);
        brikke.flyttTilStart();
        assertEquals(1, brikke.getRute().getNummer());
    }

    @Test
    public void sjekkFlyttTil() {
        brikke.flyttTil(50);
        assertEquals(50, brikke.getRute().getNummer());
    }
}

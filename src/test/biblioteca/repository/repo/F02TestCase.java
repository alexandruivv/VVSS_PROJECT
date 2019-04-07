package biblioteca.repository.repo;

import biblioteca.exceptions.InvalidValueException;
import biblioteca.model.Carte;
import biblioteca.repository.repoMock.CartiRepoMock;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class F02TestCase {
    private CartiRepoMock cartiRepo;

    @Before
    public void init() {
        cartiRepo = new CartiRepoMock();
    }

    @Test(expected = InvalidValueException.class)
    public void testCase1() throws InvalidValueException {
        cartiRepo.cautaCarte("");
    }

    @Test
    public void testCase2() {
        try {
            assertEquals(cartiRepo.cautaCarte("Rebreanu").size(), 0);
        } catch (InvalidValueException e) {
            fail();
        }
    }

    @Test
    public void testCase3() {
        cartiRepo.adaugaCarte(Carte.getCarteFromString("Ion;Rebreanu;1973;Corint;povesti,povestiri"));
        cartiRepo.adaugaCarte(Carte.getCarteFromString("Floare albastra;;1973;Corint;povesti,povestiri"));
        try {
            List<Carte> carti = cartiRepo.cautaCarte("Rebr");
            assertEquals(carti.size(), 1);
            assertEquals(carti.get(0).getTitlu(), "Ion");
        } catch (InvalidValueException e) {
            fail();
        }
    }

    @Test
    public void testCase4() {
        cartiRepo.adaugaCarte(Carte.getCarteFromString("Ion;Rebreanu;1973;Corint;povesti,povestiri"));
        cartiRepo.adaugaCarte(Carte.getCarteFromString("Floare albastra;;1973;Corint;povesti,povestiri"));
        try {
            List<Carte> carti = cartiRepo.cautaCarte("Arghezi");
            assertEquals(carti.size(), 0);
        } catch (InvalidValueException e) {
            fail();
        }
    }

    @Test
    public void testCase5() {
        cartiRepo.adaugaCarte(Carte.getCarteFromString("Morometii;Marin Preda;1973;Corint;povesti,povestiri"));
        cartiRepo.adaugaCarte(Carte.getCarteFromString("Scrisoarea I;Eminescu;1973;Corint;povesti,povestiri"));
        cartiRepo.adaugaCarte(Carte.getCarteFromString("Ion;Liviu Rebreanu;1973;Corint;povesti,povestiri"));
        try {
            List<Carte> carti = cartiRepo.cautaCarte("Eminescu");
            assertEquals(carti.size(), 1);
            assertEquals(carti.get(0).getTitlu(), "Scrisoarea I");
        } catch (InvalidValueException e) {
            fail();
        }
    }
}

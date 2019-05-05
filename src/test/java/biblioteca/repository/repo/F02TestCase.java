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

    @Test(expected = Exception.class)
    public void testCase1() throws Exception {
        cartiRepo.cautaCarte("");
    }

    @Test
    public void testCase2() {
        try {
            assertEquals(cartiRepo.cautaCarte("Rebreanu").size(), 0);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testCase3() {
        try {
            cartiRepo.adaugaCarte(Carte.getCarteFromString("Ion;Rebreanu;1973;Corint;povesti,povestiri"));
            cartiRepo.adaugaCarte(Carte.getCarteFromString("Floare albastra;Re;1973;Corint;povesti,povestiri"));
            List<Carte> carti = cartiRepo.cautaCarte("Rebr");
            assertEquals(carti.size(), 1);
            assertEquals(carti.get(0).getTitlu(), "Ion");
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testCase4() {
        try {
            cartiRepo.adaugaCarte(Carte.getCarteFromString("Ion;Rebreanu;1973;Corint;povesti,povestiri"));
            cartiRepo.adaugaCarte(Carte.getCarteFromString("Floare albastra;Re;1973;Corint;povesti,povestiri"));
            List<Carte> carti = cartiRepo.cautaCarte("Arghezi");
            assertEquals(carti.size(), 0);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testCase5() {
        try {
            cartiRepo.adaugaCarte(Carte.getCarteFromString("Morometii;Marin Preda;1973;Corint;povesti,povestiri"));
            cartiRepo.adaugaCarte(Carte.getCarteFromString("Scrisoarea I;Eminescu;1973;Corint;povesti,povestiri"));
            cartiRepo.adaugaCarte(Carte.getCarteFromString("Ion;Liviu Rebreanu;1973;Corint;povesti,povestiri"));
            List<Carte> carti = cartiRepo.cautaCarte("Eminescu");
            assertEquals(carti.size(), 1);
            assertEquals(carti.get(0).getTitlu(), "Scrisoarea I");
        } catch (Exception e) {
            fail();
        }
    }
}

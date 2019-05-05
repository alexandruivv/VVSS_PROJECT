package biblioteca.repository.repo;

import biblioteca.control.BibliotecaCtrl;
import biblioteca.model.Carte;
import biblioteca.repository.repoMock.CartiRepoMock;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartiRepoTest {

    private CartiRepoMock cartiRepo;

    @Before
    public void init() {
        cartiRepo = new CartiRepoMock();
    }

    @Test
    public void adaugaCarte() {
        Carte carte = new Carte();
        carte.setTitlu("Ion");
        carte.setAnAparitie("1601");

        carte.setEditura("sds");
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(7, cartiRepo.getCarti().size());
    }

    @Test
    public void adaugaCarte2(){
        Carte carte = new Carte();
        carte.setTitlu("");
        carte.setAnAparitie("1992");

        carte.setEditura("sds");
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
        }
        assertEquals(6, cartiRepo.getCarti().size());
    }

    @Test
    public void adaugaCarte3()  {
        Carte carte = new Carte();
        carte.setTitlu("The classic children’s book uses a spectacular image to grab people’s attention:" +
                " Could you imagine looking up in the sky and seeing meatballs beginning to rain down? " +
                "That’s the colorful image the equally colorful book creates with its title. " +
                "Judi Barrett’s");
        carte.setAnAparitie("1823");

        carte.setEditura("sds");
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
        }
        assertEquals(6, cartiRepo.getCarti().size());
    }

    @Test
    public void adaugaCarte4() {
        Carte carte = new Carte();
        carte.setTitlu("The classic childrens book uses a spectacular image to grab peoples attention: Could you imagine looking up in the sky and seeing meatballs " +
                "beginning to rain down " +
                "Thats the colorful image the equally colorful book creates with its title. Judi Barrettttttt");
        carte.setAnAparitie("2008");

        carte.setEditura("sds");
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
        }
        assertEquals(7, cartiRepo.getCarti().size());
    }

    @Test
    public void adaugaCarte5() {
        Carte carte = new Carte();
        carte.setTitlu("The classic childrens book uses a spectacular image to grab peoples attention: Could you imagine looking up in the sky and seeing meatballs " +
                "beginning to rain down " +
                "Thats the colorful image the equally colorful book creates with its title. Judi Barretttttt");
        carte.setAnAparitie("2000");

        carte.setEditura("sds");
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
        }
        assertEquals(7, cartiRepo.getCarti().size());
    }

    @Test
    public void adaugaCarte6()  {
        Carte carte = new Carte();
        carte.setTitlu("Enigma Otiliei");
        carte.setAnAparitie("1600");

        carte.setEditura("sds");
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
        }
        assertEquals(6, cartiRepo.getCarti().size());
    }

    @Test
    public void adaugaCarte7() {
        Carte carte = new Carte();
        carte.setTitlu("Moara cu noroc");
        carte.setAnAparitie("2025");

        carte.setEditura("sds");
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
        }
        assertEquals(6, cartiRepo.getCarti().size());
    }

    @Test
    public void adaugaCarte8() {
        Carte carte = new Carte();
        carte.setTitlu("Aasdzxcqwe");
        carte.setAnAparitie("2016");

        carte.setEditura("sds");
        try {
            cartiRepo.adaugaCarte(carte);
        } catch (Exception e) {
        }
        assertEquals(7, cartiRepo.getCarti().size());
    }
}
package biblioteca.repository.repo;

import biblioteca.control.BibliotecaCtrl;
import biblioteca.model.Carte;
import biblioteca.repository.repoMock.CartiRepoMock;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class F03Test {
    private CartiRepoMock cartiRepoMock;

    @Before
    public void init() {
        this.cartiRepoMock = new CartiRepoMock();
    }

    @Test(expected = Exception.class)
    public void invalidTestF03() throws Exception {
        cartiRepoMock.getCartiOrdonateDinAnul("asdasda");
    }

    @Test
    public void validTestF03() {
        try {
            List<Carte> cartiOrdonate = cartiRepoMock.getCartiOrdonateDinAnul("1948");
            assertEquals(cartiOrdonate.size(), 3);
            assertEquals(cartiOrdonate.get(0).getTitlu(), "Dale carnavalului");
            assertEquals(cartiOrdonate.get(1).getTitlu(), "Enigma Otiliei");
            assertEquals(cartiOrdonate.get(2).getTitlu(), "Intampinarea crailor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

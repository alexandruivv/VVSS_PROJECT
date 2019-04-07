package biblioteca.repository.repoInterfaces;


import biblioteca.exceptions.InvalidValueException;
import biblioteca.model.Carte;

import java.util.List;

public interface CartiRepoInterface {
	void adaugaCarte(Carte c);
	void modificaCarte(Carte nou, Carte vechi);
	void stergeCarte(Carte c);
	List<Carte> cautaCarte(String ref) throws InvalidValueException;
	List<Carte> getCarti();
	List<Carte> getCartiOrdonateDinAnul(String an);
}

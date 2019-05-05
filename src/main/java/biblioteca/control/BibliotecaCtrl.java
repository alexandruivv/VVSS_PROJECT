package biblioteca.control;


import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.CartiRepoInterface;
import biblioteca.util.Validator;

import java.util.List;

public class BibliotecaCtrl {

	private CartiRepoInterface cr;
	
	public BibliotecaCtrl(CartiRepoInterface cr){
		this.cr = cr;
	}
	
	public void adaugaCarte(Carte carte) throws Exception{
		cr.adaugaCarte(carte);
	}
	
	public void modificaCarte(Carte nou, Carte vechi) throws Exception{
		cr.modificaCarte(nou, vechi);
	}
	
	public void stergeCarte(Carte carte) throws Exception{
		cr.stergeCarte(carte);
	}

	public List<Carte> cautaCarte(String autor) throws Exception{
		return cr.cautaCarte(autor);
	}
	
	public List<Carte> getCarti() throws Exception{
		return cr.getCarti();
	}
	
	public List<Carte> getCartiOrdonateDinAnul(String an) throws Exception{
		return cr.getCartiOrdonateDinAnul(an);
	}
	
	
}

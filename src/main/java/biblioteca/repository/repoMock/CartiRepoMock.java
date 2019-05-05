package biblioteca.repository.repoMock;


import biblioteca.exceptions.InvalidValueException;
import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.CartiRepoInterface;
import biblioteca.util.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CartiRepoMock implements CartiRepoInterface {

	private List<Carte> carti;
	
	public CartiRepoMock(){
		carti = new ArrayList<Carte>();
		
		carti.add(Carte.getCarteFromString("Povesti;Mihai,Ion Caragiale,Ion Creanga;1973;Corint;povesti,povestiri"));
		carti.add(Carte.getCarteFromString("Poezii;Sadoveanu;1973;Corint;poezii"));
		carti.add(Carte.getCarteFromString("Enigma Otiliei;George Calinescu;1948;Litera;enigma,otilia"));
		carti.add(Carte.getCarteFromString("Dale carnavalului;Caragiale Ion;1948;Litera;caragiale,carnaval"));
		carti.add(Carte.getCarteFromString("Intampinarea crailor;Mateiu Caragiale;1948;Litera;mateiu,crailor"));
		carti.add(Carte.getCarteFromString("Test;Calinescu,Tetica;1992;Pipa;am,casa"));

	}
	
	@Override
	public void adaugaCarte(Carte c) throws Exception {
		Validator.validateCarte(c);
		carti.add(c);
	}

	@Override
	public List<Carte> cautaCarte(String ref) throws Exception {
		Validator.isStringOK(ref);
		List<Carte> cartiGasite = new ArrayList<Carte>();
		if(ref.equals("")) {
			throw new InvalidValueException("Autorul nu poate fi null !");
		}
		List<Carte> carti = getCarti();
		int i=0;
		while (i<carti.size()){
			List<String> lref = carti.get(i).getReferenti();
			if(!lref.isEmpty()) {
				boolean flag = autorWroteBook(lref, ref);
				if(flag){
					cartiGasite.add(carti.get(i));
				}
			}
			i++;
		}
		return cartiGasite;
	}

	public boolean autorWroteBook(List<String> autori, String autor) {
		int j = 0;
		while(j<autori.size()){
			if(autori.get(j).toLowerCase().contains(autor.toLowerCase())){
				return true;
			}
			j++;
		}
		return false;
	}

	@Override
	public List<Carte> getCarti() {
		return carti;
	}

	@Override
	public void modificaCarte(Carte nou, Carte vechi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stergeCarte(Carte c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Carte> getCartiOrdonateDinAnul(String an) throws Exception {
		if(!Validator.isNumber(an))
			throw new Exception("Nu e numar!");
		List<Carte> lc = getCarti();
		List<Carte> lca = new ArrayList<Carte>();
		for(Carte c:lc){
			if(c.getAnAparitie().equals(an) == true){
				lca.add(c);
			}
		}
		
		Collections.sort(lca,new Comparator<Carte>(){

			@Override
			public int compare(Carte a, Carte b) {
				if(a.getTitlu().compareTo(b.getTitlu())==0){
					return a.getReferenti().get(0).compareTo(b.getReferenti().get(0));
				}
				
				return a.getTitlu().compareTo(b.getTitlu());
			}
		
		});
		
		return lca;
	}

}

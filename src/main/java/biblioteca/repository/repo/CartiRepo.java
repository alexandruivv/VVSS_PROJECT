package biblioteca.repository.repo;


import biblioteca.exceptions.InvalidValueException;
import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.CartiRepoInterface;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CartiRepo implements CartiRepoInterface {
	
	private String file = "cartiBD.txt";
	
	public CartiRepo(){
		File yourFile = new File(file);
		try {
			yourFile.createNewFile(); // if file already exists will do nothing
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void adaugaCarte(Carte c) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file,true));
			bw.write(c.toString());
			bw.newLine();
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Carte> getCarti() {
		List<Carte> lc = new ArrayList<Carte>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=br.readLine())!=null){
				lc.add(Carte.getCarteFromString(line));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lc;
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
	public List<Carte> cautaCarte(String ref) throws InvalidValueException {
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
	public List<Carte> getCartiOrdonateDinAnul(String an) {
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
				if(a.getAnAparitie().compareTo(b.getAnAparitie())==0){
					return a.getTitlu().compareTo(b.getTitlu());
				}
				
				return a.getTitlu().compareTo(b.getTitlu());
			}
		
		});
		
		return lca;
	}

}

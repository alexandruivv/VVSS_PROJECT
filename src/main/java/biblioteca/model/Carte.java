package biblioteca.model;


import java.util.ArrayList;
import java.util.List;

public class Carte {
	
	private String titlu;
	private List<String> referenti;
	private String anAparitie;
	private List<String> cuvinteCheie;
	private String editura;
	
	public Carte(){
		titlu = "";
		referenti = new ArrayList<String>();
		anAparitie = "";
		cuvinteCheie = new ArrayList<String>();
		editura = "";
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public List<String> getReferenti() {
		return referenti;
	}

	public void setReferenti(List<String> ref) {
		this.referenti = ref;
	}

	public String getAnAparitie() {
		return anAparitie;
	}

	public void setAnAparitie(String anAparitie) {
		this.anAparitie = anAparitie;
	}

	public List<String> getCuvinteCheie() {
		return cuvinteCheie;
	}

	public void setCuvinteCheie(List<String> cuvinteCheie) {
		this.cuvinteCheie = cuvinteCheie;
	}

	public String getEditura() {
		return editura;
	}

	public void setEditura(String editura) {
		this.editura = editura;
	}

	public void deleteCuvantCheie(String cuvant){
			for(int i=0;i<cuvinteCheie.size();i++){
				if(cuvinteCheie.get(i).equals(cuvant)){
					cuvinteCheie.remove(i);
					return;
				}
			}
	}
	
	public void deleteReferent(String ref){
			for(int i=0;i<referenti.size();i++){
				if(referenti.get(i).equals(ref)){
					referenti.remove(i);
					return;
				}
			}
	}
	
	public void deleteTotiReferentii(){
		referenti.clear();
	}
	
	public void adaugaCuvantCheie(String cuvant){
		cuvinteCheie.add(cuvant);
	}
	
	public void adaugaReferent(String ref){
		referenti.add(ref);
	}
	
	public boolean cautaDupaCuvinteCheie(List<String> cuvinte){
		for(String cuvExistent:cuvinteCheie){
			for(String cuv:cuvinte){
				if(cuvExistent.equals(cuv))
					return true;
			}
		}
		return false;
	}
	 
	public boolean cautaDupaAutor(String autor){
		for(String autorExistent:referenti){
			if(autorExistent.contains(autor))
				return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		String ref = "";
		String cuvCheie = "";
		
		for(int i=0;i<referenti.size();i++){
			if(i==referenti.size()-1)
				ref+=referenti.get(i);
			else
				ref+=referenti.get(i)+",";
		}
		
		for(int i=0;i<cuvinteCheie.size();i++){
			if(i==cuvinteCheie.size()-1)
				cuvCheie+=cuvinteCheie.get(i);
			else
				cuvCheie+=cuvinteCheie.get(i)+",";
		}
		
		return titlu+";"+ref+";"+anAparitie+";"+editura+";"+cuvCheie;
	}
	
	public static Carte getCarteFromString(String carteString){
		Carte carte = new Carte();
		String []atr = carteString.split(";");
		String []referenti = atr[1].split(",");
		String []cuvCheie = atr[4].split(",");

		carte.titlu=atr[0];
		for(String s:referenti){
			carte.adaugaReferent(s);
		}
		carte.anAparitie = atr[2];
		for(String s:cuvCheie){
			carte.adaugaCuvantCheie(s);
		}
		carte.editura = atr[3];
		
		return carte;
	}
	
}

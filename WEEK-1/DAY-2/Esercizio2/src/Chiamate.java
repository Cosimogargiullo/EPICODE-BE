
public class Chiamate {

	private String nomeChiamata;
	private int durata;
	
	public Chiamate(String nomeChiamata, int durata) {
		this.nomeChiamata = nomeChiamata;
		this.durata = durata;
	}
	
	public String getNomeChiamata() {
		return nomeChiamata;
	}
	
	public void setNomeChiamata(String nomeChiamata) {
		this.nomeChiamata = nomeChiamata;
	}
	
	public int getDurata() {
		return durata;
	}
	
	public void setDurata(int durata) {
		this.durata = durata;
	}
	
}

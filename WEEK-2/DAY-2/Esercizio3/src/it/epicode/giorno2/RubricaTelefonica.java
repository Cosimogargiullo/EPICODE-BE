package it.epicode.giorno2;

	import java.util.HashMap;

	public class RubricaTelefonica {
	    private HashMap<String, String> contatti;

	    public RubricaTelefonica() {
	        contatti = new HashMap<String, String>();
	    }

	    public void inserisciContatto(String nome, String numero) {
	        contatti.put(nome, numero);
	    }

	    public void cancellaContatto(String nome) {
	        contatti.remove(nome);
	    }

	    public String cercaContattoPerNumero(String numero) {
	        for (String nome : contatti.keySet()) {
	            if (contatti.get(nome).equals(numero)) {
	                return nome;
	            }
	        }
	        return null;
	    }

	    public String cercaNumeroPerContatto(String nome) {
	        return contatti.get(nome);
	    }

	    public void stampaContatti() {
	        for (String nome : contatti.keySet()) {
	            System.out.println(nome + ": " + contatti.get(nome));
	        }
	    }
	}


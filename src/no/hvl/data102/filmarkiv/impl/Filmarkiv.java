package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

	public class Filmarkiv implements FilmarkivADT {

	    private Film[] filmer;
	    private int antall;

	    public Filmarkiv(int kapasitet) {
	        filmer = new Film[kapasitet];
	        antall = 0;
	    }

	    @Override
	    public Film finnFilm(int nr) {
	        for (int i = 0; i < antall; i++) {
	            if (filmer[i].getFilmNr() == nr) {
	                return filmer[i];
	            }
	        }
	        return null;
	    }

	    @Override
	    public void leggTilFilm(Film nyFilm) {
	        if (antall == filmer.length) {
	            utvid();
	        }
	        filmer[antall] = nyFilm;
	        antall++;
	    }

	    @Override
	    public boolean slettFilm(int filmnr) {
	        for (int i = 0; i < antall; i++) {
	            if (filmer[i].getFilmNr() == filmnr) {
	                // Flytt siste film til den slettede filmens plass
	                filmer[i] = filmer[antall - 1];
	                filmer[antall - 1] = null; 
	                antall--;
	                return true;
	            }
	        }
	        return false;
	    }

	    @Override
	    public Film[] soekTittel(String delstreng) {
	        Film[] resultat = new Film[antall];
	        int teller = 0;
	        for (int i = 0; i < antall; i++) {
	            if (filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
	                resultat[teller] = filmer[i];
	                teller++;
	            }
	        }
	        return trimTabell(resultat, teller);
	    }

	    @Override
	    public Film[] soekProdusent(String delstreng) {
	        Film[] resultat = new Film[antall];
	        int teller = 0;
	        for (int i = 0; i < antall; i++) {
	            if (filmer[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
	                resultat[teller] = filmer[i];
	                teller++;
	            }
	        }
	        return trimTabell(resultat, teller);
	    }

	    @Override
	    public int antall(Sjanger sjanger) {
	        int antallSjanger = 0;
	        for (int i = 0; i < antall; i++) {
	            if (filmer[i].getSjanger() == sjanger) {
	                antallSjanger++;
	            }
	        }
	        return antallSjanger;
	    }

	    @Override
	    public int antall() {
	        return antall;
	    }

	    private void utvid() {
	        Film[] nyTabell = new Film[filmer.length * 2];
	        System.arraycopy(filmer, 0, nyTabell, 0, filmer.length);
	        filmer = nyTabell;
	    }

	    // Hjelpemetode for å trimme tabeller
	    private Film[] trimTabell(Film[] tabell, int antallElementer) {
	        Film[] trimmetTabell = new Film[antallElementer];
	        System.arraycopy(tabell, 0, trimmetTabell, 0, antallElementer);
	        return trimmetTabell;
	    }

		@Override
		public boolean tomArkiv() {
			for (int i = 0; i < antall; i++) {      
	                filmer[i] = filmer[antall - 1];
	                filmer[antall - 1] = null; 
	                antall--;
	        }

	        if (antall == 0) {
	        	return true;
	        }
	        return false;
	    }
	}



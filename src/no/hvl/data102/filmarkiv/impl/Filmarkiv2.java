package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	public LinearNode<Film> forste = null;

	private int antall = 0;
	private LinearNode<Film> temp = null;

	public Filmarkiv2(Film film) {
		forste = new LinearNode<>(film);
		antall++;
	}

	@Override
	public Film finnFilm(int nr) {

		temp = forste;

		while (temp != null) {
			if (temp.data.getFilmNr() == nr) {
				return temp.data;
			}
			temp = temp.neste;
		}

		return temp.data;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {

		temp = new LinearNode<>(nyFilm);
		temp.neste = forste;
		forste = temp;
		antall++;

	}

	@Override
	public boolean slettFilm(int filmnr) {

		if (forste.data.getFilmNr() == filmnr) {
			forste = forste.neste;
			antall--;
			return true;
		}

		temp = forste.neste;
		LinearNode<Film> temp2 = forste;

		while (temp != null) {
			if (temp.data.getFilmNr() == filmnr) {
				temp2.neste = temp.neste;
				antall--;
				return true;
			}
			temp = temp.neste;
			temp2 = temp2.neste;
		}

		return false;
	}

	@Override
	public boolean tomArkiv() {

		forste = null;
		antall = 0;

		return true;
	}

	@Override
	public Film[] soekTittel(String delstreng) {

		Film[] resultat = new Film[antall];
		int teller = 0;
		temp = forste;

		while (temp != null) {
			if (temp.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				resultat[teller] = temp.data;
				teller++;
			}
			temp = temp.neste;
		}

		return resultat;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {

		Film[] resultat = new Film[antall];
		int teller = 0;
		temp = forste;

		while (temp != null) {
			if (temp.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				resultat[teller] = temp.data;
				teller++;
			}
			temp = temp.neste;
		}

		return resultat;
	}

	@Override
	public int antall(Sjanger sjanger) {
		
		int antallSjanger = 0;
		temp = forste;

		while (temp != null) {
			if (temp.data.getSjanger() == sjanger) {
				antallSjanger++;
			}
			temp = temp.neste;
		}

		return antallSjanger;
	}

	@Override
	public int antall() {
		return antall;
	}

}

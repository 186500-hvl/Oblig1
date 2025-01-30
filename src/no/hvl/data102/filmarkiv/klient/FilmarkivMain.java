package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.impl.*;

public class FilmarkivMain {

	public static void main(String[] args) {
		
		Filmarkiv arkiv1 = new Filmarkiv(3);
		Meny meny = new Meny(arkiv1);
		
		meny.start();
		
	}

}

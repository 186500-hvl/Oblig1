package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.*;

class FilmarkivTest {

	Film film1 = new Film(1, "The Shawshank Redemption", "Frank Darabont", 1994, Sjanger.DRAMA, "Columbia Pictures");
	Film film2 = new Film(2, "The Dark Knight", "Christopher Nolan", 2008, Sjanger.ACTION, "Warner Bros.");
	
	Filmarkiv arkiv1 = new Filmarkiv(3);
	Filmarkiv2 lenke1 = new Filmarkiv2(film1);
	
	@BeforeEach
	void nullstill() {
		arkiv1.tomArkiv();
		lenke1.tomArkiv();
	}
	
	@Test
	void testAntall() {
		//Filmarkiv test (tabell)
		assertEquals(0, arkiv1.antall());
		arkiv1.leggTilFilm(film1);
		assertEquals(1, arkiv1.antall());
		
		//Filmarkiv2 test (lenket kjede)
		assertEquals(0,lenke1.antall());
		lenke1.leggTilFilm(film1);
		assertEquals(1,lenke1.antall());
	}
	
	@Test
	void testSlett() {
		arkiv1.leggTilFilm(film1);
		arkiv1.slettFilm(1);
		assertEquals(0, arkiv1.antall());
		
		lenke1.leggTilFilm(film1);
		assertTrue(lenke1.slettFilm(1));
		assertEquals(0, lenke1.antall());
	}
	
	@Test
	void testSjanger( ) {
		arkiv1.leggTilFilm(film1);
		arkiv1.leggTilFilm(film2);	
		assertEquals(1, arkiv1.antall(Sjanger.ACTION));
		
		lenke1.leggTilFilm(film1);
		lenke1.leggTilFilm(film2);	
		assertEquals(1, lenke1.antall(Sjanger.DRAMA));
		
	}
}

package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.*;

class FilmarkivTest {

	Filmarkiv arkiv1 = new Filmarkiv(3);
	Film film1 = new Film(1, "tittel1", "produsent1", 2000, Sjanger.ACTION, "filmselskap1");
	
	
	@Test
	void testAntall() {
		assertEquals(0, arkiv1.antall());
		arkiv1.leggTilFilm(film1);
		assertEquals(1, arkiv1.antall());
	}
	
	@Test
	void testSlett() {
		arkiv1.slettFilm(1);
		assertEquals(0, arkiv1.antall());
		arkiv1.leggTilFilm(film1);
		arkiv1.tomArkiv();
		assertEquals(0, arkiv1.antall());
	}
}

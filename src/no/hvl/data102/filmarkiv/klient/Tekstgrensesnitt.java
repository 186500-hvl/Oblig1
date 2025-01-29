import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.adt.Film;
import no.hvl.data102.filmarkiv.adt.Sjanger;

public class Tekstgrensesnitt {

    // Leser inn opplysninger om en film fra tastatur og returnerer et Film-objekt
    public Film lesFilm() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Filmnummer: ");
        int filmNr = scanner.nextInt();
        scanner.nextLine(); // For å fjerne newline

        System.out.print("Tittel: ");
        String tittel = scanner.nextLine();

        System.out.print("Produsent: ");
        String produsent = scanner.nextLine();

        System.out.print("Lanseringsår: ");
        int lanseringsår = scanner.nextInt();
        scanner.nextLine(); // For å fjerne newline

        System.out.print("Sjanger (ACTION, DRAMA, COMEDY, SCIFI, THRILLER, HORROR): ");
        Sjanger sjanger = Sjanger.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Filmselskap: ");
        String filmselskap = scanner.nextLine();

        return new Film(filmNr, tittel, produsent, lanseringsår, sjanger, filmselskap);
    }

    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        if (film == null) {
            System.out.println("Film ikke funnet.");
            return;
        }
        System.out.println("Filmnummer: " + film.getFilmNr());
        System.out.println("Tittel: " + film.getTittel());
        System.out.println("Produsent: " + film.getProdusent());
        System.out.println("Lanseringsår: " + film.getLanseringsår());
        System.out.println("Sjanger: " + film.getSjanger());
        System.out.println("Filmselskap: " + film.getFilmselskap());
        System.out.println();
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekTittel(delstreng);
        if (filmer.length == 0) {
            System.out.println("Ingen filmer funnet med delstreng i tittel: " + delstreng);
            return;
        }
        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekProdusent(delstreng);
        if (filmer.length == 0) {
            System.out.println("Ingen filmer funnet med produsent: " + delstreng);
            return;
        }
        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
    // og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Totalt antall filmer: " + arkiv.antall());
        for (Sjanger sjanger : Sjanger.values()) {
            System.out.println(sjanger + ": " + arkiv.antall(sjanger));
        }
    }

    // ... andre metoder ...

    // Eksempel på en metode for å vise alle filmer i arkivet
    public void visAlleFilmer(FilmarkivADT arkiv) {
        Film[] filmer = arkiv.soekTittel(""); // Tom delstreng for å få alle filmer
        if (filmer.length == 0) {
            System.out.println("Filmarkivet er tomt.");
            return;
        }
        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }

    // Eksempel på en metode for å slette en film
    public void slettFilm(FilmarkivADT arkiv) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Oppgi filmnummeret til filmen du vil slette: ");
        int filmnr = scanner.nextInt();
        if (arkiv.slettFilm(filmnr)) {
            System.out.println("Filmen med filmnummer " + filmnr + " er slettet.");
        } else {
            System.out.println("Fant ingen film med filmnummer " + filmnr + ".");
        }
    }

    // Eksempel på en metode for å søke etter tittel
    public void soekEtterTittel(FilmarkivADT arkiv) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Oppgi delstreng i tittel: ");
        String delstreng = scanner.nextLine();
        skrivUtFilmDelstrengITittel(arkiv, delstreng);
    }

    // Eksempel på en metode for å søke etter produsent
    public void soekEtterProdusent(FilmarkivADT arkiv) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Oppgi produsent: ");
        String produsent = scanner.nextLine();
        skrivUtFilmProdusent(arkiv, produsent);
    }
}

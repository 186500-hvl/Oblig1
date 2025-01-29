package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.Filmarkiv;
import no.hvl.data102.filmarkiv.adt.Film;
import no.hvl.data102.filmarkiv.adt.Sjanger;

public class Meny {

    private Filmarkiv filmarkiv;
    private Tekstgrensesnitt tekstgrensesnitt;

    public Meny(Filmarkiv filmarkiv) {
        this.filmarkiv = filmarkiv;
        this.tekstgrensesnitt = new Tekstgrensesnitt();
    }

    public void start() {
        // Legg til noen filmer (hardkodet eller fra fil)
        // Eksempel på hardkoding av filmer:
        filmarkiv.leggTilFilm(new Film(1, "The Shawshank Redemption", "Frank Darabont", 1994, Sjanger.DRAMA, "Columbia Pictures"));
        filmarkiv.leggTilFilm(new Film(2, "The Dark Knight", "Christopher Nolan", 2008, Sjanger.ACTION, "Warner Bros."));
        // ... legg til flere filmer ...

        Scanner scanner = new Scanner(System.in);
        int valg;

        do {
            visMeny();
            valg = scanner.nextInt();
            scanner.nextLine(); // For å fjerne newline

            switch (valg) {
                case 1:
                    tekstgrensesnitt.visAlleFilmer(filmarkiv);
                    break;
                case 2:
                    tekstgrensesnitt.leggTilFilm(filmarkiv);
                    break;
                case 3:
                    tekstgrensesnitt.slettFilm(filmarkiv);
                    break;
                case 4:
                    tekstgrensesnitt.soekEtterTittel(filmarkiv);
                    break;
                case 5:
                    tekstgrensesnitt.soekEtterProdusent(filmarkiv);
                    break;
                case 0:
                    System.out.println("Avslutter programmet...");
                    break;
                default:
                    System.out.println("Ugyldig valg!");
            }
        } while (valg != 0);

        scanner.close();
    }

    private void visMeny() {
        System.out.println("\nFilmarkivmeny:");
        System.out.println("1. Vis alle filmer");
        System.out.println("2. Legg til film");
        System.out.println("3. Slett film");
        System.out.println("4. Søk etter tittel");
        System.out.println("5. Søk etter produsent");
        System.out.println("0. Avslutt");
        System.out.print("Valg: ");
    }
}
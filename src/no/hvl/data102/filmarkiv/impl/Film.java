package no.hvl.data102.filmarkiv.impl;



public class Film {

    private int filmNr;
    private String produsent;
    private String tittel;
    private int lanseringsår;
    private Sjanger sjanger;
    private String filmselskap;

    public Film() {
       
    }

    public Film(int filmNr, String tittel, String produsent, int lanseringsår, Sjanger sjanger, String filmselskap) {
        this.filmNr = filmNr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.lanseringsår = lanseringsår;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }

    
    public int getFilmNr() {
        return filmNr;
    }

    public void setFilmNr(int filmNr) {
        this.filmNr = filmNr;
    }

    public String getProdusent() {
        return produsent;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getLanseringsår() {
        return lanseringsår;
    }

    public void setLanseringsår(int lanseringsår) {
        this.lanseringsår = lanseringsår;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Film film = (Film) obj;
        return filmNr == film.filmNr;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(filmNr);
    }
}

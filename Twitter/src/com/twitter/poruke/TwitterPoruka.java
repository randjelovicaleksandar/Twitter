package com.twitter.poruke;

/**
 * Predstavlja poruku(twit) koju unosi neki korisnik na web sajtu Twitter.com
 * 
 * @author randjelovicaleksandar
 * @version 1.0
 *
 */

public class TwitterPoruka {
	
	/**
	 * Identitet korisnika.
	 */
	private String korisnik;
	
	/**
	 * Poruka koju korisnik unosi.
	 */
	private String poruka;

	/**
	 * Metoda vraca identitet korisnika tj. vrednost atributa korisnik.
	 * @return identitet korisnika kao String
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda postavlja identitet korisnika na unetu vrednost.
	 * @param korisnik - identitet korisnika
	 * @throws java.lang.RuntimeException ako je unet identitet korisnika null ili prazan String
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.equals(""))
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda vraca poruku koju je uneo korisnik tj. vrednost atributa poruka.
	 * @return poruka korisnika kao String
	 */
	public String getPoruka() {
		return poruka;
	}

	/**
	 * Metoda postavlja atribut poruka na unetu vrednost.
	 * @param poruka koju unosi korisnik
	 * @throws java.lang.RuntimeException ako je uneta poruka null ili duza od 140 karaktera
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Metoda vraca String sa podacima o identitetu korisnika i poruci koju je korisnik uneo.
	 * @return podaci o korisniku i poruci kao String
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

}

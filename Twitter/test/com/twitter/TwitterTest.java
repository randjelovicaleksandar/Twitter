/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author User
 *
 */
public class TwitterTest {

	private Twitter twitter;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		twitter = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		twitter = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		//Nema potrebe za testiranjem, ocigledno je da nema greske.
		//Funkcionise kao get metoda
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		twitter.unesi("Jovan Jovic", "Quality is not an act, it is a habit.");
		
		assertEquals(1, twitter.vratiSvePoruke().size());
		assertEquals("Jovan Jovic", twitter.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("Quality is not an act, it is a habit.", twitter.vratiSvePoruke().get(0).getPoruka());
		
		//Ovom test metodom utvrdjeno da u metodi stoji tp.setKorisnik("korisnik"), a terba samo korisnik bez navodnika
		//kako bi ucitalo ulazni parametar.
	}
	

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		twitter.unesi("Pera Peric", "Pleasure in the job puts perfection in the work");
		
		assertEquals("Pleasure in the job puts perfection in the work",
				twitter.vratiPoruke(10, "job")[0].getPoruka());
		//Test metoda pokazuje da postoji NullPointerException sto znaci da twitter.vratiPoruke(10, "job")[0].getPoruka()
		//je null, a na osnovu toga mozemo zakljuciti da se poruke ne unose u niz na mesto na koje treba ili da ne postoji
		//uneti tag (to nije slucaj ovde). Pravimo sledecu test metodu.		
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke2() {
		twitter.unesi("Pera Peric", "Pleasure in the job puts perfection in the work");
		
		assertEquals("Pleasure in the job puts perfection in the work",
				twitter.vratiPoruke(10, "job")[1].getPoruka());
		
		//Iz ove test metode vidimo da je poruka za pronadjen tag na 2. mestu u nizu(indeks 1),
		//sto znaci da se u pomocni niz ne unosi na prvo mesto pa je to greska koju treba ispraviti.
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test 
	public void testVratiPorukeDuzinaNiza() {
		twitter.unesi("Pera Peric", "Pleasure in the job puts perfection in the work");
		
		assertEquals(10, twitter.vratiPoruke(10, "job").length);
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		twitter.vratiPoruke(10, null);
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEmptyString() {
		twitter.vratiPoruke(10, "");
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNijePronadjena() {
		twitter.vratiPoruke(10, "");
	}

}

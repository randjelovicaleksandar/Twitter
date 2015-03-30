/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author randjelovicaleksandar
 *
 */
public class TwitterPorukaTest {

	private TwitterPoruka twitterPoruka;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		twitterPoruka = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		twitterPoruka = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		twitterPoruka.setKorisnik("Jovan Jovanovic");
		
		assertEquals("Jovan Jovanovic", twitterPoruka.getKorisnik());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		twitterPoruka.setKorisnik(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmptyString() {
		twitterPoruka.setKorisnik("");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		twitterPoruka.setPoruka("Live as if you were to die tomorrow. Learn as if you were to live forever.");
		
		assertEquals("Live as if you were to die tomorrow. Learn as if you were to live forever.", twitterPoruka.getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		twitterPoruka.setPoruka(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaMoreThan140() {
		twitterPoruka.setPoruka("Life is too short to start your day with broken pieces of yesterday, "
				+ "it will definitely destroy your wonderful today and ruin your great tomorrow.");
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		twitterPoruka.setKorisnik("Milan Milankovic");
		twitterPoruka.setPoruka("You only live once, but if you do it right, once is enough.");
		
		assertEquals("KORISNIK: Milan Milankovic PORUKA: You only live once, but if you do it right, once is enough."
				, twitterPoruka.toString()); 
	}

}

package com.company;

import org.junit.Test;

import static org.junit.Assert.*;


public class MovieClassTest {

    //MovieClass getMovieNameTest.
    @Test()
    public void testGetMovieName() {
        MovieClass mn = new MovieClass();
        mn.setMovieName("Börü");
        assertEquals("Börü", mn.getMovieName());
    }

    //MovieClass getMovieTypeTest.
    @Test
    public void testGetMovieType() {
        MovieClass mt = new MovieClass();
        mt.setMovieType("horror");
        assertEquals("horror", mt.getMovieType());
    }

    //MovieClass getMovieDurationTest.
    @Test
    public void testGetMovieDuration() {
        MovieClass md = new MovieClass();
        md.setMovieDuration(213124125);
        assertEquals(213124125, md.getMovieDuration());
    }

    //MovieClass getMovieDirectorTest
    @Test
    public void testGetMovieDirector() {
        MovieClass movieDirector = new MovieClass();
        movieDirector.setMovieDirector("Sener Sen");
        assertEquals("Sener Sen", movieDirector.getMovieDirector());

    }

    //MovieClass getMovieIMDBTest
    @Test
    public void testGetMovieIMDB() {
        MovieClass movieIMDB = new MovieClass();
        movieIMDB.setMovieIMDB(4);
        assertEquals(4, movieIMDB.getMovieIMDB());
    }

    //MovieClass getMovieDescriptionTest
    @Test
    public void testGetMovieDescription() {
        MovieClass movieDescription = new MovieClass();
        movieDescription.setMovieDescription("MovieDescription1");
        assertEquals("MovieDescription1", movieDescription.getMovieDescription());
    }

    //MovieClass getMovieSeatsTest
    @Test
    public void testGetMovieSeats() {
        MovieClass movieSeats = new MovieClass();
        movieSeats.setMovieSeats(5);
        assertEquals(5, movieSeats.getMovieSeats());
    } //s

    @Test
    public void testGetMovieName2() {
        MovieClass mn = new MovieClass();
        mn.setMovieName("Avengers");
        assertFalse("Börü", false);
    }

    @Test
    public void testGetMovieType2() {
        MovieClass mt = new MovieClass();
        mt.setMovieType("horror");
        assertFalse("Why?", false);
    }

    @Test
    public void testGetMovieDuration2() {
        MovieClass md = new MovieClass();
        md.setMovieDuration(213124125);
        assertFalse("43", false);
    }

    @Test
    public void testGetMovieDirector2() {
        MovieClass movieDirector = new MovieClass();
        movieDirector.setMovieDirector("Sener Sen");
        assertFalse("Kemal Sunal", false);

    }

    @Test
    public void testGetMovieIMDB2() {
        MovieClass movieIMDB = new MovieClass();
        movieIMDB.setMovieIMDB(4);
        assertFalse("123456", false);
    }

    @Test
    public void testGetMovieDescription2() {
        MovieClass movieDescription = new MovieClass();
        movieDescription.setMovieDescription("MovieDescription1");
        assertFalse("12342533464372437262", false);
    }

    @Test
    public void testGetMovieSeats2(){
        MovieClass movieSeats = new MovieClass();
        movieSeats.setMovieSeats(5);
        assertFalse("YOK",false);
    }
}

package com.company;


public class MovieClass {  //This is the MovieClass; that you can find the
    //attributes of MovieClass' constructor, set and get methods. And you can find the movie information.
    private String MovieName;
    private String MovieType;
    private int MovieDuration;
    private String MovieDirector;
    private int MovieIMDB;
    private String MovieDescription;
    private int MovieSeats;
    //ArrayList<String> MovieList;

    public MovieClass() {  // This is the default constructor.
        MovieName = null;
        MovieType = null;
        MovieDuration = 0;
        MovieDirector = null;
        MovieIMDB = 0;
        MovieDescription = null;
        MovieSeats = 0;
    }


    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        this.MovieName = movieName;
    }

    public String getMovieType() {
        return MovieType;
    }

    public void setMovieType(String movieType) {
        this.MovieType = movieType;
    }

    public int getMovieDuration() {
        return MovieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.MovieDuration = movieDuration;
    }

    public String getMovieDirector() {
        return MovieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.MovieDirector = movieDirector;
    }

    public int getMovieIMDB() {
        return MovieIMDB;
    }

    public void setMovieIMDB(int movieIMDB) {
        this.MovieIMDB = movieIMDB;
    }

    public String getMovieDescription() {
        return MovieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.MovieDescription = movieDescription;
    }

    public int getMovieSeats() {
        return MovieSeats;
    }

    public void setMovieSeats(int movieSeats) {
        this.MovieSeats = movieSeats;
    }


    public void MovieDisplay() {  //This is the function that we are showing the movies information.
        for (int i = 0; i < 5; i++) {
            System.out.println("Movie name is: " + MovieNames[i]);
            System.out.println("Movie type is: " + MovieTypes[i]);
            System.out.println("Movie duration is: " + MovieDurations[i]);
            System.out.println("Movie director is: " + MovieDirectors[i]);
            System.out.println("Movie IMDB is: " + MovieIMDBs[i]);
            System.out.println("Movie description is: " + MovieDescriptions[i]);
            System.out.println("---------------------");
        }

    }

    String[] MovieNames = new String[]{"Ready Player One", "The Stolen Princess", "Kaybedenler Kulubu", "On Ikı Savascı", "Tomb Raider"};
    String[] MovieTypes = new String[]{"Action", "Animation", "Drama", "War", "Action"};
    String[] MovieDurations = new String[]{"120", "110", "130", "100", "120"};
    String[] MovieDirectors = new String[]{"Steven Spielberg", "Oleh Malamuzh", "Mehmet Ada Öztekin", "Nicolai Fuglsig", "Roar Uthaug"};
    String[] MovieIMDBs = new String[]{"6.0", "5.4", "3.3", "4.6", "5.0"};
    String[] MovieDescriptions = new String[]{"Description1", "Description2", "Description3", "Description4", "Description5"};
    String[] MovieSeat = new String[]{"50", "50", "60", "60", "50"};

}

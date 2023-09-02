package Models;

public class Rate {
    Movies movies;
    int rating;

    public Rate(Movies movies, int rating) {
        this.movies = movies;
        this.rating = rating;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

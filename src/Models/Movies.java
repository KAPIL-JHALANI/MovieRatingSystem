package Models;

import java.util.List;

public class Movies {

    public enum Genre{
        ACTION,COMEDY,DRAMA,ROMANCE
    }
    String name;
    double rating;
    int year;
    List<Genre> genreList;

    public Movies(String name, int year, List<Genre> genreList) {
        this.name = name;
        this.rating = 0;
        this.year = year;
        this.genreList = genreList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
}

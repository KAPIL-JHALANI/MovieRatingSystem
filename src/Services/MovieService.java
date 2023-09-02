package Services;

import Models.Movies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieService {

    List<Movies> moviesList;
    public MovieService() {
        this.moviesList = new ArrayList<>();
    }
    public void addMovies(Movies movie){
        this.moviesList.add(movie);
    }

    public List<Movies> getMoviesList() {
        return moviesList;
    }

    public List<Movies>getTopByYear(int year){
        List<Movies>temp=new ArrayList<>();
        for(int i=0;i<moviesList.size();i++){
            if(moviesList.get(i).getYear()==year){
                temp.add(moviesList.get(i));
            }
        }
        Collections.sort(temp,(a,b)-> (int) (b.getRating()-a.getRating()));
        return temp;
    }
}

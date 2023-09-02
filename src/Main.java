import Models.Movies;
import Models.Rate;
import Models.User;
import Services.MovieService;
import Services.UserService;

import java.util.ArrayList;
import java.util.List;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        MovieService movieService=new MovieService();
        List<Movies.Genre>genreList=new ArrayList<>();
        genreList.add(Movies.Genre.ACTION);
        genreList.add(Movies.Genre.COMEDY);
        Movies movie1=new Movies("Don",2006,genreList);

        List<Movies.Genre>genreList1=new ArrayList<>();
        genreList1.add(Movies.Genre.DRAMA);
        Movies movie2=new Movies("TIGER",2008,genreList1);

        List<Movies.Genre>genreList3=new ArrayList<>();
        genreList3.add(Movies.Genre.COMEDY);
        Movies movie3=new Movies("Padmavat",2006,genreList3);

        List<Movies.Genre>genreList4=new ArrayList<>();
        genreList4.add(Movies.Genre.DRAMA);
        Movies movie4=new Movies("Lunchbox-2",2022,genreList4);

        List<Movies.Genre>genreList5=new ArrayList<>();
        genreList5.add(Movies.Genre.DRAMA);
        Movies movie5=new Movies("Guru",2007,genreList5);

        List<Movies.Genre>genreList6=new ArrayList<>();
        genreList6.add(Movies.Genre.ROMANCE);
        Movies movie6=new Movies("Metro",2006,genreList6);

        movieService.addMovies(movie1);
        movieService.addMovies(movie2);
        movieService.addMovies(movie3);
        movieService.addMovies(movie4);
        movieService.addMovies(movie5);
        movieService.addMovies(movie6);

        System.out.println(movieService.getMoviesList().get(1).getName());


        UserService userService=new UserService(movieService);

        User user1=new User("SRK");
        User user2=new User("Salman");
        User user3=new User("Deepika");

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);

        System.out.println(userService.getUsers().get(0).getName());


        System.out.println(userService.rateMovie("SRK", "Don", 2));
        System.out.println(userService.rateMovie("SRK", "Padmavat", 8));
        System.out.println(userService.rateMovie("SRK", "TIGER", 8));
        System.out.println(userService.rateMovie("Salaman", "Don", 5));
        System.out.println(userService.rateMovie("Deepika", "Don", 9));
        System.out.println(userService.rateMovie("Deepika", "Guru", 6));
        System.out.println(userService.rateMovie("SRK", "Guru", 6));

//        userService.deleteReview("SRK","Don");
//        userService.deleteReview("SRK","Padmavat");
//        userService.updateReview("SRK","Don",10);
        List<Rate>rateList=userService.getUserRateList("SRK");
        for(int i=0;i<rateList.size();i++){
            System.out.println(rateList.get(i).getMovies().getName()+" - "+rateList.get(i).getRating());
        }
        System.out.println(movieService.getTopByYear(2007).get(0).getName() +" - " + movieService.getTopByYear(2007).get(0).getRating());
    }
}
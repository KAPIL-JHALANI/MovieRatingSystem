package Services;

import Models.Movies;
import Models.Rate;
import Models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User>users;
    MovieService service;
    public UserService(MovieService movieService) {
        this.users = new ArrayList<>();
        this.service=movieService;
    }

    public void addUser(User user){
        users.add(user);
    }

    public List<Rate> fetchRatingForUser(String name){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getName().equals(name)){
                return users.get(i).getRateList();
            }
        }
        return new ArrayList<>();
    }

    public boolean rateMovie(String user, String movie,int rating){
        //update rating for the particular movie;
        for(int i=0;i<users.size();i++){
            if(users.get(i).getName().equals(user)){
                User reviwer=users.get(i);
                for(int j=0;j<reviwer.getRateList().size();j++){
                    if(reviwer.getRateList().get(j).getMovies().getName().equals(movie)){
                        return false;
                    }
                }

                for(int j=0;j<service.moviesList.size();j++){
                    if(service.moviesList.get(j).getName().equals(movie)){
                        users.get(i).getRateList().add(new Rate(service.moviesList.get(j),rating));
                        if(reviwer.getNumberOfReviews()<3){
                            service.moviesList.get(j).setRating(service.moviesList.get(j).getRating()+rating);
                        }else{
                            service.moviesList.get(j).setRating(service.moviesList.get(j).getRating()+(rating*2));
                        }
                        users.get(i).setNumberOfReviews(users.get(i).getNumberOfReviews()+1);
                        if(users.get(i).getNumberOfReviews()>=3){
                            users.get(i).setCatagory(User.Catagory.CRITIC);
                        }
                    }
                }
            }
        }
        return true;
    }
    public void updateReview(String user, String movie,int rating){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getName().equals(user)) {
                User reviwer = users.get(i);
                List<Rate>list=reviwer.getRateList();
                for(int j=0;j<list.size();j++){
                    if(list.get(j).getMovies().getName().equals(movie)){
                        Movies movies=list.get(j).getMovies();
                        if(reviwer.getNumberOfReviews()<3){
                            movies.setRating(movies.getRating()+rating-list.get(j).getRating());
                        }else{
                            movies.setRating(movies.getRating()+(rating*2)-(list.get(j).getRating()*2));
                        }
                        list.get(j).setRating(rating);
                    }
                }
            }
        }

    }
    public void deleteReview(String user, String movie){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getName().equals(user)) {
                User reviwer = users.get(i);
                List<Rate>list=reviwer.getRateList();
                for(int j=0;j<list.size();j++){
                    if(list.get(j).getMovies().getName().equals(movie)){
                        Movies movies=list.get(j).getMovies();
                        if(reviwer.getNumberOfReviews()<3){
                            movies.setRating(movies.getRating()-list.get(j).getRating());
                        }else{
                            movies.setRating(movies.getRating()-(list.get(j).getRating()*2));
                        }
                        list.remove(j);
                    }
                }
            }
        }
    }

    public List<Rate> getUserRateList(String name){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getName().equals(name)){
                return users.get(i).getRateList();
            }
        }
        return new ArrayList<>();
    }
    public List<User> getUsers() {
        return users;
    }
}

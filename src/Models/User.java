package Models;

import java.util.ArrayList;
import java.util.List;

public class User {

    public enum Catagory{
        VIEWER,CRITIC
    }
    String name;
    Catagory catagory;
    int numberOfReviews;
    List<Rate> rateList;

    public User(String name) {
        this.name = name;
        this.catagory = Catagory.VIEWER;
        this.numberOfReviews = 0;
        this.rateList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Catagory getCatagory() {
        return catagory;
    }

    public void setCatagory(Catagory catagory) {
        this.catagory = catagory;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public List<Rate> getRateList() {
        return rateList;
    }

    public void setRateList(List<Rate> rateList) {
        this.rateList = rateList;
    }
}

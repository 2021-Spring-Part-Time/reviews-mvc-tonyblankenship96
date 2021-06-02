package org.wecancoeit.reviews;

public class Quarterback {

    public Long id;
    public String name;
    public String image;
    public String yearsActive;
    public String superBowlWins;
    public String passerRating;
    public String tdToInt;

    public Quarterback(long id, String name, String image, String yearsActive, String superBowlWins, String passerRating, String tdToInt) {
        this.id = id;
        this.name = name;
        this.image=image;
        this.yearsActive = yearsActive;
        this.superBowlWins= superBowlWins;
        this.passerRating = passerRating;
        this. tdToInt = tdToInt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage(){
        return image;
    }

    public String getYearsActive() {
        return yearsActive;
    }

    public String getSuperBowlWins(){
        return superBowlWins;
    }

    public  String getPasserRating(){
        return passerRating;
    }

    public  String getTdToInt(){
        return tdToInt;
    }
}

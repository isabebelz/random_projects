public class Film {
    String name;
    int releaseYear;
    boolean includedInThePlan;
    private double sumOfRatings;
    private int totalReview;
    int durationInMinutes;

    int getTotalReview(){
        return totalReview;
    }

    void displayTechnicalSheet(){
        System.out.println("Name: " + name);
        System.out.println("Release year: " + releaseYear);
    }

    void rate(double grade){
        sumOfRatings += grade;
        totalReview++;
    }

    double getTheAverage(){
        return sumOfRatings / totalReview;
    }
}

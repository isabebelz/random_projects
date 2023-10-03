package Classifications;

public class RecommendationFilter {
    public void filter(Classification classification) {
        if(classification.getClassification() >= 4){
            System.out.println("This title is among the favorites of the moment");
        }
    }
}

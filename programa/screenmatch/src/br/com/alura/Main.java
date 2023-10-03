import Classifications.RecommendationFilter;
import TimeCalculator.TitleCalculator;
import br.com.alura.screenmatch.modelos.Episode;
import br.com.alura.screenmatch.modelos.Film;
import br.com.alura.screenmatch.modelos.Series;

public class Main {
    public static void main(String[] args) {

        Film godfather = new Film();
        godfather.setName("Godfather");
        godfather.setReleaseYear(1970);
        godfather.setDurationInMinutes(180);

        godfather.displayTechnicalSheet();
        godfather.rate(10);
        godfather.rate(8);

        System.out.println("Total review: " + godfather.getTotalReview());

        Series fleabag = new Series();

        fleabag.setName("Fleabag");
        fleabag.setSeasons(2);
        fleabag.setActive(false);
        fleabag.setReleaseYear(2016);
        fleabag.setMinutesPerEpisode(25);
        fleabag.setEpisodesPerSeason(6);

        Episode episode = new Episode();

        episode.setSeries(fleabag);
        episode.setName("T2E1");
        episode.setScore(100);

        fleabag.displayTechnicalSheet();

        TitleCalculator calculator = new TitleCalculator();

        calculator.addTitle(fleabag);
        calculator.addTitle(godfather);

        System.out.println("Total time to watch everything: " + calculator.getTotalTime());

        RecommendationFilter recommendationFilter = new RecommendationFilter();

        //recommendationFilter.filter(godfather);
        recommendationFilter.filter(episode);



    }
}

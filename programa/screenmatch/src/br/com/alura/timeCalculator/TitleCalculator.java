package TimeCalculator;

import br.com.alura.screenmatch.modelos.Title;

public class TitleCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void addTitle(Title title) {
        System.out.println("Adding duration in minutes of " + title);
        totalTime += title.getDurationInMinutes();
    }

}

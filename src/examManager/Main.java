package examManager;

import java.util.List;
import java.util.function.ToDoubleFunction;

public class Main {

    public static void main(String[] args) {

        ToDoubleFunction<List<Double>>  average = myScores -> {
            Double sum = 0d;
            for (Double nextScore : myScores) {
                sum += nextScore;
            }            return sum / myScores.size();       };

        ToDoubleFunction<List<Double>> highestScore = myScores -> {
            Double highest = 0d;
            for (double nextScore : myScores) {
                highest = Math.max(highest, nextScore);
            }           return highest;        };

      ToDoubleFunction<List<Double>> lowestScore = myScores -> {
            double lowest = myScores.get(0);
            for (double nextScore : myScores) {
                lowest = Math.min(lowest, nextScore);
            }            return lowest;        };

        ExamManager examManager = new ExamManager();
        System.out.println("The average score is " + examManager.customCalculation(average));
        System.out.println("The highest score is " + examManager.customCalculation(highestScore));
        System.out.println("The lowest score is " + examManager.customCalculation(lowestScore));
        
        System.out.println("The first score is " + examManager.customCalculation(myScores -> myScores.get(0)));
        
        examManager.printScores();
        System.out.println("---");
        examManager.printSelectedScores(score -> score>55);
    }
}

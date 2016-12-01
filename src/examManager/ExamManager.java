package examManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class ExamManager {
    
    private List<Double> myScores;
    
    public ExamManager() {
        myScores = new ArrayList<Double>();
        myScores.add(78.3);
        myScores.add(69.2);
        myScores.add(44.7);
        myScores.add(61.6);
        myScores.add(80.2);
        myScores.add(66.9);
        myScores.add(54.1);
    }
    
    public Double customCalculation(ToDoubleFunction<List<Double>>  calculator) {
        return calculator.applyAsDouble(myScores) ;
    }
    
    public void printScores() {
       myScores.forEach(score -> System.out.println(score));
    }
    
    public void printSelectedScores(Predicate<Double> testCritetia) {
        myScores.forEach(score -> {
            if(testCritetia.test(score))
                System.out.println(score);
            });
    }
}

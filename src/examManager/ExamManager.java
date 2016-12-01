package examManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        
        Comparator<Double> descendingComparator = (o1, o2) -> {
             int result = 0;
             if(o1 < o2) result = 1;
             if(o1 > o2) result = -1;
             return result;        };
        Collections.sort(myScores, descendingComparator);
       myScores.forEach(score -> System.out.println(score));
    }
    
    public void printSelectedScores(Predicate<Double> testCritetia) {
        myScores.forEach(score -> {
            if(testCritetia.test(score))
                System.out.println(score);
            });
    }
}

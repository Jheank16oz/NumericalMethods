import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.ArrayList;

public class FixedPoint {

    public ArrayList<Double> getResults() {
        return results;
    }

    private ArrayList<Double> results = new ArrayList<Double>();
    private final String equation;
    private double x0;
    private final double n;

    public FixedPoint(String equation, double x0, double n) {
        this.equation = equation;
        this.x0 = x0;
        this.n = n;
    }

    public void execute(){

        for (int i = 0; i < n; i++) {
            String eq = EquationResolver.resolve(equation, String.valueOf(x0));
            x0 = calculate(eq);
            results.add(x0);
        }
    }



    private static double calculate(String form) {

        SpelExpressionParser parser = new SpelExpressionParser();
        double value = parser.parseExpression(form).getValue(Double.class);
        return value;
    }
}

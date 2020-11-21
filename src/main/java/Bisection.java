import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.ArrayList;

public class Bisection {


    String equation = "";
    double xa = 0;
    double xb = 0;
    double xc = 0;
    private ArrayList<Double> result = new ArrayList<Double>();

    public ArrayList<Double> getResult() {
        return result;
    }

    double a;
    double b;
    double c;
    int n;

    public Bisection(String equation, double xa, double xb, int n) {
        this.equation = equation;
        this.xa = xa;
        this.xb = xb;
        this.n = n;
    }

    public void execute() {
        xc = (xa + xb) / 2;

        String eq1 = EquationResolver.resolve(equation, String.valueOf(xa));
        String eq2 = EquationResolver.resolve(equation, String.valueOf(xb));
        String eqc = EquationResolver.resolve(equation, String.valueOf(xc));


        a = calculate(eq1);
        b = calculate(eq2);
        c = calculate(eqc);
        result.add(xc);

        for (int i = 0; i < n; i++) {
            iterate();
        }

        System.out.println(xc);


    }

    private void iterate() {

        boolean a1 = (a * c) > 0;
        boolean b2 = (b * c) > 0;

        if (a1) {
            xa = xc;
        } else if (b2) {
            xb = xc;
        }

        xc = (xa + xb) / 2;
        String eqi = EquationResolver.resolve(equation, String.valueOf(xc));
        c = calculate(eqi);
        result.add(xc);
    }

    private static double calculate(String form) {

        SpelExpressionParser parser = new SpelExpressionParser();
        double value = parser.parseExpression(form).getValue(Double.class);
        return value;
    }

}

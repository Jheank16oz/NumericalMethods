import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.ArrayList;
import java.util.HashMap;

public class Diferentiation {


    private String equation;
    private double x0;

    public double getM1() {
        return m1;
    }

    public double getM2() {
        return m2;
    }

    public double getM3() {
        return m3;
    }

    private double deltaX;
    private double h;
    private double m1;
    private double m2;
    private double m3;

    public Diferentiation(String equation, double x0, double h) {
        this.equation = equation;
        this.x0 = x0;
        this.h = h;

        deltaX = h / 2;
    }

    public Diferentiation(String equation, Double x0, Double deltaX, boolean deltax) {
        this.equation = equation;
        this.x0 = x0;
        this.deltaX = deltaX;

        h = deltaX * 2;
    }

    public void execute() {
        double fx0 = calculate(x0);
        double fx0dx = calculate(x0 + deltaX);
        double fx0dxMinus = calculate(x0 - deltaX);

        m1 = (fx0 - fx0dxMinus) / deltaX;
        m2 = (fx0dx - fx0) / deltaX;
        m3 = (fx0dx - fx0dxMinus) / h;
    }

    private double calculate(double valuex) {
        String eq = EquationResolver.resolve(equation, String.valueOf(valuex));
        SpelExpressionParser parser = new SpelExpressionParser();
        return parser.parseExpression(eq).getValue(Double.class);
    }
}

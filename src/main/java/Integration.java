import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Integration {


    private double n;
    private double a;
    private double b;
    private double h;
    private String equation;

    public double getIntegral() {
        return integral;
    }

    private double integral = 0;
    public Integration(double n, double a, double b, String equation) {
        this.n = n;
        this.a = a;
        this.b = b;
        this.equation = equation;
    }

    public void execute() {
        h = (b - a) / (n - 1);

        Double[] x = new Double[(int) n];
        int i = 0;
        x[i] = a;
        i++;
        for (; i < n; i++) {
            x[i] = x[i - 1] + h;
        }


        for (int j = 0; j < x.length; j++) {
            String eq = EquationResolver.resolve(equation, String.valueOf(x[j]));
            double xeq  = j != 0 && j != x.length - 1 ? 2 * calculate(eq) : calculate(eq);
            x[j] = xeq;
            integral += xeq;
        }

        integral = (h / 2) * integral;
    }

    private static double calculate(String form) {
        SpelExpressionParser parser = new SpelExpressionParser();
        return parser.parseExpression(form).getValue(Double.class);
    }
}

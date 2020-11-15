import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Main {
    public static void main(String[] args) {
        /*Presentation mPresentation = new Presentation();
        mPresentation.display();*/


        //fixedPoint();

        Integration mIntegration = new Integration(14, 0, 1, "4/(1+x^2)");
        mIntegration.execute();
        System.out.println(mIntegration.getIntegral());

        //calculate(EquationResolver.resolve("e^52",""));
    }


    private static double calculate(String form){

        SpelExpressionParser parser = new SpelExpressionParser();
        double value = parser.parseExpression(form).getValue(Double.class);
        System.out.println(value);
        return value;
    }

    private static void fixedPoint() {
        FixedPoint mFixedPoint = new FixedPoint("20/(x^2+2x+10)",1.5,4);
        mFixedPoint.execute();
        System.out.println(mFixedPoint.getResults());
    }

    private static void bisection() {

        Bisection mBisection = new Bisection("x^3+2x^2+10x-20", 1, 2, 4);
        mBisection.execute();
        System.out.println(mBisection.getResult());
    }

    private static void bisection2() {

        Bisection mBisection = new Bisection("x^2-x-2", 1, 4, 5);
        mBisection.execute();
        System.out.println(mBisection.getResult());
    }

    private static void newton() {
        String form =  "x^3+2x^2+10x-20";
        String form2 =  "3x^2+4x+10";
        NewtonRapshon r = new NewtonRapshon(1.5, 8, form,form2);
        r.execute();
        System.out.println(r.getResults());
    }
}

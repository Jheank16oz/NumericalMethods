import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.ArrayList;

public class NewtonRapshon {


    private ArrayList<Double> results = new ArrayList<Double>();

    public NewtonRapshon(double x0, double n, String form, String dForm) {
        this.x0 = x0;
        this.n = n;
        this.form = form;
        this.dForm = dForm;
    }

    private double x0;
    private double n;
    private String form;
    private String dForm;


    public void execute() {
        results.clear();
        double currentValue = x0;
        for (int i = 0; i < n; i++) {
            String formfinal = "x - ((" + form +")/(" + dForm + "))";
            formfinal = EquationResolver.resolve(formfinal, String.valueOf(currentValue));
            currentValue = raphson(formfinal);
            results.add(currentValue);
        }
    }

    public ArrayList<Double> getResults(){
        return results;
    }

    private double raphson(String form){

        SpelExpressionParser parser = new SpelExpressionParser();
        double value = parser.parseExpression(form).getValue(Double.class);
        return value;
    }

}

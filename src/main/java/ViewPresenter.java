import java.util.ArrayList;

public class ViewPresenter implements Contract.Presenter {


    private Contract.View view;

    public ViewPresenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void calculateRapshon(String txt1, String txt2, Double x0, Double n) {
        NewtonRapshon r = new NewtonRapshon(x0, n, txt1,txt2);
        r.execute();

        view.displayRapshonResult(arraytoString(r.getResults()));
    }

    private String arraytoString(ArrayList<Double> results) {
        String result = results.toString().replace(',','\n');
        result = result.replace(']',' ');
        result = result.replace('[',' ');
        return result.trim();
    }

    @Override
    public void calculateBisection(String txt1, Double xa, Double xb, int n) {
        Bisection mBisection = new Bisection(txt1, xa, xb, n);
        mBisection.execute();
        view.displayBisectionresult(arraytoString(mBisection.getResult()));
    }

    @Override
    public void calculateFixedPoint(String txt1, Double x0, int n) {
        FixedPoint mFixedPoint = new FixedPoint(txt1,x0,n);
        mFixedPoint.execute();
        view.displayFixedPointResult(arraytoString(mFixedPoint.getResults()));
    }

    @Override
    public void calculateDiferentiation(String txt1, Double x0, Double deltax, Double h) {

        Diferentiation mDiferentiation = new Diferentiation(txt1, x0, deltax, true);
        mDiferentiation.execute();
        String value = String.format("m1 = %s\nm2 = %s\nm3 = %s",mDiferentiation.getM1(),mDiferentiation.getM2(),mDiferentiation.getM3());
        view.displayDiferentiationResult(value);
    }

    @Override
    public void calculateIntegration(String txt1, Double a, Double b, int n) {
        Integration mIntegration = new Integration(n,a,b,txt1);
        mIntegration.execute();
        view.displayIntegrationResult(String.valueOf(mIntegration.getIntegral()));
    }

    @Override
    public void calculateLagrange(ArrayList<Coordinate> coordinates, Double x) {
        DirectPolynomialLagrange mDirectPolynomialLagrange = new DirectPolynomialLagrange(coordinates, x);
        mDirectPolynomialLagrange.execute();
        view.displayLagrange(String.valueOf(mDirectPolynomialLagrange.getResult()));
    }

}

import java.util.ArrayList;

public class DirectPolynomialLagrange {


    ArrayList<Coordinate> map;
     double[] mapresults;
     double sum = 0;
    private double x;


    public DirectPolynomialLagrange(ArrayList<Coordinate> map, double x) {
        this.map = map;
        this.x = x;

        mapresults = new double[map.size()];
    }

    public void execute() {
        for (int i = 0; i < map.size(); i++) {

            double up = 1, down = 1;
            for (int j = 0; j < map.size(); j++) {
                if (i != j) {
                    up *= (x - map.get(j).getX());
                    down *= (map.get(i).getX() - map.get(j).getX());
                }
            }

            double indexResult = (map.get(i).getY() * (up/ down));
            mapresults[i] = indexResult;
            sum += indexResult;

        }
    }

    public double  getResult(){
        return sum;
    }

}

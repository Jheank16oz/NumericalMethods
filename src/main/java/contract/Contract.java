package contract;

public interface Contract {

    interface View{

        void displayRapshonResult(String result);

        void displayBisectionresult(String result);

        void displayFixedPointResult(String result);

        void displayDiferentiationResult(String value);

        void displayIntegrationResult(String valueOf);
    }

    interface Presenter{

        void calculateRapshon(String txt1, String txt2, Double x0, Double n);

        void calculateBisection(String txt1, Double xa, Double xb, int n);

        void calculateFixedPoint(String txt1, Double x0, int n);

        void calculateDiferentiation(String txt1, Double x0, Double deltax, Double h);

        void calculateIntegration(String txt1, Double a, Double b, int n);
    }
}

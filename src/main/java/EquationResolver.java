import java.util.ArrayList;

public class EquationResolver {

    //String form =  "x^3+2x^2+10x-20";

    static double euler = 2.718281828;

    public static String resolve(String forms, String xValue) {
        StringBuilder builder = new StringBuilder(forms);

        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == 'x'){
                if (i > 0){
                    char possibleNumber = builder.charAt(i-1);
                    builder.deleteCharAt(i);
                    if (possibleNumber >= 48 && possibleNumber <= 57){
                        builder.insert(i,"*"+xValue);
                        i += ("*" +xValue).length()-1;
                    }else {
                        builder.insert(i, xValue);
                        i += xValue.length()-1;
                    }
                }else {
                    builder.deleteCharAt(i);
                    builder.insert(0, xValue);
                    i += xValue.length()-1;
                }
            }

            if (builder.charAt(i) == 'e'){
                builder.deleteCharAt(i);
                builder.insert(i, euler);
            }


        }

        return builder.toString();
    }
}

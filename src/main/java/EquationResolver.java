import java.util.ArrayList;

public class EquationResolver {

    //String form =  "x^3+2x^2+10x-20";

    static double euler = 2.718281828;

    public static String resolve(String forms, String xValue) {
        StringBuilder builder = new StringBuilder(forms);

        for (int i = 0; i < builder.length(); i++) {
            // replace incognit
            if (builder.charAt(i) == 'x'){
                if (i > 0){
                    char possibleNumber = builder.charAt(i-1);
                    builder.deleteCharAt(i);
                    if (isNumber(possibleNumber)){
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

            // single number problem .0
                if (isNumber(builder.charAt(i))){
                    if (i == 0 && i < builder.length()-1){
                        if (!isDigit(builder.charAt(i+1))){
                            builder.insert(i+1,".0");
                            i+=2;
                        }
                    }else if (!isDigit(builder.charAt(i-1)) && i == builder.length()-1){
                        builder.insert(i+1, ".0");
                        i+=2;
                    }else if (!isDigit(builder.charAt(i-1)) && !isDigit(builder.charAt(i+1))){
                        builder.insert(i+1, ".0");
                        i+=2;
                    }
                }



            //euler problem
            if (builder.charAt(i) == 'e'){
                builder.deleteCharAt(i);
                builder.insert(i, euler);
            }




        }

        return builder.toString();
    }

    private static boolean isNumber(char charAt) {
        return charAt >= 48 && charAt <= 57;
    }

    private static boolean isDigit(char charAt){
        return isNumber(charAt) || charAt == '.';
    }
}

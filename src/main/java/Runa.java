import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class Runa {


    /** Set of standard region names for UIDefaults Keys */
    private static final String[] COMPONENT_KEYS = new String[]{"ArrowButton", "Button",
            "CheckBox", "CheckBoxMenuItem", "ColorChooser", "ComboBox",
            "DesktopPane", "DesktopIcon", "EditorPane", "FileChooser",
            "FormattedTextField", "InternalFrame",
            "InternalFrameTitlePane", "Label", "List", "Menu",
            "MenuBar", "MenuItem", "OptionPane", "Panel",
            "PasswordField", "PopupMenu", "PopupMenuSeparator",
            "ProgressBar", "RadioButton", "RadioButtonMenuItem",
            "RootPane", "ScrollBar", "ScrollBarTrack", "ScrollBarThumb",
            "ScrollPane", "Separator", "Slider", "SliderTrack",
            "SliderThumb", "Spinner", "SplitPane", "TabbedPane",
            "Table", "TableHeader", "TextArea", "TextField", "TextPane",
            "ToggleButton", "ToolBar", "ToolTip", "Tree", "Viewport"};

    public static void main(String[] args) {
        try {

            UIManager.put("text", Color.decode("#001D29"));
            NimbusLookAndFeel mNimbus = new NimbusLookAndFeel();

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Presentation mPresentation = new Presentation();
        mPresentation.display();

        //diferentiation();

        /*ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
        coordinates.add(new Coordinate(-1,1));
        coordinates.add(new Coordinate(0,2));
        coordinates.add(new Coordinate(1,-1));
        coordinates.add(new Coordinate(2,2));
        DirectPolynomialLagrange directPolynomialLagrange = new DirectPolynomialLagrange(coordinates, 13);
        directPolynomialLagrange.execute();
        System.out.println(directPolynomialLagrange.getResult());*/
    }


    private static void diferentiation() {
        Diferentiation mDiferentiation = new Diferentiation("x^(1/2)", 9.0, 0.05, true);
        mDiferentiation.execute();
        System.out.println(mDiferentiation.getM1() +" "+ mDiferentiation.getM2() +" "+ mDiferentiation.getM3());
    }


    public  static void integration(){
        Integration mIntegration = new Integration(14, 0, 1, "4/(1+x^2)");
        mIntegration.execute();
        System.out.println(mIntegration.getIntegral());
    }

    private static double calcule(String form){

        SpelExpressionParser parser = new SpelExpressionParser();
        double value = parser.parseExpression(form).getValue(Double.class);
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

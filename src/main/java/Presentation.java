import contract.Contract;
import listener.SimpleMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

public class Presentation implements MouseListener, Contract.View {
    private final ViewPresenter mPresenter;
    private JPanel panel1;
    private JButton raicesNewtonRapshonButton;
    private JButton raicesBisectionButton;
    private JButton raicesPuntoFijoButton;
    private JButton derivacionDiferenciaciónButton;
    private JButton integraciónButton;
    private JButton polinomioDirectoButton;
    //newton Rapshon
    private JTextField textField1;
    private JTextField textField2;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JButton calcularButton;
    private JTextArea textArea1;

    // Bisection
    private JTextField textField3;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private JButton calcularButton1;
    private JTextArea textArea2;

    //Fixed point
    private JTextField textField4;
    private JSpinner spinner6;
    private JSpinner spinner7;
    private JTextArea textArea3;
    private JButton calcularButton2;

    private JPanel fixedPont;
    private JPanel bisection;
    private JPanel main;
    private JPanel newtonRapshon;
    private JPanel diferentiation;

    //diferentiation
    private JTextField textField5;
    private JSpinner spinner8;
    private JSpinner spinner9;
    private JSpinner spinner10;
    private JButton calcularButton4;
    private JTextArea textArea4;

    //integration
    private JTextField textField6;
    private JSpinner spinner11;
    private JSpinner spinner12;
    private JSpinner spinner13;
    private JTextArea textArea5;
    private JButton calcularButton3;

    JFrame mainJFrame;

    public Presentation() {
        this.mainJFrame = new JFrame("App");
        mPresenter = new ViewPresenter(this);
    }

    public void display() {
        mainJFrame.setContentPane(panel1);
        mainJFrame.setMinimumSize(new Dimension(800, 800));
        mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainJFrame.pack();
        mainJFrame.setVisible(true);

        raicesNewtonRapshonButton.addMouseListener(this);
        raicesBisectionButton.addMouseListener(this);
        raicesPuntoFijoButton.addMouseListener(this);
        derivacionDiferenciaciónButton.addMouseListener(this);
        integraciónButton.addMouseListener(this);
        polinomioDirectoButton.addMouseListener(this);

        allowSpinnerDoubleValue(spinner1);
        allowSpinnerDoubleValue(spinner3);
        allowSpinnerDoubleValue(spinner4);
        allowSpinnerDoubleValue(spinner6);

        allowSpinnerDoubleValue(spinner8);
        allowSpinnerDoubleValue(spinner9);
        allowSpinnerDoubleValue(spinner10);

        allowSpinnerDoubleValue(spinner11);
        allowSpinnerDoubleValue(spinner12);

        calcularButton.addMouseListener(new SimpleMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String txt1 = textField1.getText();
                String txt2 = textField2.getText();
                Double x0 = (Double) spinner1.getValue();
                Double n = Double.parseDouble(spinner2.getValue().toString());
                mPresenter.calculateRapshon(txt1, txt2, x0, n);
            }
        });

        calcularButton1.addMouseListener(new SimpleMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String txt1 = textField3.getText();
                Double xa = (Double) spinner3.getValue();
                Double xb = (Double) spinner4.getValue();
                int n = (int) spinner5.getValue();
                mPresenter.calculateBisection(txt1, xa, xb, n);
            }
        });

        calcularButton2.addMouseListener(new SimpleMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String txt1 = textField4.getText();
                Double x0 = (Double) spinner6.getValue();
                int n = (int) spinner7.getValue();
                mPresenter.calculateFixedPoint(txt1, x0, n);
            }
        });

        calcularButton4.addMouseListener(new SimpleMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String txt1 = textField5.getText();
                Double x0 = (Double) spinner8.getValue();
                Double deltax = (Double) spinner9.getValue();
                Double h = (Double) spinner10.getValue();

                mPresenter.calculateDiferentiation(txt1, x0, deltax, h);
            }
        });

        calcularButton3.addMouseListener(new SimpleMouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String txt1 = textField6.getText();
                Double a = (Double) spinner11.getValue();
                Double b = (Double) spinner12.getValue();
                int n = (int) spinner13.getValue();

                mPresenter.calculateIntegration(txt1,a,b,n);
            }
        });

        spinner9.addChangeListener(e -> {
            Double dx = ((Double)(((JSpinner) e.getSource()).getValue()));
            spinner10.setValue(dx * 2);

        });

        spinner10.addChangeListener(e -> {
            Double h = ((Double)(((JSpinner) e.getSource()).getValue()));
            spinner9.setValue(h / 2);

        });

    }

    private void allowSpinnerDoubleValue(JSpinner spinner) {
        double min = 0.0;
        double value = 0.0;
        double max = 999.0;
        double stepSize = 0.1;
        SpinnerNumberModel model = new SpinnerNumberModel(value, min, max, stepSize);
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) spinner.getEditor();
        DecimalFormat format = editor.getFormat();
        spinner.setModel(model);
        format.setMinimumFractionDigits(2);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        String txt = ((JButton) e.getSource()).getText();

        switch (txt) {
            case "Raices Newton Rapshon":
                System.out.println("1");
                break;
            case "Raices Bisection":
                System.out.println("2");
                break;
            case "Raices Punto Fijo":
                System.out.println("3");
                break;
            case "Derivacion (Diferenciación)":
                System.out.println("4");
                break;
            case "Integración":
                System.out.println("5");
                break;
            case "Polinomio Directo":
                System.out.println("6");
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void displayRapshonResult(String result) {
        textArea1.setText(result);
    }

    @Override
    public void displayBisectionresult(String result) {
        textArea2.setText(result);
    }

    @Override
    public void displayFixedPointResult(String result) {
        textArea3.setText(result);
    }

    @Override
    public void displayDiferentiationResult(String result) {
        textArea4.setText(result);
    }

    @Override
    public void displayIntegrationResult(String result) {
        textArea5.setText(result);
    }
}

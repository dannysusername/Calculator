import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator extends JFrame{

    private JFrame frame;
    private JPanel keypadJPanel;
    private JTextField calculationField;
    private JTextArea resultTextArea;
    

    private JButton num1;
    private JButton num2;
    private JButton num3;
    private JButton num4;
    private JButton num5;
    private JButton num6;
    private JButton num7;
    private JButton num8;
    private JButton num9;
    private JButton num0;

    private JButton percent;

    private JButton subtract;
    private JButton addition;
    private JButton multiply;
    private JButton divide;
    private JButton clear;
    private JButton equals;
   
    private JButton decimalPoint;
    
    public Calculator(){
        this.frame = new JFrame();
        this.frame.setSize(300, 400);
        this.frame.setLayout(new BoxLayout(this.frame.getContentPane(), BoxLayout.Y_AXIS));
        this.frame.setMinimumSize(new Dimension(300, 400));

        JLabel CalculaterLabel = new JLabel("Calculator");

        JTextField calculationField = new JTextField();
        this.calculationField = calculationField;
        calculationField.setMinimumSize(new Dimension(frame.getContentPane().getWidth(), 50));
        calculationField.setEditable(false);
        calculationField.setBackground(Color.LIGHT_GRAY);
        calculationField.setFocusable(false);
        calculationField.setHorizontalAlignment(JTextField.RIGHT);
        
        JTextArea resultTextArea = new JTextArea(1, 1);
        this.resultTextArea = resultTextArea;
        resultTextArea.setLineWrap(true);
        resultTextArea.setMinimumSize(new Dimension(frame.getContentPane().getWidth(), 150));

        this.keypadJPanel = new JPanel();
        keypadJPanel.setLayout(new GridBagLayout());
        keypadJPanel.setPreferredSize(new Dimension(frame.getContentPane().getWidth(), 200));
        
        addAllButtons(resultTextArea);

        frame.add(CalculaterLabel);
        frame.add(calculationField);
        frame.add(resultTextArea);
        frame.add(keypadJPanel);
        
        frame.setVisible(true);

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void addAllButtons(JTextArea result) {

        GridBagConstraints keyPadGridConstraints = new GridBagConstraints();
        keyPadGridConstraints.fill = GridBagConstraints.BOTH;
        keyPadGridConstraints.weightx = 1.0;
        keyPadGridConstraints.weighty = 1.0; 

        this.num1 = new JButton("1");
        keyPadGridConstraints.gridx = 0;
        keyPadGridConstraints.gridy = 0;
        num1.addActionListener(e -> {
            result.setText("1");
            calculationField.setText(calculationField.getText() + "1");
        });
        keypadJPanel.add(num1, keyPadGridConstraints);

        this.num2 = new JButton("2");
        keyPadGridConstraints.gridx = 1;
        num2.addActionListener(e -> {
            result.setText("2");
            calculationField.setText(calculationField.getText() + "2");
        });
        keypadJPanel.add(num2, keyPadGridConstraints);

        this.num3 = new JButton("3");
        keyPadGridConstraints.gridx = 2;
        num3.addActionListener(e -> {
            result.setText("3");
            calculationField.setText(calculationField.getText() + "3");
        });
        keypadJPanel.add(num3, keyPadGridConstraints);

        this.num4 = new JButton("4");
        keyPadGridConstraints.gridx = 0;  // Column 0
        keyPadGridConstraints.gridy = 1;
        num4.addActionListener(e -> {
            result.setText("4");
            calculationField.setText(calculationField.getText() + "4");
        });
        keypadJPanel.add(num4, keyPadGridConstraints);

        this.num5 = new JButton("5");
        keyPadGridConstraints.gridx = 1;
        num5.addActionListener(e -> {
            result.setText("5");
            calculationField.setText(calculationField.getText() + "5");
        });
        keypadJPanel.add(num5, keyPadGridConstraints);

        this.num6 = new JButton("6");
        keyPadGridConstraints.gridx = 2;
        num6.addActionListener(e -> {
            result.setText("6");
            calculationField.setText(calculationField.getText() + "6");
        });
        keypadJPanel.add(num6, keyPadGridConstraints);

        this.num7 = new JButton("7");
        keyPadGridConstraints.gridx = 0;
        keyPadGridConstraints.gridy = 2;
        num7.addActionListener(e -> {
            result.setText("7");
            calculationField.setText(calculationField.getText() + "7");
        });
        keypadJPanel.add(num7, keyPadGridConstraints);

        this.num8 = new JButton("8");
        keyPadGridConstraints.gridx = 1;
        num8.addActionListener(e -> {
            result.setText("8");
            calculationField.setText(calculationField.getText() + "8");
        });
        keypadJPanel.add(num8, keyPadGridConstraints);

        this.num9 = new JButton("9");
        keyPadGridConstraints.gridx = 2;
        num9.addActionListener(e -> {
            result.setText("9");
            calculationField.setText(calculationField.getText() + "9");
        });
        keypadJPanel.add(num9, keyPadGridConstraints);

        this.num0 = new JButton("0");
        keyPadGridConstraints.gridx = 1;
        keyPadGridConstraints.gridy = 3;
        num0.addActionListener(e -> {
            result.setText("0");
            calculationField.setText(calculationField.getText() + "0");
        });
        keypadJPanel.add(num0, keyPadGridConstraints);

        this.divide = new JButton("/");
        keyPadGridConstraints.gridx = 3;
        keyPadGridConstraints.gridy = 0;
        divide.addActionListener(e -> 
        calculationField.setText(calculationField.getText() + " / "));
        keypadJPanel.add(divide, keyPadGridConstraints);

        this.multiply = new JButton("X");
        keyPadGridConstraints.gridy = 1;
        multiply.addActionListener(e -> calculationField.setText(calculationField.getText() + " X "));
        keypadJPanel.add(multiply, keyPadGridConstraints);

        this.subtract = new JButton("-");
        keyPadGridConstraints.gridy = 2;
        subtract.addActionListener(e -> calculationField.setText(calculationField.getText() + " - "));
        keypadJPanel.add(subtract, keyPadGridConstraints);

        this.addition = new JButton("+");
        keyPadGridConstraints.gridy = 3;
        addition.addActionListener(e -> calculationField.setText(calculationField.getText() + " + "));
        keypadJPanel.add(addition, keyPadGridConstraints);

        this.equals = new JButton("=");
        keyPadGridConstraints.gridx = 0;
        keyPadGridConstraints.gridy = 4;
        keyPadGridConstraints.gridwidth = GridBagConstraints.RELATIVE;
        equals.addActionListener(e -> calculationField.setText(calculationField.getText() + " = "));
        keypadJPanel.add(equals, keyPadGridConstraints); 

    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();

    }





}

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;

import java.awt.event.*;
import java.awt.*;

public class Calculator2 extends JFrame{

    private JFrame frame;
    private JPanel keypadJPanel;
    private JTextField calculationField;
    private JTextArea resultTextArea;

    private GridBagConstraints keyPadGridConstraints;

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
    
    private JButton equals;

    private boolean isNewOperation = true;

    private JButton clear;
    private JButton clearEntry;
    
    private String savedResultStr = "";
    private double savedResult = 0;

    private String firstOperandStr = "";
    private double firstOperand = 0;

    private String secondOperandStr = "";
    private double secondOperand = 0;

    private String thirdOperandStr = "";
    private double thirdOperand = 0;

    private String currentOperator = "";
    private String currentToken = "";
   
    private JButton decimalPoint;

    
    public Calculator2(){
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
        resultTextArea.setText("0");
        resultTextArea.setFocusable(false);

        resultTextArea.setLineWrap(true);
        resultTextArea.setMinimumSize(new Dimension(frame.getContentPane().getWidth(), 150));

        this.keypadJPanel = new JPanel();
        keypadJPanel.setLayout(new GridBagLayout());
        keypadJPanel.setPreferredSize(new Dimension(frame.getContentPane().getWidth(), 200));
        
        addAllButtons();

        frame.add(CalculaterLabel);
        frame.add(calculationField);
        frame.add(resultTextArea);
        frame.add(keypadJPanel);
        
        frame.setVisible(true);

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void addAllButtons() {
        //Change name to something that explains that these are the buttons that are pressed in the calc inorder to perform calculations

        StringBuilder currentOperand = new StringBuilder();
        String firstOperand;
        String operator;

        GridBagConstraints keyPadGridConstraints = new GridBagConstraints();
        keyPadGridConstraints.fill = GridBagConstraints.BOTH;
        keyPadGridConstraints.weightx = 1.0;
        keyPadGridConstraints.weighty = 1.0; 
        this.keyPadGridConstraints = keyPadGridConstraints;

        addNumberButton(1, 0, 0);
        addNumberButton(2, 1, 0);
        addNumberButton(3, 2, 0);
        addNumberButton(4, 0, 1);
        addNumberButton(5, 1, 1);
        addNumberButton(6, 2, 1);
        addNumberButton(7, 0, 2);
        addNumberButton(8, 1, 2);
        addNumberButton(9, 2, 2);
        addNumberButton(0, 1, 3);

        addOperators("/", 3, 0);
        addOperators("X", 3, 1);
        addOperators("-", 3, 2);
        addOperators("+", 3, 3);

        addEqualsButton();
        addResetCalculations("CE", 3, 4);

        //if operator was already chosen and the same operator is chosen again dont add again to textField
            //if diff operator was chosen change previous operator to current operator.

            //[1, 2, 3]
            //[+]
            //
            /*
             * Data structures
             * List
             * Map
             * Heap
             * Queue
             * Stack
             */        

    }

    public void addNumberButton(int number, int gridx, int gridy) {
        
        JButton button = new JButton(String.valueOf(number));
        keyPadGridConstraints.gridx = gridx;
        keyPadGridConstraints.gridy = gridy;
        
        button.addActionListener(e -> {
           numbersAction(String.valueOf(number));
        });
        keypadJPanel.add(button, keyPadGridConstraints);

        switch (number) {
            case 1: num1 = button; break;
            case 2: num2 = button; break;
            case 3: num3 = button; break;
            case 4: num4 = button; break;
            case 5: num5 = button; break;
            case 6: num6 = button; break;
            case 7: num7 = button; break;
            case 8: num8 = button; break;
            case 9: num9 = button; break;
            case 0: num0 = button; break;    

        }

    }

    public void addOperators(String operator, int gridx, int gridy) {
        JButton operatorButton = new JButton(operator);
        keyPadGridConstraints.gridx = gridx;
        keyPadGridConstraints.gridy = gridy;
        operatorButton.addActionListener(e -> {              
            operatorAction(operator);

        });
        keypadJPanel.add(operatorButton, keyPadGridConstraints);

        switch(operator) {
            case "/": divide = operatorButton; break;
            case "X": multiply = operatorButton; break;
            case "-": subtract = operatorButton; break;
            case "+": addition = operatorButton; break;
            
        }
    }

    public void addEqualsButton() {
        this.equals = new JButton("=");
        keyPadGridConstraints.gridx = 0;
        keyPadGridConstraints.gridy = 4;
        keyPadGridConstraints.gridwidth = GridBagConstraints.RELATIVE;
        equals.addActionListener(e -> {
           equalsAction();
        });
        keypadJPanel.add(equals, keyPadGridConstraints); 

    }

    public void addResetCalculations(String text, int gridx, int gridy) {
        
        this.clearEntry = new JButton(text);
        keyPadGridConstraints.gridx = gridx;
        keyPadGridConstraints.gridy = gridy;
        clearEntry.addActionListener(e -> {
            clearActions();
        });
        keypadJPanel.add(clearEntry, keyPadGridConstraints);


    }


    public void numbersAction(String number) {
        
        if(currentToken.equals("=")) {
            clearActions();
            firstOperandStr = firstOperandStr.concat(number);
            firstOperand = Double.valueOf(firstOperandStr);
            resultTextArea.setText(firstOperandStr);

        } else if(isNewOperation) {
            firstOperandStr = firstOperandStr.concat(number);
            firstOperand = Double.valueOf(firstOperandStr);
            resultTextArea.setText(firstOperandStr);

        } else {
            secondOperandStr = secondOperandStr.concat(number);
            secondOperand = Double.valueOf(secondOperandStr);
            resultTextArea.setText(secondOperandStr);

        }

        calculationField.setText(calculationField.getText() + number);
        
        currentToken = number;
        
        //System.out.println("Current Operand: " + currentOperand + " Double value: " + Double.parseDouble(currentOperand));
        System.out.println("First operand: " + firstOperand);
        System.out.println("Second operand: " + secondOperand);
        System.out.println("Third operand: " + thirdOperand);
        System.out.println("Current operator: " + currentOperator);
        System.out.println("Saved result: " + savedResult);
        System.out.println("Current Token: " + currentToken);
        operation();
        System.out.println("--------------");

    }

    public void operation() {
        if(isNewOperation == false) {
            System.out.println("Old operation");
        } else {
            System.out.println("New operation");
        }
    }

    public void operatorAction(String operator) {
        
        if(currentToken.equals(operator)) {
            return;
        } 

        if(!isNewOperation) {
            savedResult = calculate(firstOperand, secondOperand, currentOperator);
            firstOperand = savedResult;
            resultTextArea.setText(String.valueOf(savedResult));

        } 
        
        secondOperandStr = "";
        currentOperator = operator;
        isNewOperation = false;
        calculationField.setText(calculationField.getText() + " " + operator + " ");

        currentToken = operator;

        System.out.println("First operand: " + firstOperand);
        System.out.println("Second operand: " + secondOperand);
        System.out.println("Third operand: " + thirdOperand);
        System.out.println("Current operator: " + currentOperator);
        System.out.println("Current Token: " + currentToken);
        System.out.println("Saved result: " + savedResult);
        operation();
        System.out.println("--------------");

    }

    public void equalsAction() {

        if(currentToken.equals("=")) {
            System.out.println("...");
            firstOperand = savedResult;
            savedResult = calculate(savedResult, thirdOperand, currentOperator);

        } else {
            calculationField.setText(calculationField.getText() + " = ");
        }

        
        savedResult = calculate(firstOperand, secondOperand, currentOperator);
        savedResultStr = String.valueOf(savedResult);
        thirdOperand = secondOperand;

        resultTextArea.setText(savedResultStr);     
        currentToken = "=";
        
        System.out.println("First operand: " + firstOperand);
        System.out.println("Second operand: " + secondOperand);
        System.out.println("Third operand: " + thirdOperand);
        System.out.println("Current operator: " + currentOperator);
        System.out.println("Current Token: " + currentToken);
        System.out.println("Saved result: " + savedResult);
        operation();
        System.out.println("--------------");
    
    }

    public void clearActions() {
        firstOperand = 0;
        secondOperand = 0;
        thirdOperand = 0;
        savedResult = 0;
        
        savedResultStr = "";
        firstOperandStr = "";
        secondOperandStr = "";
        thirdOperandStr = "";
        currentToken = "";
        currentOperator = "";
        calculationField.setText("");
        resultTextArea.setText("0");
        isNewOperation = true;

        currentToken = "";

        System.out.println("First operand: " + firstOperand);
        System.out.println("Second operand: " + secondOperand);
        System.out.println("Third operand: " + thirdOperand);
        System.out.println("Current operator: " + currentOperator);
        System.out.println("Saved result: " + savedResult);
        System.out.println("Current Token: " + currentToken);
        operation();
        System.out.println("--------------");

    }

    public double calculate(double firstOperand, double secondValue, String operator) {
        switch(operator) {
            case "+": return firstOperand + secondValue;
            case "-": return firstOperand - secondValue;
            case "X": return firstOperand * secondValue;
            case "/": 
                if(secondValue != 0) return firstOperand/secondValue;
                else throw new ArithmeticException("Division by zero");
            default: return 0;
                
        }

    }


    public static void main(String[] args) {
        Calculator2 calc = new Calculator2();

    }





}

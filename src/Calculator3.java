import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;

import java.awt.event.*;
import java.awt.*;

public class Calculator3 extends JFrame{

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
    
    private String savedResultStr = "0";
    private double savedResult = 0;

    private String currentOperandStr = "";
    private double currentOperand = 0;

    private String firstOperandStr = "";
    private double firstOperand = 0;

    private String secondOperandStr = "";
    private double secondOperand = 0;

    private String thirdOperandStr = "";
    private double thirdOperand = 0;

    private String currentOperator = "+";
    private String currentToken = "";
   
    private JButton decimalPoint;

    
    public Calculator3(){
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

        resultTextArea.setText(savedResultStr);
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

       

        GridBagConstraints keyPadGridConstraints = new GridBagConstraints();
        keyPadGridConstraints.fill = GridBagConstraints.BOTH;
        keyPadGridConstraints.weightx = 1.0;
        keyPadGridConstraints.weighty = 1.0; 
        this.keyPadGridConstraints = keyPadGridConstraints;

        addNumberButton(1, 0, 5);
        addNumberButton(2, 1, 5);
        addNumberButton(3, 2, 5);
        addNumberButton(4, 0, 4);
        addNumberButton(5, 1, 4);
        addNumberButton(6, 2, 4);
        addNumberButton(7, 0, 3);
        addNumberButton(8, 1, 3);
        addNumberButton(9, 2, 3);
        addNumberButton(0, 1, 6);

        addOperators("/", 3, 2);
        addOperators("X", 3, 3);
        addOperators("-", 3, 4);
        addOperators("+", 3, 5);

        addEqualsButton("=", 3, 6);
        addClearButton("C", 2, 1);
        addClearEntryButton("CE", 1, 1);


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

    public void addEqualsButton(String text, int gridx, int gridy) {
        this.equals = new JButton(text);
        keyPadGridConstraints.gridx = gridx;
        keyPadGridConstraints.gridy = gridy;
        equals.addActionListener(e -> {
           equalsAction();
        });
        keypadJPanel.add(equals, keyPadGridConstraints); 

    }

    public void addClearButton(String text, int gridx, int gridy) {
        
        this.clear = new JButton(text);
        keyPadGridConstraints.gridx = gridx;
        keyPadGridConstraints.gridy = gridy;
        clear.addActionListener(e -> {
            clearActions();
        });
        keypadJPanel.add(clear, keyPadGridConstraints);

    }

    public void addClearEntryButton(String text, int gridx, int gridy) {
        
        this.clearEntry = new JButton(text);
        keyPadGridConstraints.gridx = gridx;
        keyPadGridConstraints.gridy = gridy;
        clearEntry.addActionListener(e -> {
            clearEntryActions();
        });
        keypadJPanel.add(clearEntry, keyPadGridConstraints);

    }

    /*
     * Problem is that I can distinguish when there is an old operation but I am not sure how to reset currentOperandStr to "" because I cannot do that in the operatorAction method
     * or the numbersAction method. In the operator method the currentOperand stays and firstOperand copys the value from currentOperand. I cant do it in numbersAction
     * cause everytime a number is clicked currentOperand will be erased.
     */


    public void numbersAction(String number) {
        if(!isNewOperation) {
            currentOperandStr = "";
            currentOperand = 0;
            isNewOperation = true;

        }
        
        currentOperandStr = currentOperandStr.concat(number);
        currentOperand = Double.valueOf(currentOperandStr);

        currentToken = number;
        
        
        printTesting();
    }


    public void operatorAction(String operator) {

        if(isNewOperation == false) {
            currentOperand = currentOperand + firstOperand;
            currentOperandStr = String.valueOf(currentOperand);

            firstOperand = currentOperand;


        } else if (currentToken.equals("=")) {
            firstOperand = currentOperand;
            firstOperandStr = String.valueOf(firstOperand);
            isNewOperation = true;

        } else {
            firstOperand = calculate(currentOperand, firstOperand, currentOperator);
            firstOperandStr = String.valueOf(firstOperand);
            currentOperand = firstOperand;
            currentOperandStr = String.valueOf(currentOperand);
            
            
        }

        isNewOperation = false; 
        currentOperator = operator;      
        currentToken = operator;
    
        printTesting();
    }

    public void equalsAction() {

        if(currentToken.equals("=")) {
            firstOperand = currentOperand;
            firstOperandStr = String.valueOf(firstOperand);
            currentOperand = calculate(currentOperand, secondOperand, currentOperator);
            currentOperandStr = String.valueOf(currentOperand);
            savedResult = currentOperand;
            

        } else {
            savedResult = calculate(firstOperand, currentOperand, currentOperator);
            secondOperand = currentOperand;
            secondOperandStr = String.valueOf(secondOperand);
            currentOperand = savedResult;
            currentOperandStr = String.valueOf(currentOperand);
            isNewOperation = true;

        }

        

        currentToken = "=";

        printTesting();
    
    }

    

    public void clearActions() {
       

    }

    public void clearEntryActions() {
       
        
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

    
    public void operation() {
        if(isNewOperation == false) {
            System.out.println("Old operation");
        } else {
            System.out.println("New operation");
        }
    }

    public void printTesting() {
        System.out.println("Current operand: " + currentOperand);
        System.out.println("Current operand string : " + currentOperandStr);

        System.out.println("First operand: " + firstOperand);
        System.out.println("First operand string : " + firstOperandStr);

        System.out.println("Second operand: " + secondOperand);
        System.out.println("Second operand string: " + secondOperandStr);

        System.out.println("Third operand: " + thirdOperand);
        System.out.println("Third operand string: " + thirdOperandStr);

        System.out.println("Current operator: " + currentOperator);

        System.out.println("Saved result: " + savedResult);
        System.out.println("Saved result string: " + savedResultStr);

        System.out.println("Current Token: " + currentToken);
        operation();
        System.out.println("--------------");
    }


    public static void main(String[] args) {
        Calculator3 calc = new Calculator3();

    }





}

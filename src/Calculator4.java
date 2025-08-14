import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;

import java.awt.event.*;
import java.awt.*;

public class Calculator4 {

    JFrame frame;
    JPanel keypadJPanel;
    JTextField calculationField;
    JTextArea resultTextArea;

    GridBagConstraints keyPadGridConstraints;

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
    
    JButton equals;

    boolean isNewOperation = true;

    JButton clear;
    JButton clearEntry;
    
    String savedResultStr = "0";
    Number savedResult = 0;

    String currentOperandStr = "";
     Number currentOperand = 0;

     String firstOperandStr = "";
     Number firstOperand = 0;

     String secondOperandStr = "";
     Number secondOperand = 0;

     String thirdOperandStr = "";
     Number thirdOperand = 0;

     String currentOperator = "+";
     String currentToken = "";
   
     JButton decimalPoint;

    
    public Calculator4(){
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

        frame.add(CalculaterLabel);
        frame.add(calculationField);
        frame.add(resultTextArea);
        
        addAllButtons();
        frame.add(keypadJPanel);
        
        frame.setVisible(true);

    frame.setDefaultCloseOperation(2);
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

        addDecimalPoint(".", 2, 6);

       


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

    public void addDecimalPoint(String text, int gridx, int gridy) {

        JButton decimalPoint = new JButton(text);
        keyPadGridConstraints.gridx = gridx;
        keyPadGridConstraints.gridy = gridy;
        decimalPoint.addActionListener(e -> {
            decimalPointButtonAction();
        });

        keypadJPanel.add(decimalPoint, keyPadGridConstraints);


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


    public void numbersAction(String number) {
        if(currentToken.equals("=")) {
            clearActions();
            
        }        

        saveCurrentOperand(number);
        resultTextArea.setText(currentOperandStr);

        printTesting();

    }

    public void saveCurrentOperand(String number) {
         if(!isNewOperation) {
            currentOperandStr = "";
            currentOperand = 0;
            isNewOperation = true;

        }
        
        currentOperandStr = currentOperandStr.concat(number);
        currentOperand = printNumber(Double.valueOf(currentOperandStr));

        currentToken = number;
        
        /*
         * This allows me to type a number into the correct spot or "current operand". I do this using a boolean (isNewOperation) to tell me when there is or is
         * not a new operation. If there is a new operation then I can type into currentOperand. If not the currentOperand is reset. 
         */

    }


    public void operatorAction(String operator) {
        /* 
        if(isNewOperation == false) {
            currentOperand = currentOperand + firstOperand;
            currentOperandStr = String.valueOf(currentOperand);
            firstOperand = currentOperand;

        } else
*/

        if (currentToken.equals("=")) {
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

        calculationField.setText(firstOperandStr + " " + currentOperator);
        printTesting();
    }

    /*
     * WHen an operator is clicked the first operand appears (ex, 3 + : "3 +"), if you click an operator again then the firstoperand changes 
     * (ex, 3 + : "3 +" 3 + 4 +: "7 +"), 
     * 
     * When a equals is clicked the second operand and a equal "=" sign get added. (ex, )
     */

    public void equalsAction() {

        if(currentToken.equals("=")) {
            firstOperand = currentOperand;
            firstOperandStr = String.valueOf(currentOperand);
            currentOperand = calculate(currentOperand, secondOperand, currentOperator);
            currentOperandStr = String.valueOf(currentOperand);
            savedResult = currentOperand;

        } else if (firstOperandStr.isEmpty()) {
            firstOperand = currentOperand;
            firstOperandStr = String.valueOf(currentOperand);
        
        } else {
            savedResult = calculate(firstOperand, currentOperand, currentOperator);
            secondOperand = currentOperand;
            secondOperandStr = String.valueOf(secondOperand);
            currentOperand = savedResult;
            currentOperandStr = String.valueOf(currentOperand);
            isNewOperation = true;

        }

        resultTextArea.setText(currentOperandStr);
        calculationField.setText(firstOperandStr + " " + currentOperator + " " + secondOperandStr + " = ");

        currentToken = "=";
        printTesting();
    
    }

    public void decimalPointButtonAction() {
        currentOperandStr = currentOperandStr.concat(".");
        currentOperand = currentOperand.doubleValue() + 0.0; 
        resultTextArea.setText(currentOperandStr);

        printTesting();

    }

    public void clearActions() {
        currentOperand = 0;
        firstOperand = 0;
        secondOperand = 0;
        thirdOperand = 0;
        savedResult = 0;

        currentOperandStr = "";
        firstOperandStr = "";
        secondOperandStr = "";
        thirdOperandStr = "";
        savedResultStr = "0";
        
        currentToken = "";
        currentOperator = "+";
        isNewOperation = true;

        currentToken = "";

        System.out.println("[ clearActions method called ]");

        resultTextArea.setText(String.valueOf(currentOperand));
        calculationField.setText("");

        printTesting();

    }

    public void clearEntryActions() {

        if(currentToken.equals("=")) {
            clearActions();
            return;
        }

        currentOperand = 0;
        currentOperandStr = "";

        if(!isNewOperation) {
            isNewOperation = true;

        }

        resultTextArea.setText(String.valueOf(currentOperand));

        printTesting();
       
        
    }


    public Number calculate(Number firstOperand, Number secondValue, String operator) {
        
        switch(operator) {
            case "+": return printNumber(firstOperand.doubleValue() + secondValue.doubleValue());
            case "-": return printNumber(firstOperand.doubleValue() - secondValue.doubleValue());
            case "X": return printNumber(firstOperand.doubleValue() * secondValue.doubleValue());
            case "/": 
                if(secondValue.doubleValue() != 0.0) return printNumber(firstOperand.doubleValue() / secondValue.doubleValue());
                else throw new ArithmeticException("Division by zero");
            default: return 0;
                        
        }

    }

    public Number printNumber(double number) {

        if(number == Math.floor(number)) {
            return (int) number;
            
        } else {
            return number;

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

    public void instanceTest() {
        System.out.println("Instance test executed (calc4)");
    }

    public static void test() {
        System.out.println("Test calc4");
    }


    public static void main(String[] args) {
        Calculator4 calc = new Calculator4();

    }

}

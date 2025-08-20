import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ProgrammingCalculator extends Calculator{


    public ProgrammingCalculator() {
        super();

    }

    public void addAllButtons() {

        GridBagConstraints keyPadGridConstraints = new GridBagConstraints();
        keyPadGridConstraints.fill = GridBagConstraints.BOTH;
        keyPadGridConstraints.weightx = 1.0;
        keyPadGridConstraints.weighty = 1.0; 
        this.keyPadGridConstraints = keyPadGridConstraints;

        addNumberButton(1, 1, 5);
        addNumberButton(2, 2, 5);
        addNumberButton(3, 3, 5);
        addNumberButton(4, 1, 4);
        addNumberButton(5, 2, 4);
        addNumberButton(6, 3, 4);
        addNumberButton(7, 1, 3);
        addNumberButton(8, 2, 3);
        addNumberButton(9, 3, 3);
        addNumberButton(0, 2, 6);

        addOperators("/", 4, 2);
        addOperators("X", 4, 3);
        addOperators("-", 4, 4);
        addOperators("+", 4, 5);

        addEqualsButton("=", 4, 6);
        addClearButton("C", 3, 0);
        
        //addClearEntryButton("CE", 1, 1); In scientific calculator this button appears once a number is clicked

        addDecimalPoint(".", 3, 6);

    }

     public void test() {
        System.out.println("Test pcalc");
    }

    public static void main(String [] args) {
       

        ArrayList<Calculator> calcList = new ArrayList<Calculator>();
        ScientificCalculator scalc = new ScientificCalculator();
        Calculator pcalc = new ProgrammingCalculator();
        Calculator stancalc = new Calculator();
        calcList.add(scalc);
        calcList.add(pcalc);
        calcList.add(stancalc);

        for(Calculator calc : calcList) {
            calc.test();
        }

        Calculator PCalc = new ProgrammingCalculator();

    

    }
    
}

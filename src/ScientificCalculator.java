import java.awt.*;
import javax.swing.*;

public class ScientificCalculator extends Calculator4 {
    
    public ScientificCalculator() {
        super();

        //Add 3 Panel types to add more buttons


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

        addAdvancedFunctions("2nd", 0, 0);
        addAdvancedFunctions("π", 1, 0);
        addAdvancedFunctions("e", 2, 0);
        addAdvancedFunctions("⌫", 4, 0);
        addAdvancedFunctions("x²", 0, 1);
        addAdvancedFunctions("1/x", 1, 1);
        addAdvancedFunctions("|x|", 2, 1);
        addAdvancedFunctions("exp", 3, 1);
        addAdvancedFunctions("mod", 4, 1);
        addAdvancedFunctions("2√x", 0, 2);
        addAdvancedFunctions("(", 1, 2);
        addAdvancedFunctions(")", 2, 2);
        addAdvancedFunctions("n!", 3, 2);
        addAdvancedFunctions("xʸ", 0, 3);
        addAdvancedFunctions("10ˣ", 0, 4);
        addAdvancedFunctions("log", 0, 5);
        addAdvancedFunctions("ln", 0, 6);
        addAdvancedFunctions("x/-", 1, 6);

        addMoreAdvancedFunctions();

        

    }

    public void addMoreAdvancedFunctions() {
        /*
         * Create JPanel with a Boxlayout of 3 rows and 1 column
         * Add it to keyPadJPanel and assign it the respective gridx and gridy values to make it fit above.
         */

        JPanel firstRow = new JPanel();
        firstRow.setLayout(new BoxLayout(firstRow, BoxLayout.X_AXIS));
        firstRow.setPreferredSize(new Dimension(frame.getContentPane().getWidth(), 25));

        JPanel secondRow = new JPanel();
        secondRow.setLayout(new BoxLayout(secondRow, BoxLayout.X_AXIS));
        secondRow.setPreferredSize(new Dimension(frame.getContentPane().getWidth(), 25));

        JPanel thirdRow = new JPanel();
        thirdRow.setLayout(new BoxLayout(thirdRow, BoxLayout.X_AXIS));
        thirdRow.setPreferredSize(new Dimension(frame.getContentPane().getWidth(), 25));

        
        firstRow.add(new JButton("DEG"));
        firstRow.add(new JButton("F-E"));

        secondRow.add(new JButton("MC"));
        secondRow.add(new JButton("MR"));
        secondRow.add(new JButton("M+"));
        secondRow.add(new JButton("M-"));
        secondRow.add(new JButton("MS"));
        secondRow.add(new JButton("M"));

        thirdRow.add(new JButton("Trig"));
        thirdRow.add(new JButton("Function"));

        firstRow.add(Box.createHorizontalGlue());
        secondRow.add(Box.createHorizontalGlue());
        thirdRow.add(Box.createHorizontalGlue());

        this.frame.add(firstRow);
        this.frame.add(secondRow);
        this.frame.add(thirdRow);
        

    }

    public void addAdvancedFunctions(String text, int gridx, int gridy) {
        JButton button = new JButton(text);
        keyPadGridConstraints.gridx = gridx;
        keyPadGridConstraints.gridy = gridy;
        
        button.addActionListener(e -> {
           
        });
        keypadJPanel.add(button, keyPadGridConstraints);

    }

   

    public static void main(String [] args) {
        //ScientificCalculator scalc = new ScientificCalculator();
        ScientificCalculator calc4 = new ScientificCalculator();
        

        //ScientificCalculator.test();

    }

    


}

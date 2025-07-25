import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator extends JFrame{

    private JFrame frame;
    private JPanel keypadJPanel;

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
    private JButton add;
    private JButton multiply;
    private JButton divide;
    private JButton clear;
    private JButton equals;
   
    private JButton decimalPoint;
    
    public Calculator(){
        this.frame = new JFrame();
        this.frame.setSize(400, 400);
        this.frame.setLayout(new BoxLayout(this.frame.getContentPane(), BoxLayout.Y_AXIS));
        this.frame.setMinimumSize(new Dimension(300, 400));

        JLabel CalculaterLabel = new JLabel("Calculator");
        frame.add(CalculaterLabel);

        JTextArea resultJTextArea = new JTextArea("test", 1, 1);
        resultJTextArea.setLineWrap(true);
        frame.add(resultJTextArea);
        resultJTextArea.setMinimumSize(new Dimension(frame.getContentPane().getWidth(), 150));

        this.keypadJPanel = new JPanel();
        keypadJPanel.setLayout(new GridBagLayout());
        keypadJPanel.setPreferredSize(new Dimension(frame.getContentPane().getWidth(), 500));

        
        addAllButtons();

        frame.add(keypadJPanel);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void addAllButtons() {

        GridBagConstraints keyPadGridConstraints = new GridBagConstraints();
        keyPadGridConstraints.fill = GridBagConstraints.BOTH;
        keyPadGridConstraints.weightx = 1.0;
        keyPadGridConstraints.weighty = 1.0; 

        this.num1 = new JButton("1");
        keyPadGridConstraints.gridx = 0;
        keyPadGridConstraints.gridy = 0;
        keypadJPanel.add(num1, keyPadGridConstraints);

        this.num2 = new JButton("2");
        keyPadGridConstraints.gridx = 1;
        keypadJPanel.add(num2, keyPadGridConstraints);

        this.num3 = new JButton("3");
        keyPadGridConstraints.gridx = 2;
        keypadJPanel.add(num3, keyPadGridConstraints);

        this.num4 = new JButton("4");
        keyPadGridConstraints.gridx = 0;  // Column 0
        keyPadGridConstraints.gridy = 1;
        keypadJPanel.add(num4, keyPadGridConstraints);

        this.num5 = new JButton("5");
        keyPadGridConstraints.gridx = 1;
        keypadJPanel.add(num5, keyPadGridConstraints);

        this.num6 = new JButton("6");
        keyPadGridConstraints.gridx = 2;
        keypadJPanel.add(num6, keyPadGridConstraints);

        this.num7 = new JButton("7");
        keyPadGridConstraints.gridx = 0;
        keyPadGridConstraints.gridy = 2;
        keypadJPanel.add(num7, keyPadGridConstraints);

        this.num8 = new JButton("8");
        keyPadGridConstraints.gridx = 1;
        keypadJPanel.add(num8, keyPadGridConstraints);

        this.num9 = new JButton("9");
        keyPadGridConstraints.gridx = 2;
        keypadJPanel.add(num9, keyPadGridConstraints);

        this.num9 = new JButton("0");
        keyPadGridConstraints.gridx = 1;
        keyPadGridConstraints.gridy = 3;
        keypadJPanel.add(num9, keyPadGridConstraints);

    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();

    }





}

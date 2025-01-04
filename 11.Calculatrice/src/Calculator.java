import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    JLabel resultLabel;
    String printResultForUser;
    Integer x;
    Integer y;
    String op;

    public Calculator(){
        super("Calculatrice");

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel gridPanel = new JPanel(new GridLayout(4,4));
        JButton btnZero = new JButton("0");
        JButton btnOne = new JButton("1");
        JButton btnTwo = new JButton("2");
        JButton btnThree = new JButton("3");
        JButton btnFour = new JButton("4");
        JButton btnFive = new JButton("5");
        JButton btnSix = new JButton("6");
        JButton btnSeven = new JButton("7");
        JButton btnEight = new JButton("8");
        JButton btnNine = new JButton("9");
        JButton btnPlus = new JButton("+");
        JButton btnMinus = new JButton("-");
        JButton btnDivide = new JButton("/");
        JButton btnMultiply = new JButton("*");
        JButton btnEqual = new JButton("=");
        JButton btnClear = new JButton("c");

        printResultForUser = "";
        resultLabel = new JLabel(" ");

        resultLabel.setFont(new Font(resultLabel.getFont().getFontName(), Font.PLAIN,30));

        gridPanel.add(btnOne);
        gridPanel.add(btnTwo);
        gridPanel.add(btnThree);
        gridPanel.add(btnPlus);
        gridPanel.add(btnFour);
        gridPanel.add(btnFive);
        gridPanel.add(btnSix);
        gridPanel.add(btnMinus);
        gridPanel.add(btnSeven);
        gridPanel.add(btnEight);
        gridPanel.add(btnNine);
        gridPanel.add(btnMultiply);
        gridPanel.add(btnClear);
        gridPanel.add(btnZero);
        gridPanel.add(btnEqual);
        gridPanel.add(btnDivide);

        mainPanel.add(resultLabel, BorderLayout.NORTH);
        mainPanel.add(gridPanel, BorderLayout.CENTER);

        btnClear.addActionListener(e -> {
            x = 0;
            y = 0;
            printResultForUser = (""); // Permet de remettre la phrase vide
            resultLabel.setText(" "); // Permet de laisser l'affichage à l'utilisateur
            op = null;
        });

        btnEqual.addActionListener(e -> {
            y = Integer.parseInt(printResultForUser.substring((String.valueOf(x).length()+1)));
            switch (op){
                case "+":
                    add(x,y);
                    printResultForUser = Integer.toString(this.x);
                    resultLabel.setText(printResultForUser);
                    break;
                case "-":
                    substract(x,y);
                    printResultForUser = Integer.toString(this.x);
                    resultLabel.setText(printResultForUser);
                    break;
                case "*":
                    multiply(x,y);
                    printResultForUser = Integer.toString(this.x);
                    resultLabel.setText(printResultForUser);
                    break;
                case "/":
                    try {
                        divide(x,y);
                    } catch (ArithmeticException ae){
                        resultLabel.setText("∞");
                        x = null;
                        y = null;
                    }
                default:
            }
            op = null;
        });

        btnPlus.addActionListener(e -> {
            op = btnPlus.getText();
            x = Integer.parseInt(printResultForUser);
            showValueOfButton(btnPlus);
        });
        btnMinus.addActionListener(e -> {
            op = btnMinus.getText();
            x = Integer.parseInt(printResultForUser);
            showValueOfButton(btnMinus);
        });
        btnDivide.addActionListener(e -> {
            op = btnDivide.getText();
            x = Integer.parseInt(printResultForUser);
            showValueOfButton(btnDivide);
        });
        btnMultiply.addActionListener(e -> {
            op = btnMultiply.getText();
            x = Integer.parseInt(printResultForUser);
            showValueOfButton(btnMultiply);
        });


        btnZero.addActionListener(e -> showValueOfButton(btnZero));
        btnOne.addActionListener(e -> showValueOfButton(btnOne));
        btnTwo.addActionListener(e -> showValueOfButton(btnTwo));
        btnThree.addActionListener(e -> showValueOfButton(btnThree));
        btnFour.addActionListener(e -> showValueOfButton(btnFour));
        btnFive.addActionListener(e -> showValueOfButton(btnFive));
        btnSix.addActionListener(e -> showValueOfButton(btnSix));
        btnSeven.addActionListener(e -> showValueOfButton(btnSeven));
        btnEight.addActionListener(e -> showValueOfButton(btnEight));
        btnNine.addActionListener(e -> showValueOfButton(btnNine));

        setContentPane(mainPanel);
        setSize(300,300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void add(int x,int y){
        this.x = x + y;
        resultLabel.setText(Integer.toString(this.x));
    }
    private void substract(int x,int y){
        this.x = x - y;
        resultLabel.setText(Integer.toString(this.x));
    }
    private void multiply(int x,int y){
        this.x = x * y;
        resultLabel.setText(Integer.toString(this.x));
    }
    private void divide(int x, int y){
        if(x/y == (int) x/y)
            this.x = x / y;
        resultLabel.setText(Integer.toString(this.x));
    }

    private void showValueOfButton(JButton button){
        printResultForUser += button.getText();
        resultLabel.setText(printResultForUser);
    }
}

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    JLabel resultLabel;
    String printResultForUser;
    Float x;
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
        JButton[] allBtnArray = {btnOne, btnTwo, btnThree, btnPlus,btnFour, btnFive, btnSix, btnMinus ,btnSeven, btnEight, btnNine,  btnMultiply, btnClear, btnZero, btnEqual,btnDivide};
        JButton[] btnArrayWithoutClear = {btnOne, btnTwo, btnThree, btnPlus,btnFour, btnFive, btnSix, btnMinus ,
                btnSeven,
                btnEight, btnNine,  btnMultiply, btnZero, btnEqual,btnDivide};
        JButton[] btnArrayWithoutEqualAndClear = {btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnDivide, btnPlus, btnMinus, btnMultiply};
        JButton[] btnActionArrayWithoutEqualAndClear = {btnPlus, btnMinus, btnDivide, btnMultiply};

        printResultForUser = "";
        op = "";
        resultLabel = new JLabel(" ");

        resultLabel.setFont(new Font(resultLabel.getFont().getFontName(), Font.PLAIN,30));

        for(JButton btn : btnArrayWithoutEqualAndClear){
            btn.addActionListener(e-> showValueOfButton(btn));
        }

        for(JButton btn : btnActionArrayWithoutEqualAndClear){
           btn.addActionListener(e -> op += btn.getText());
        }

        for(JButton btn : allBtnArray){
            gridPanel.add(btn);
        }

        mainPanel.add(resultLabel, BorderLayout.NORTH);
        mainPanel.add(gridPanel, BorderLayout.CENTER);

        btnClear.addActionListener(e -> {
            x = null;
            y = null;
            op = "";
            printResultForUser = (""); // Permet de remettre la phrase vide
            resultLabel.setText(" "); // Permet de laisser l'affichage à l'utilisateur
           toggleDisableBtn(btnArrayWithoutClear, true);
        });

        btnEqual.addActionListener(e -> {
            String regex = "[*/+-]";
            String[] strXAndY = printResultForUser.replaceAll(regex, ":").split(":");
            if(strXAndY.length <= 2) {
                x = Float.parseFloat(strXAndY[0]);
                y = Integer.parseInt(strXAndY[1]);

                switch (op) {
                    case "+":
                        add(x, y);
                        printIntOrFloat(x);
                        break;
                    case "-":
                        substract(x, y);
                        printIntOrFloat(x);
                        break;
                    case "*":
                        multiply(x, y);
                        printIntOrFloat(x);
                        break;
                    case "/":
                        /*try {
                            divide(x, y);
                            printIntOrFloat(this.x);
                        } catch (NumberFormatException nfe) {
                            resultLabel.setText("∞");
                        }*/
                        divide(x, y);
                        printIntOrFloat(x);
                        if(x.isInfinite()){
                            resultLabel.setText("∞");
                            toggleDisableBtn(btnArrayWithoutClear, false);
                        }
                        x = null;
                        y = null;
                    default:
                }
                op = "";
            } else {
                printResultForUser= "";
                resultLabel.setText("Error");
                toggleDisableBtn(btnArrayWithoutClear,false);
            }

        });

        setContentPane(mainPanel);
        setSize(300,300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void add(float x,int y){
        this.x = x + y;
    }
    private void substract(float x,int y){
        this.x = x - y;
    }
    private void multiply(float x,int y){
        this.x = x * y;}
    private void divide(float x, int y){
        this.x = x / y;
    }

    private void printIntOrFloat(float x){
        if(x == (int) x){
            printResultForUser = Integer.toString((int)x);
            resultLabel.setText(printResultForUser);
        } else{
            printResultForUser = String.format("%.2f", this.x);
            resultLabel.setText(printResultForUser);
        }
    }

    private void showValueOfButton(JButton button){
        printResultForUser += button.getText();
        resultLabel.setText(printResultForUser);
    }

    private void toggleDisableBtn(JButton[] button, boolean isEnable){
        for (JButton btn : button){
            btn.setEnabled(isEnable);
        }
    }
}

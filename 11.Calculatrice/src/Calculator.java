import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Calculator extends JFrame {
    JLabel resultLabel;
    String strToOperate;
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
        JButton[] btnArrayWithoutClear = {btnOne, btnTwo, btnThree, btnPlus,btnFour, btnFive, btnSix, btnMinus , btnSeven, btnEight, btnNine,  btnMultiply, btnZero, btnEqual,btnDivide};
        JButton[] btnArrayWithoutEqualAndClear = {btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnDivide, btnPlus, btnMinus, btnMultiply};
        JButton[] btnOperatorWithoutEqual = {btnPlus, btnMinus, btnDivide, btnMultiply};
        JButton[] btnArrayAllDigits = {btnOne, btnTwo, btnThree,btnFour, btnFive, btnSix , btnSeven, btnEight, btnNine};

        strToOperate = "";
        op = "";
        resultLabel = new JLabel(" ");
        resultLabel.setFont(new Font(resultLabel.getFont().getFontName(), Font.PLAIN,30));

        for(JButton btn : btnArrayWithoutEqualAndClear){
            btn.addActionListener(e-> {
                showValueOfButton(btn);
            });
        }

        for (JButton btn : btnArrayAllDigits){
            btn.addActionListener(e -> {
                if(op.isEmpty())
                    toggleBtn(btnOperatorWithoutEqual, true);
                if(!op.isEmpty())
                    btnEqual.setEnabled(true);
            });

        }

        for(JButton btn : btnOperatorWithoutEqual){
           btn.addActionListener(e -> {
               op += btn.getText();
               toggleBtn(btnOperatorWithoutEqual, false);
           });
        }

        btnClear.addActionListener(e -> {
            x = null;
            y = null;
            op = "";
            strToOperate = "";
            resultLabel.setText(" ");
            toggleBtn(btnArrayAllDigits, true);
            btnMinus.setEnabled(false);
            btnEqual.setEnabled(false);
        });

        btnEqual.addActionListener(e -> {
            String regex = "[*/+-]";
            String[] strXAndY = strToOperate.replaceAll(regex, ":").split(":");
            boolean isNegative = Objects.equals(strXAndY[0], "");

            if(strXAndY.length <= 2 ||(isNegative && strXAndY.length == 3) ) {
                x = isNegative ? Float.parseFloat(strXAndY[1]) * -1 : Float.parseFloat(strXAndY[0]);
                y = isNegative ? Integer.parseInt(strXAndY[2]) : Integer.parseInt(strXAndY[1]);

                switch (op) {
                    case "+":
                        add(x, y);
//                        printIntOrFloat(x);
                        break;
                    case "-":
                        substract(x, y);
//                        printIntOrFloat(x);
                        break;
                    case "*":
                        multiply(x, y);
//                        printIntOrFloat(x);
                        break;
                    case "/":
                        divide(x, y);
                    default:
                }

                printIntOrFloat(x);
                op = "";
                toggleBtn(btnOperatorWithoutEqual, true);
                if(x.isInfinite()){
                    resultLabel.setText("∞");
                    toggleBtn(btnArrayWithoutClear, false);
                }

            } else {
                strToOperate = "";
                resultLabel.setText("Error");
                toggleBtn(btnArrayWithoutClear,false);
            }

        });

        btnMinus.setEnabled(false);
        btnEqual.setEnabled(false);

        for(JButton btn : allBtnArray){
            gridPanel.add(btn);
        }

        mainPanel.add(resultLabel, BorderLayout.NORTH);
        mainPanel.add(gridPanel, BorderLayout.CENTER);

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
            strToOperate = Integer.toString((int)x);
            resultLabel.setText(strToOperate);
        } else{
            strToOperate = String.format("%.2f", this.x);
            resultLabel.setText(strToOperate);
        }
    }

    private void showValueOfButton(JButton button){
        strToOperate += button.getText();
        resultLabel.setText(strToOperate);
    }

    private void toggleBtn(JButton[] button, boolean isEnable){
        for (JButton btn : button){
            btn.setEnabled(isEnable);
        }
    }
}

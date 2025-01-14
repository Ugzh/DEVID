import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Locale;

public class Calculator extends JFrame {
    JLabel resultLabel;
    String strToOperate, op;
    Float x;
    Integer y;

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
        JButton[] btnArrayWithoutEqualAndClear = {btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnDivide, btnPlus, btnMinus, btnMultiply};
        JButton[] btnArrayWithoutClear = {btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven,
                btnEight, btnNine, btnDivide, btnPlus, btnMinus, btnMultiply, btnEqual};
        JButton[] btnArrayAllDigitsAndEqual = {btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven,
                btnEight, btnNine, btnEqual};
        JButton[] btnOperatorWithoutEqual = {btnPlus, btnMinus, btnDivide, btnMultiply};

        strToOperate = "";
        op = "";
        resultLabel = new JLabel(" ");
        resultLabel.setFont(new Font(resultLabel.getFont().getFontName(), Font.PLAIN,40));

        for(JButton btn : btnArrayWithoutEqualAndClear){
            btn.addActionListener(e-> {
                showValueOfButton(btn);
            });
        }

        for(JButton btn : btnOperatorWithoutEqual){
           btn.addActionListener(e -> {
               op += btn.getText();
               toggleBtn(btnArrayAllDigitsAndEqual, true);
           });
        }

        btnClear.addActionListener(e -> {
            x = null;
            y = null;
            op = "";
            strToOperate = "";
            resultLabel.setText(" ");
            toggleBtn(btnArrayWithoutClear, true);
        });

        btnEqual.addActionListener(e -> {
            String regex = "[*/\\-+]";
            String[] strArrayXAndY = strToOperate.replaceAll(regex, ":").split(":");

            boolean isNegative = Objects.equals(strArrayXAndY[0], "");
            if (strArrayXAndY.length <= 2 || (isNegative && strArrayXAndY.length == 3)) {
                try {
                    x = isNegative ? Float.parseFloat(strArrayXAndY[1]) * -1 : Float.parseFloat(strArrayXAndY[0]);
                    y = isNegative ? Integer.parseInt(strArrayXAndY[2]) : Integer.parseInt(strArrayXAndY[1]);
                    switch (op) {
                        case "+":
                            add(x, y);
                            break;
                        case "-":
                            substract(x, y);
                            break;
                        case "*":
                            multiply(x, y);
                            break;
                        case "/":
                            divide(x, y);
                        default:
                    }
                    printIntOrFloat(x);
                    op = "";
                    toggleBtn(btnArrayAllDigitsAndEqual, false);
                    if (x.isInfinite()) {
                        resultLabel.setText(String.valueOf(x));
                        toggleBtn(btnArrayWithoutClear, false);
                    }
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    resultLabel.setText("Error");
                    toggleBtn(btnArrayWithoutClear, false);
                }
            } else {
                strToOperate = "";
                resultLabel.setText("Error");
                toggleBtn(btnArrayWithoutClear, false);
            }
        });


        for(JButton btn : allBtnArray){
            gridPanel.add(btn);
        }

        mainPanel.add(resultLabel, BorderLayout.NORTH);
        mainPanel.add(gridPanel, BorderLayout.CENTER);
        setContentPane(mainPanel);

        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void add(float x,int y){
        this.x = x + y;
    }

    private void substract(float x,int y){
        this.x = x - y;
    }

    private void multiply(float x,int y){
        this.x = x * y;
    }

    private void divide(float x, int y){
        this.x = x / y;
    }

    private void printIntOrFloat(float x){
        strToOperate = x == (int) x ? Integer.toString((int)x) : String.format(Locale.ROOT,"%.2f", x) ;
        resultLabel.setText(strToOperate);
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

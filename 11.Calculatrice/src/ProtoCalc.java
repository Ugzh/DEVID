import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

public class ProtoCalc extends JFrame{

    private StringBuilder strBld = new StringBuilder();
    private String[] strVal = new String[2];
    private float val1,val2;
    private float ans;
    private String operator,strAns;
    boolean operatorIsLoaded = false;


    private Font customFont = new Font("Avenir",Font.PLAIN,50 );
    private JLabel lbDisplay = new JLabel("");
    private JButton btn1 = new JButton("1");
    private JButton btn2 = new JButton("2");
    private JButton btn3 = new JButton("3");
    private JButton btn4 = new JButton("4");
    private JButton btn5 = new JButton("5");
    private JButton btn6 = new JButton("6");
    private JButton btn7 = new JButton("7");
    private JButton btn8 = new JButton("8");
    private JButton btn9 = new JButton("9");
    private JButton btn0 = new JButton("0");
    private JButton btnPlus = new JButton("+");
    private JButton btnMinus = new JButton("-");
    private JButton btnMultiply = new JButton("*");
    private JButton btnDivide = new JButton("/");
    private JButton btnEqual = new JButton("=");
    private JButton btnCancel = new JButton("C");
    private JButton[] allBtns = { btn1, btn2, btn3, btnPlus, btn4, btn5, btn6, btnMinus,btn7, btn8, btn9,
            btnMultiply, btnCancel, btn0,btnEqual, btnDivide};



    public ProtoCalc(){
        super("Calculatrice de Lucas");

        buildUI();
        actionSetup();

        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void actionSetup() {

        JButton[] allOperatorButtons = {btnPlus, btnMinus, btnDivide, btnMultiply};
        JButton[] allDigitsBtn = {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};

        for(JButton btn : allOperatorButtons){
            btn.addActionListener( e -> {
                if(!operatorIsLoaded){
                    appendCalc(btn.getText());
                    operator = btn.getText();
                    operatorIsLoaded = true;
                }
                else{
                    operatorError();
                }
            });
        }

        for(JButton btn : allDigitsBtn){
            btn.addActionListener( e -> appendCalc(btn.getText()));
        }

        /*btn0.addActionListener(e -> {appendCalc(btn0.getText());});
        btn1.addActionListener(e -> {appendCalc(btn1.getText());});
        btn2.addActionListener(e -> {appendCalc(btn2.getText());});
        btn3.addActionListener(e -> {appendCalc(btn3.getText());});
        btn4.addActionListener(e -> {appendCalc(btn4.getText());});
        btn5.addActionListener(e -> {appendCalc(btn5.getText());});
        btn6.addActionListener(e -> {appendCalc(btn6.getText());});
        btn7.addActionListener(e -> {appendCalc(btn7.getText());});
        btn8.addActionListener(e -> {appendCalc(btn8.getText());});
        btn9.addActionListener(e -> {appendCalc(btn9.getText());});*/


        /*btnPlus.addActionListener(e -> {
            if(!operatorIsLoaded){
                appendCalc(btnPlus.getText());
                operator = "+";
                operatorIsLoaded = true;
            }
            else{
                operatorError();
            }
        });

        btnMinus.addActionListener(e -> {
            if(!operatorIsLoaded) {
                appendCalc(btnMinus.getText());
                operator = "-";
                operatorIsLoaded = true;
            }
            else{
                operatorError();
            }
        });

        btnMultiply.addActionListener(e -> {
            if(!operatorIsLoaded) {
                appendCalc(btnMultiply.getText());
                operator = "*";
                operatorIsLoaded = true;
            }
            else{
                operatorError();
            }
        });

        btnDivide.addActionListener(e -> {
            if(!operatorIsLoaded) {
                appendCalc(btnDivide.getText());
                operator = "/";
                operatorIsLoaded = true;
            }
            else{
                operatorError();
            }
        });
*/
        btnEqual.addActionListener(e -> {

            resultCalculation();

        });

        btnCancel.addActionListener(e -> {
            ans = 0;
            resetData();
            updateDisplay("");
        });
    }

    private void operatorError() {
        lbDisplay.setText("Error");
        resetData();
    }

    private void resultCalculation() {

        try {
            convertDisplayString();
        }catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e1){
            operatorError();
            return;
        }


        ans = val1;
        if(operatorIsLoaded){
            switch (operator){
                case "+":
                    ans = val1 + val2;
                    break;
                case "-":
                    ans = val1 - val2;
                    break;
                case "*":
                    ans = val1 * val2;
                    break;
                case "/":
                    ans = val1 / val2;
                    break;
                default:
            }
        }

       /* if (operator.equals("+") && operatorIsLoaded){
            ans = val1 + val2;
        }

        if (operator.equals("-") && operatorIsLoaded){
            ans = val1 - val2;
        }

        if (operator.equals("*") && operatorIsLoaded){
            ans = val1 * val2;
        }

        if (operator.equals("/") && operatorIsLoaded){
            ans = val1 / val2;
        }*/

        //strAns = formatIntOrFloat(ans);
        updateDisplay(formatIntOrFloat(ans));

        resetData();
        strBld.append(lbDisplay.getText());


    }

    private String formatIntOrFloat(float ans) {
        return ans == (int) ans ? String.format(Locale.ROOT,"%d", (int) ans) : Float.isInfinite(ans) ? "∞" :
                String.format(Locale.ROOT,"%.2f", ans);
        /*if (ans == (int) ans)
            return String.format(Locale.ROOT,"%d", (int) ans);
        else if (Float.isInfinite(ans))
            return "∞";
        else
            return String.format(Locale.ROOT,"%.2f", ans);*/
    }

    private void resetData() {
        operatorIsLoaded = false;
        val1 = 0;
        val2 = 0;
        strBld.delete(0,strBld.length());
    }

    private void convertDisplayString() {
            //int index = strBld.indexOf(operator, 1);
            //strBld.replace(strBld.indexOf(operator, 1), strBld.indexOf(operator, 1) + 1, ":");
            strVal = strBld.replace(strBld.indexOf(operator, 1), strBld.indexOf(operator, 1) + 1, ":").toString().split(":");
            val1 = Float.parseFloat(strVal[0]);
            val2 = Float.parseFloat(strVal[1]);
    }


    private void appendCalc(String userInput) {
//        strBld.append(userInput);
        updateDisplay(strBld.append(userInput).toString());
    }

    private void buildUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel gridPanel = new JPanel(new GridLayout(4,4));
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setPreferredSize(new Dimension(500, 100));


        lbDisplay.setFont(customFont);

        lbDisplay.setSize(500,80);


        /*gridPanel.add(btn1);
        gridPanel.add(btn2);
        gridPanel.add(btn3);
        gridPanel.add(btnPlus);

        gridPanel.add(btn4);
        gridPanel.add(btn5);
        gridPanel.add(btn6);
        gridPanel.add(btnMinus);

        gridPanel.add(btn7);
        gridPanel.add(btn8);
        gridPanel.add(btn9);
        gridPanel.add(btnMultiply);

        gridPanel.add(btnCancel);
        gridPanel.add(btn0);
        gridPanel.add(btnEqual);
        gridPanel.add(btnDivide);*/

        for(JButton btn : allBtns){
            gridPanel.add(btn);
        }

        displayPanel.add(lbDisplay,BorderLayout.CENTER);
        mainPanel.add(displayPanel,BorderLayout.NORTH);
        mainPanel.add(gridPanel,BorderLayout.CENTER);

        setContentPane(mainPanel); // association à la frame , sinon invisible

    }

    public void updateDisplay(String strUpdatedDisplay) {
        lbDisplay.setText(strUpdatedDisplay);
    }


}


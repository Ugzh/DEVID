import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(String title, int width, int height, boolean isResizable, boolean isVisible){
        super(title);
        setSize(width, height);
        setResizable(isResizable);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel btnPanel = new JPanel();
        JButton jButton = new JButton("2");
        jButton.setPreferredSize(new Dimension(150, 100));
        btnPanel.add(jButton);

//        btnPanel.setBackground(Color.black);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.orange);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JButton("1"), BorderLayout.CENTER);
        mainPanel.add(new JButton("3"), BorderLayout.EAST);

        mainPanel.add(btnPanel,BorderLayout.SOUTH);
        mainPanel.add(new JLabel("Salut à tous"), BorderLayout.NORTH);
        setContentPane(mainPanel);



        setVisible(isVisible);
    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SecondFrame extends JFrame {
    public SecondFrame(JFrame parent,String message){
        super();
        parent.setEnabled(false);
        JPanel returnBtnPanel = new JPanel();
        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton returnBtn = new JButton("Retour");


        returnBtnPanel.add(returnBtn);
        mainPanel.add(new JLabel(message), BorderLayout.CENTER);
        mainPanel.add(returnBtnPanel, BorderLayout.SOUTH);
        returnBtn.addActionListener(e -> {
            parent.setEnabled(true);
            dispose();
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                parent.setEnabled(true);
            }
        });

        setContentPane(mainPanel);
        setSize(350, 100);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

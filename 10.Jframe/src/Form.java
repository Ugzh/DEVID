import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form extends JFrame implements ActionListener{

    private JTextField tfFirstName, tfLastName;
    private JButton submitButton= new JButton("ok");
    private JButton cancelButton = new JButton("cancel");

    public Form(String title){
        super(title);
        setSize(250,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel formPanel = new JPanel();

        // Méthode sans les grids (gros écart avec le btn)
//        formPanel.setLayout(new BorderLayout());
//
//        JPanel namePanel = new JPanel();
//        namePanel.add(new JLabel("nom"));
//        namePanel.add(new JTextField(6));
//
//        JPanel firstNameLabel = new JPanel();
//        firstNameLabel.add(new JLabel("prénom"));
//        firstNameLabel.add(new JTextField(6));
//
//        formPanel.add(namePanel, BorderLayout.NORTH);
//        formPanel.add(firstNameLabel, BorderLayout.CENTER);

        //Méthode avec les grids (gros text inputs)

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2, 2));

        JLabel lbFirstName = new JLabel("nom :");
        lbFirstName.setHorizontalAlignment(SwingConstants.LEFT);
        JLabel lbLastName = new JLabel("prénom :");
        lbLastName.setHorizontalAlignment(SwingConstants.LEFT);

        tfFirstName = new JTextField(8);
        tfLastName = new JTextField(8);

        gridPanel.add(lbFirstName);
        gridPanel.add(tfFirstName);
        gridPanel.add(lbLastName);
        gridPanel.add(tfLastName);

        formPanel.add(gridPanel);

        //submitButton.addActionListener(this);
        submitButton.addActionListener(this);

//        cancelButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Remise à 0");
//                tfLastName.setText("");
//                tfFirstName.setText("");
//            }
//        });

        cancelButton.addActionListener(ae ->{
            System.out.println("Remise à 0");
            tfLastName.setText("");
            tfFirstName.setText("");
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(submitButton);
        buttonsPanel.add(cancelButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        setVisible(true);

        tfFirstName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submitButton){
            System.out.println("Ouille ! je m'appelle " + tfFirstName.getText()+ " "+ tfLastName.getText());
        } else {
            System.out.println("Remise à 0");
            tfLastName.setText("");
            tfFirstName.setText("");
        }
    };


}


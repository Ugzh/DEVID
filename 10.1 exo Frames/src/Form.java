import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.time.temporal.JulianFields;

public class Form extends JFrame {
    private JTextField tfLastName, tfFirstName, tfAge;
    private String sentenceIfIsAdult;

    public Form(){
        super();
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        JPanel formPanel = new JPanel();
        //JPanel gridPanel = new JPanel();
        JPanel titlePanel = new JPanel();
        JPanel btnPanel= new JPanel();
        CustomPanel customPanel = new CustomPanel(new GridLayout(3,2), Color.green);

        JButton btn = new JButton("Valider");
        JLabel jlTitle = new JLabel("Bonjour !");

        jlTitle.setFont(new Font(jlTitle.getFont().getFontName(), Font.PLAIN,30));

        tfLastName = new JTextField(8);
        tfFirstName = new JTextField(8);
        tfAge = new JTextField(8);

        btn.setHorizontalAlignment(SwingConstants.CENTER);
        //1er exo
        /*btn.addActionListener(e -> {
            String firstName = tfFirstName.getText().trim();
            String lastName = tfLastName.getText().trim();
            String strAge = tfAge.getText().trim();
            if(!firstName.isEmpty() && !lastName.isEmpty() && !strAge.isEmpty()){
                String sentenceIfIsAdult = Integer.parseInt(strAge) >= 18 ? "majeur" : "mineur";
                System.out.println("Bonjour " + firstName + " " + lastName + " tu as " + strAge + " ans et tu es "+ sentenceIfIsAdult);
            } else {
                System.out.println("Veuillez remplir tous les champs");
            }
        });*/

        //2eme exo
        /*btn.addActionListener(e -> {
            String firstName = tfFirstName.getText().trim();
            String lastName = tfLastName.getText().trim();
            String strAge = tfAge.getText().trim();
            if(!firstName.isEmpty() && !lastName.isEmpty() && !strAge.isEmpty()){
                try{
                    String sentenceIfIsAdult = Integer.parseInt(strAge) >= 18 ? "majeur" : "mineur";
                    JOptionPane.showMessageDialog(this, "Bonjour " + firstName + " " + lastName + " tu as " + strAge + " ans et tu es "+ sentenceIfIsAdult,"" , JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(this, "L'âge doit être en chiffre et sans caractères spéciaux","" , JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs","",JOptionPane.WARNING_MESSAGE);
            }
        });*/

        //3eme methode
        btn.addActionListener(e -> {
            String firstName = tfFirstName.getText().trim();
            String lastName = tfLastName.getText().trim();
            String strAge = tfAge.getText().trim();
            String message = "";
            int typeOfIcon = 0;

            if(!firstName.isEmpty() && !lastName.isEmpty() && !strAge.isEmpty()){
                try{
                    sentenceIfIsAdult = Integer.parseInt(tfAge.getText()) >= 18 ? "majeur" : "mineur";
                    message = "Bonjour " + firstName + " " + lastName + " tu as " + strAge + " ans et tu es "+ sentenceIfIsAdult;
                    new SecondFrame(this,message);
                } catch (NumberFormatException nfe){
                    message ="L'age saisi n'est pas bon et doit être en chiffre.";
                    typeOfIcon = JOptionPane.WARNING_MESSAGE;
                    tfAge.setText("");
                    JOptionPane.showMessageDialog(this,message,"", typeOfIcon);
                }
            } else {
                typeOfIcon = JOptionPane.WARNING_MESSAGE;
                message = "Il faut rempli tous les champs";
                JOptionPane.showMessageDialog(this,message,"", typeOfIcon);
            }
        });

        //gridPanel.setLayout(new GridLayout(3,2));
        mainPanel.setLayout(new BorderLayout());
        //gridPanel.setBackground(Color.cyan);

        customPanel.add(new JLabel("Nom :"));
        customPanel.add(tfLastName);
        customPanel.add(new JLabel("Prénom :"));
        customPanel.add(tfFirstName);
        customPanel.add(new JLabel("Age :"));
        customPanel.add(tfAge);

        //formPanel.add(gridPanel);
        formPanel.add(customPanel);
        titlePanel.add(jlTitle);
        btnPanel.add(btn);

        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        setVisible(true);

    }

}

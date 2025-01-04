import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {

    public CustomPanel(){
        super();
        setBackground(Color.green);
    }
    public CustomPanel(Color color){
        super();
        setBackground(color);
    }

    public CustomPanel(LayoutManager layout, Color color){
        super(layout);
        setBackground(color);
    }
}

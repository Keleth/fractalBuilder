import javax.swing.*;
import java.awt.*;

/**
 * Created by Keleth on 01.11.14.
 */
public class SnowflakeHelp extends JPanel{

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font("Serif", Font.PLAIN, 36);
        g2.setFont(font);
        g2.drawString("Баловался: D.Yu.Shkerin, 2014", 50, 90);
        g2.drawString("пример вызова: -count 10 -angle 0", 20, 90);
    }
}

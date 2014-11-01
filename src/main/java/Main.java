import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 * Created by Keleth on 01.11.14.
 */
public class Main {

    public static int width = 800, height = 600;

    public static void main(String[] args) {

        final JFrame frm = new JFrame("Кривая Коха");
        frm.setSize(width, height);

        int count = 10;
        int angle = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-help") || args[i].equals("/?") || args[i].equals("--help")) {
                frm.getContentPane().add(new SnowflakeHelp());
                break;
            }

            if (args[i].equals("-count")) {
                try {
                    count = Integer.parseInt(args[i + 1]);
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                    System.exit(1);
                }
            }

            if (args[i].equals("-angle")) {
                try {
                    angle = Integer.parseInt(args[i + 1]);
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                    System.exit(1);
                }
            }
        }

        Snowflake sn = new Snowflake();
        sn.setCount(count);
        sn.setAngle(angle);
        frm.add(sn);

        frm.setVisible(true);
        frm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frm.dispose();
            }
        });

    }
}

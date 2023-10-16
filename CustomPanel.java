import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class CustomPanel extends JPanel {
    private Point2D p1; 
    private Point2D p2;
    private final int STEP = 10;
    private final int C = 10;

    @Override public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        var w = getWidth();
        var h = getHeight();
        var cc4 = C*C/4;
        for (var y = 0; y < h; y += STEP)
        {
            for (var x = 0; x < w; x += STEP)
            {
                var d1 = p1.distance(x, y);
                var d2 = p2.distance(x, y);
                var d = cc4 - d1*d2;
                if (d > 0)
                {
                    g.fillRect(x, y, STEP, STEP);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Panel Example");
            CustomPanel customPanel = new CustomPanel();

            // Set the values of p1 and p2 appropriately
            customPanel.p1 = new Point2D.Double(100, 100); // Example values, adjust as needed
            customPanel.p2 = new Point2D.Double(300, 300); // Example values, adjust as needed

            frame.add(customPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }

}



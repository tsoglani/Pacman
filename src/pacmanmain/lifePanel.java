package pacmanmain;

import java.awt.*;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gaitanesnikos
 */
public class lifePanel extends JPanel {

    private Image im;
    private final PacManFrame frame;
    static int lives = 3;
    private int livess;
    private final PacManPanel[][] pacPointer;

    public lifePanel(PacManFrame f, PacManPanel[][] pacPointer) {
        frame = f;
        this.add(new JPanel());
        this.repaint();
        this.pacPointer = pacPointer;
    }

    public void paint(Graphics g) {
        super.paint(g);
        im = getToolkit().getImage("heart.png");
        super.paintComponent(g);
        g.drawString("LIFES:", 0, 10);
        for (int i = 0; i < lives; i++) {
            g.drawImage(im, (i + 1) * 100, 0, this);

        }
        if (lives <= 0) {
            g.clearRect(0, 0, 1700, 1700);
            super.paint(g);
            Font f = new Font("Arial", Font.BOLD, 100);
            g.setFont(f);
            g.drawString("GAMEOVER", 500, 400);

            frame.getEnemy().stop();
            frame.getEnemy1().stop();
            frame.getEnemy2().stop();
            frame.getEnemy3().stop();
            // frame.pacThread.stop();
            frame.remove(frame.getPanelCentral());

            frame.add(this, BorderLayout.CENTER);

            frame.changeSize();

        }

    }

}

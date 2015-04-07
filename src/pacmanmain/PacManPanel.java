/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanmain;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author gaitanesnikos
 */
public class PacManPanel extends JPanel {

    private int row;
    private boolean imPacIsHere = false;
    private boolean goPacRight = false;
    private Image enemyIm = getToolkit().getImage("enemy1.png");
    private boolean goPacLeft = false;
    private boolean goPacUp = false;
    private boolean goPacDown = false;
    private int column;
    private boolean drawDiner = true;
    private boolean isAnEnemyHere = false;
    private Image pacImageDown;
    private Image pacImageRight;
    private Image pacImageLeft;
    private Image pacImageUp;

    public boolean isDrawDiner() {
        return drawDiner;
    }

    public void setDrawDiner(boolean drawDiner) {
        this.drawDiner = drawDiner;
    }

    public boolean isIsAnEnemyHere() {
        return isAnEnemyHere;
    }

    public void setIsAnEnemyHere(boolean isAnEnemyHere) {
        this.isAnEnemyHere = isAnEnemyHere;
    }

    public boolean isGoPacDown() {
        return goPacDown;
    }

    public void setGoPacDown(boolean goPacDown) {
        this.goPacDown = goPacDown;
    }

    public boolean isGoPacLeft() {
        return goPacLeft;
    }

    public void setGoPacLeft(boolean goPacLeft) {
        this.goPacLeft = goPacLeft;
    }

    public boolean isGoPacRight() {
        return goPacRight;
    }

    public void setGoPacRight(boolean goPacRight) {
        this.goPacRight = goPacRight;
    }

    /**
     *
     * @return
     */
    public boolean isGoPacUp() {
        return goPacUp;
    }

    /**
     *
     * @param goPacUp
     */
    public void setGoPacUp(boolean goPacUp) {
        this.goPacUp = goPacUp;
    }

    /**
     *
     * @return
     */
    public boolean isImPacIsHere() {
        return imPacIsHere;
    }

    /**
     *
     * @param imPacIsHere
     */
    public void setImPacIsHere(boolean imPacIsHere) {
        this.imPacIsHere = imPacIsHere;
    }

    /**
     *
     * @param row
     * @param colum
     */
    public PacManPanel(int row, int colum) {

        pacImageDown = getToolkit().getImage("pacManDown.png");
        pacImageRight = getToolkit().getImage("pacManRight.png");
        pacImageUp = getToolkit().getImage("pacManUp.png");
        pacImageLeft = getToolkit().getImage("pacManLeft.png");
        this.row = row;
        this.column = colum;
        //setBorder(BorderFactory.createLineBorder(Color.yellow));
    }

    /**
     *
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imPacIsHere) {
            if (goPacDown) {
                g.drawImage(pacImageDown, 0, 0, this);
            } else if (goPacUp) {
                g.drawImage(pacImageUp, 0, 0, this);
            } else if (goPacRight) {
                g.drawImage(pacImageRight, 0, 0, this);
            } else if (goPacLeft) {
                g.drawImage(pacImageLeft, 0, 0, this);
            }
        }
        if (drawDiner && this.getBackground() != Color.black) {

            g.fillRoundRect(25, 25, 5, 5, 5, 5);

        }
        if (isAnEnemyHere) {
            g.drawImage(enemyIm, 0, 0, this);
            //g.drawString("Enemy", 10, 10);
        }

    }

}

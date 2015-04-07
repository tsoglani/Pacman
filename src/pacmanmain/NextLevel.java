package pacmanmain;

import java.awt.*;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author gaitanesnikos
 */
public class NextLevel extends Thread {

    private int score = 0;
    private int food = 0;
    private PacManPanel[][] pacPointer;
    private PacManFrame frame;
    private JLabel labelScore;
    private int remainFood;

    public NextLevel(PacManPanel[][] pacPointer, PacManFrame frame) {
        this.frame = frame;
        this.pacPointer = pacPointer;
        labelScore = new JLabel();
        countStartingFood();
        labelScore.setBackground(Color.red);
        labelScore.setForeground(Color.blue);
        frame.getStartPanel().add(labelScore);

    }

    public void countStartingFood() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (pacPointer[i][j].isDrawDiner()) {
                    food = food + 1;
                }

            }
        }

    }

    public void countScore() {

        remainFood = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (pacPointer[i][j].isDrawDiner()) {
                    remainFood = remainFood + 1;
                }

            }

        }

        score = (food - remainFood) * 10;

    }

    public void nextLevel() {

        frame.startPossition();

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                pacPointer[i][j].setDrawDiner(true);
                frame.makeStage();
            }
        }

    }

    public void run() {
        while (true) {

            countScore();

            labelScore.setText("Score: " + Integer.toString(score));

            if (remainFood == 0) {
                nextLevel();

            }

        }

    }
}

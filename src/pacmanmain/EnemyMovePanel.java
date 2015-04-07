/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanmain;

import java.awt.Color;
import java.util.*;

/**
 *
 * @author gaitanesnikos
 */
public class EnemyMovePanel extends Thread {

    private Random random = new Random();
    private int row;
    private int column;
    private PacManPanel[][] pacPointer = new PacManPanel[16][16];
    private int randInt = 10;
    private int randintCheck = 20;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void aa() {

    }

    public EnemyMovePanel(PacManPanel[][] pacPointer, int x, int y, lifePanel life, PacManFrame frame) {

        this.row = x;
        this.column = y;
        this.pacPointer = pacPointer;
        pacPointer[row][column].setIsAnEnemyHere(true);

    }

    public void run() {
        try {
            this.sleep(1000);
        } catch (InterruptedException ex) {

        }
        while (true) {
            try {

                this.sleep(100);

                //  randintCheck=randInt
                randInt = random.nextInt(2);
                if (randInt == 0) {
                    goToTHePacManUp();
                    goToTHePacManDown();
                } else {
                    goToTHePacManLeft();
                    goToTHePacManRight();
                }

                //       doNotGoBack();
                //     checkTheLimits(); 
                //    checkToGo(randInt);
                //    randintCheck= randInt;
                //randInt  = randintCheck;
            } catch (InterruptedException ex) {
            } catch (Exception ex) {
            }

        }
    }

    public void goToTHePacManUp() {
        if (row == 6 && column == 8) {
            goToTHePacManDown();
            return;
        }

        if (row == 7 && column == 8) {
            goToTHePacManRight();
            goToTHePacManLeft();
            return;
        }
        if (row - 1 > 0 && pacPointer[row - 1][column].getBackground() == Color.black) {
            return;
        } else if (row > PacThread.row && row > 0) {

            pacPointer[row][column].setIsAnEnemyHere(false);
            row = row - 1;
            if (pacPointer[row][column].isIsAnEnemyHere()) {
                row = row + 1;
            }

            pacPointer[row][column].setIsAnEnemyHere(true);

        }
    }

    public void goToTHePacManDown() {
        if (pacPointer[row + 1][column].getBackground() == Color.black) {
            return;
        }
        if (row + 1 < 16 && pacPointer[row + 1][column].getBackground() == Color.black) {
            return;

        } else if (row < PacThread.row && row < 16) {

            pacPointer[row][column].setIsAnEnemyHere(false);

            row = row + 1;
            if (pacPointer[row][column].isIsAnEnemyHere()) {
                row = row - 1;
            }
            pacPointer[row][column].setIsAnEnemyHere(true);

        }
    }

    public void goToTHePacManRight() {

        if (column + 1 < 16 && pacPointer[row][column + 1].getBackground() == Color.black) {
            return;

        } else if (column < PacThread.column && column < 16) {
            pacPointer[row][column].setIsAnEnemyHere(false);
            column = column + 1;
            if (pacPointer[row][column].isIsAnEnemyHere()) {
                column = column - 1;
            }
            pacPointer[row][column].setIsAnEnemyHere(true);

        }

    }

    public void goToTHePacManLeft() {

        if (column - 1 > 0 && pacPointer[row][column - 1].getBackground() == Color.black) {
            return;

        } else if (column > PacThread.column && column > 0) {
            pacPointer[row][column].setIsAnEnemyHere(false);
            column = column - 1;
            if (pacPointer[row][column].isIsAnEnemyHere()) {
                column = column + 1;
            }
            pacPointer[row][column].setIsAnEnemyHere(true);

        }
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public PacManPanel[][] getPacPointer() {
        return pacPointer;
    }

    public void setPacPointer(PacManPanel[][] pacPointer) {
        this.pacPointer = pacPointer;
    }

    public int getRandInt() {
        return randInt;
    }

    public void setRandInt(int randInt) {
        this.randInt = randInt;
    }

    public int getRandintCheck() {
        return randintCheck;
    }

    public void setRandintCheck(int randintCheck) {
        this.randintCheck = randintCheck;
    }

}

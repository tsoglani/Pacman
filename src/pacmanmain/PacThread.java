/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanmain;

import java.awt.Color;

/**
 *
 * @author gaitanesnikos
 */
public class PacThread extends Thread {

    private PacManPanel[][] pacPointer = new PacManPanel[16][16];
    static int row, column;
    private String goWhere;
    private String goWhereChech;
    private lifePanel life;
    private EnemyMovePanel enemy1;
    private EnemyMovePanel enemy2;
    private EnemyMovePanel enemy3;
    private EnemyMovePanel enemy4;
    private PacManFrame frame;

    public PacThread() {
    }

    /**
     *
     * @param pacPointer
     * @param row
     * @param column
     * @param goWhere
     * @param pac
     * @param life
     * @param enemy
     * @param enemy2
     * @param enemy3
     * @param enemy4
     */
    public PacThread(PacManPanel[][] pacPointer, int row, int column, String goWhere, PacManFrame pac, lifePanel life, EnemyMovePanel enemy, EnemyMovePanel enemy2, EnemyMovePanel enemy3, EnemyMovePanel enemy4) {
        this.goWhere = goWhere;
        this.pacPointer = pacPointer;
        this.row = row;
        this.column = column;
        this.frame = pac;
        this.goWhereChech = goWhere;
        this.life = life;
        this.enemy1 = enemy;
        this.enemy2 = enemy2;
        this.enemy3 = enemy3;
        this.enemy4 = enemy4;
    }

    /**
     *
     */
    public void repaintall() {

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                {

                    pacPointer[i][j].repaint();
                }

            }
        }

    }

    /**
     *
     * @param enemy
     * @param enemy2
     * @param enemy3
     * @param enemy4
     */
    public void changeEnemys(EnemyMovePanel enemy, EnemyMovePanel enemy2, EnemyMovePanel enemy3, EnemyMovePanel enemy4) {
        this.enemy1 = enemy;
        this.enemy2 = enemy2;
        this.enemy3 = enemy3;
        this.enemy4 = enemy4;

    }

    /**
     *
     */
    public void checkForLooseLives() {

        if (PacThread.row == enemy1.getRow() && PacThread.column == enemy1.getColumn() || PacThread.row == enemy2.getRow() && PacThread.column == enemy2.getColumn() || PacThread.row == enemy3.getRow() && PacThread.column == enemy3.getColumn() || PacThread.row == enemy4.getRow() && PacThread.column == enemy4.getColumn()) {
            lifePanel.lives = lifePanel.lives - 1;
            frame.startPossition();
            life.repaint();

        }

    }

    public String getGoWhere() {
        return goWhere;
    }

    public void setGoWhere(String goWhere) {
        try {
            this.goWhereChech = goWhere;
            if (goWhere.equals("up") && pacPointer[row - 1][column].getBackground() != Color.black) {
                this.goWhere = goWhere;
            }

            if (goWhere.equals("down") && pacPointer[row + 1][column].getBackground() != Color.black) {
                this.goWhere = goWhere;
            }

            if (goWhere.equals("right") && pacPointer[row][column + 1].getBackground() != Color.black) {
                this.goWhere = goWhere;
            }

            if (goWhere.equals("left") && pacPointer[row][column - 1].getBackground() != Color.black) {
                this.goWhere = goWhere;
            }
        } catch (Exception e) {
        }

    }

    public synchronized void run() {
        while (true) {

            try {
                checkForLooseLives();
                this.sleep(100);
                if (goWhere.equals("up") && row > 0 && pacPointer[row - 1][column].getBackground() != Color.black) {
                    //     pacPointer[row][column].setDrawDiner(false);
                    pacPointer[row][column].setImPacIsHere(false);
                    pacPointer[row][column].setGoPacDown(false);
                    pacPointer[row][column].setGoPacUp(false);
                    pacPointer[row][column].setGoPacRight(false);
                    pacPointer[row][column].setGoPacLeft(false);
                    pacPointer[row - 1][column].setImPacIsHere(true);
                    pacPointer[row - 1][column].setGoPacDown(false);
                    pacPointer[row - 1][column].setGoPacUp(true);
                    pacPointer[row - 1][column].setGoPacRight(false);
                    pacPointer[row - 1][column].setGoPacLeft(false);
                    pacPointer[row][column].repaint();
                    row = row - 1;
                    pacPointer[row][column].repaint();
                } else if (goWhere.equals("down") && row < 16 && pacPointer[row + 1][column].getBackground() != Color.black) {
                    //           pacPointer[row][column].setDrawDiner(false);
                    pacPointer[row][column].setImPacIsHere(false);
                    pacPointer[row][column].setGoPacRight(false);
                    pacPointer[row][column].setGoPacLeft(false);
                    pacPointer[row][column].setGoPacUp(false);
                    pacPointer[row][column].setGoPacDown(false);
                    pacPointer[row + 1][column].setImPacIsHere(true);
                    pacPointer[row + 1][column].setGoPacDown(true);
                    pacPointer[row][column].repaint();
                    row = row + 1;
                    pacPointer[row][column].repaint();
                } else if (goWhere.equals("right") && column < 16 && pacPointer[row][column + 1].getBackground() != Color.black) {
                    //    pacPointer[row][column].setDrawDiner(false);
                    pacPointer[row][column].setImPacIsHere(false);
                    pacPointer[row][column].setGoPacRight(false);
                    pacPointer[row][column].setGoPacLeft(false);
                    pacPointer[row][column].setGoPacUp(false);
                    pacPointer[row][column].setGoPacDown(false);
                    pacPointer[row][column + 1].setImPacIsHere(true);
                    pacPointer[row][column + 1].setGoPacRight(true);
                    pacPointer[row][column].repaint();
                    column = column + 1;
                    pacPointer[row][column].repaint();

                } else if (goWhere.equals("left") && column > 0 && column < 16 && pacPointer[row][column - 1].getBackground() != Color.black) {
                    //         pacPointer[row][column].setDrawDiner(false);
                    pacPointer[row][column].setImPacIsHere(false);
                    pacPointer[row][column].setGoPacRight(false);
                    pacPointer[row][column].setGoPacLeft(false);
                    pacPointer[row][column].setGoPacUp(false);
                    pacPointer[row][column].setGoPacDown(false);
                    pacPointer[row][column - 1].setImPacIsHere(true);
                    pacPointer[row][column - 1].setGoPacLeft(true);
                    pacPointer[row][column].repaint();
                    column = column - 1;
                    pacPointer[row][column].repaint();

                }
                pacPointer[row][column].setDrawDiner(false);

                if (this.goWhereChech.equals("up") && pacPointer[row - 1][column].getBackground() != Color.black) {
                    this.goWhere = this.goWhereChech;
                }

                if (goWhereChech.equals("down") && pacPointer[row + 1][column].getBackground() != Color.black) {
                    this.goWhere = goWhereChech;
                }

                if (goWhereChech.equals("right") && pacPointer[row][column + 1].getBackground() != Color.black) {
                    this.goWhere = goWhereChech;
                }

                if (goWhereChech.equals("left") && pacPointer[row][column - 1].getBackground() != Color.black) {
                    this.goWhere = goWhereChech;
                }

            } catch (InterruptedException ex) {
            } catch (Exception ex) {
            }
            this.repaintall();
        }

    }
}

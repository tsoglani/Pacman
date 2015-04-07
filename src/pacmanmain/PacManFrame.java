/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanmain;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author gaitanesnikos
 */
public class PacManFrame extends JFrame {

    private JPanel StartPanel;
    private lifePanel lifepan;
    private EnemyMovePanel enemy;
    private EnemyMovePanel enemy1;
    private NextLevel levelThread;
    private EnemyMovePanel enemy2;
    private EnemyMovePanel enemy3;
    private JPanel panelCentral = new JPanel();
    private PacManPanel[][] pacPointer = new PacManPanel[16][16];
    private int x = 10, y = 10;
    private boolean firstTime = true;
    private PacThread pacThread;

    public JPanel getPanelCentral() {
        return panelCentral;
    }

    public JPanel getStartPanel() {
        return StartPanel;
    }

    public void setStartPanel(JPanel StartPanel) {
        this.StartPanel = StartPanel;
    }

    public void setPanelCentral(JPanel panelCentral) {
        this.panelCentral = panelCentral;
    }

    public PacManFrame() {

        StartPanel = new JPanel();
        StartPanel.setLayout(new GridLayout(1, 2));
        panelCentral.setLayout(new GridLayout(16, 16));
        this.setSize(1700, 1700);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.addKeyListener(key);
        lifepan = new lifePanel(this, pacPointer);
        lifepan.setSize(300, 300);
        StartPanel.add(lifepan);
        this.add(StartPanel, BorderLayout.PAGE_START);
//pacThread= new PacThread();
        PacThread.row = 10;
        PacThread.column = 10;
        x = PacThread.row;
        y = PacThread.column;

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {

                PacManPanel pacPanel = new PacManPanel(i, j);
                pacPointer[i][j] = pacPanel;
                panelCentral.add(pacPanel);

            }
        }

        this.add(panelCentral, BorderLayout.CENTER);
        pacPointer[y][x].setImPacIsHere(true);
        pacPointer[x][y].setGoPacRight(true);
        makeStage();
        enemy = new EnemyMovePanel(pacPointer, 5, 9, lifepan, this);

        enemy2 = new EnemyMovePanel(pacPointer, 5, 8, lifepan, this);

        enemy3 = new EnemyMovePanel(pacPointer, 5, 6, lifepan, this);
        enemy1 = new EnemyMovePanel(pacPointer, 5, 7, lifepan, this);
        pacThread = new PacThread(pacPointer, x, y, "right", this, lifepan, enemy, enemy1, enemy2, enemy3);

        levelThread = new NextLevel(pacPointer, this);
        levelThread.start();
    }

    public lifePanel getLifepan() {
        return lifepan;
    }

    public void setLifepan(lifePanel lifepan) {
        this.lifepan = lifepan;
    }

    public void changeSize() {
        this.setSize(1600, 1600);

    }

    public void startPossition() {

        pacPointer[enemy.getRow()][enemy.getColumn()].setIsAnEnemyHere(false);
        pacPointer[enemy1.getRow()][enemy1.getColumn()].setIsAnEnemyHere(false);
        pacPointer[enemy2.getRow()][enemy2.getColumn()].setIsAnEnemyHere(false);
        pacPointer[enemy3.getRow()][enemy3.getColumn()].setIsAnEnemyHere(false);
        pacPointer[PacThread.row][PacThread.column].setImPacIsHere(false);
        if (enemy != null && enemy2 != null && enemy3 != null && enemy1 != null) {
//            enemy.stop();
//            enemy1.stop();
//            enemy2.stop();
//            enemy3.stop();
//            enemy.setRow(-1);
//             enemy1.setRow(-1);
//              enemy2.setRow(-1);
//               enemy3.setRow(-1);
//             
//            
            enemy.setRow(-2);
            enemy.setColumn(9);
            enemy1.setRow(-1);
            enemy1.setColumn(7);
            enemy2.setRow(-1);
            enemy2.setColumn(8);
            enemy3.setRow(-1);
            enemy3.setColumn(6);
        }

        enemy = new EnemyMovePanel(pacPointer, 5, 9, lifepan, this);
        enemy.start();
        enemy2 = new EnemyMovePanel(pacPointer, 5, 8, lifepan, this);
        enemy2.start();
        enemy3 = new EnemyMovePanel(pacPointer, 5, 6, lifepan, this);
        enemy3.start();
        enemy1 = new EnemyMovePanel(pacPointer, 5, 7, lifepan, this);
        enemy1.start();
//          pacPointer[5][9].setIsAnEnemyHere(true);
//     pacPointer[5][8].setIsAnEnemyHere(true);
//     pacPointer[5][6].setIsAnEnemyHere(true);
//     pacPointer[5][7].setIsAnEnemyHere(true);

//enemy.setRow(5);enemy.setColumn(9); 
//enemy1.setRow(5);enemy1.setColumn(7);
//    enemy2.setRow(5);enemy2.setColumn(8);
//    enemy3.setRow(5);enemy3.setColumn(6);
        pacThread.changeEnemys(enemy1, enemy2, enemy3, enemy);
        PacThread.row = 10;
        PacThread.column = 10;
        pacPointer[PacThread.row][PacThread.column].setImPacIsHere(true);

    }

    public void makeStage() {
        pacPointer[6][6].setBackground(Color.black);
        pacPointer[6][7].setBackground(Color.black);
        pacPointer[4][8].setBackground(Color.black);
        pacPointer[6][9].setBackground(Color.black);
        pacPointer[6][5].setBackground(Color.black);
        pacPointer[6][10].setBackground(Color.black);
        pacPointer[5][5].setBackground(Color.black);
        pacPointer[5][10].setBackground(Color.black);
        pacPointer[4][10].setBackground(Color.black);
        pacPointer[4][5].setBackground(Color.black);
        pacPointer[4][9].setBackground(Color.black);
        pacPointer[4][6].setBackground(Color.black);
        pacPointer[4][7].setBackground(Color.black);

        pacPointer[6][8].setDrawDiner(false);
        pacPointer[4][8].setDrawDiner(false);
        pacPointer[5][8].setDrawDiner(false);
        pacPointer[5][7].setDrawDiner(false);
        pacPointer[5][6].setDrawDiner(false);
        pacPointer[5][9].setDrawDiner(false);
    }
    KeyListener key = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (firstTime) {
                enemy.start();
                enemy2.start();
                enemy3.start();
                pacThread.start();
                enemy1.start();
                firstTime = false;

            }

//                  System.out.println(x);
//                  System.out.println(y);
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {

                pacThread.setGoWhere("down");

            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {

                pacThread.setGoWhere("up");

            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                pacThread.setGoWhere("right");

            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                pacThread.setGoWhere("left");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };

    public EnemyMovePanel getEnemy() {
        return enemy;
    }

    public void setEnemy(EnemyMovePanel enemy) {
        this.enemy = enemy;
    }

    public EnemyMovePanel getEnemy1() {
        return enemy1;
    }

    public void setEnemy1(EnemyMovePanel enemy1) {
        this.enemy1 = enemy1;
    }

    public NextLevel getLevelThread() {
        return levelThread;
    }

    public void setLevelThread(NextLevel levelThread) {
        this.levelThread = levelThread;
    }

    public EnemyMovePanel getEnemy2() {
        return enemy2;
    }

    public void setEnemy2(EnemyMovePanel enemy2) {
        this.enemy2 = enemy2;
    }

    public EnemyMovePanel getEnemy3() {
        return enemy3;
    }

    public void setEnemy3(EnemyMovePanel enemy3) {
        this.enemy3 = enemy3;
    }

    public PacManPanel[][] getPacPointer() {
        return pacPointer;
    }

    public void setPacPointer(PacManPanel[][] pacPointer) {
        this.pacPointer = pacPointer;
    }

    public boolean isFirstTime() {
        return firstTime;
    }

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }

    public PacThread getPacThread() {
        return pacThread;
    }

    public void setPacThread(PacThread pacThread) {
        this.pacThread = pacThread;
    }

    public KeyListener getKey() {
        return key;
    }

    public void setKey(KeyListener key) {
        this.key = key;
    }

}

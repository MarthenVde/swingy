package com.marthenvde.swingy.view;

import com.marthenvde.swingy.model.Map;
import com.marthenvde.swingy.model.characters.Hero;
import com.marthenvde.swingy.model.artifact.Artifact;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import com.marthenvde.swingy.model.artifact.Helmet;
import com.marthenvde.swingy.model.artifact.Armor;

public class GuiView implements Renderer {
    private final JFrame mapFrame;
    private final JSplitPane splitPane;
    private final JPanel topPanel;
    private final JPanel bottomPanel;
    private final JScrollPane scrollPane;
    private final JTextArea outputBox;
    private final JPanel inputPanel;
    private final JPanel infoPanel;
    private final JPanel grid;
    public static JButton submitBtn = new JButton();
    public static JTextField inputField = new JTextField();
    
    private void writeOutputBox(String message) {
        this.outputBox.append(message + "\n");
        this.outputBox.setCaretPosition(this.outputBox.getDocument().getLength());
    }

    public GuiView() {
        this.mapFrame = new JFrame();
        this.splitPane = new JSplitPane();
        this.topPanel = new JPanel();
        this.bottomPanel = new JPanel();
        this.scrollPane = new JScrollPane();
        this.outputBox = new JTextArea();
        this.inputPanel = new JPanel();
        this.infoPanel = new JPanel();
        this.grid = new JPanel();

        this.mapFrame.setPreferredSize(new Dimension(400, 400));
        this.mapFrame.setResizable(false);
        this.mapFrame.getContentPane().setLayout(new GridLayout());
        this.mapFrame.getContentPane().add(splitPane);
        this.mapFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        this.splitPane.setDividerLocation(250);
        this.splitPane.setTopComponent(topPanel);
        this.splitPane.setBottomComponent(bottomPanel);
        this.topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        this.topPanel.add(grid);
        this.topPanel.add(infoPanel);

        this.bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        this.bottomPanel.add(scrollPane);
        this.outputBox.setEditable(false);
        this.scrollPane.setViewportView(outputBox);
        this.bottomPanel.add(inputPanel);

        this.inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
        this.inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));

        GuiView.submitBtn.setText("Enter");
        this.inputPanel.add(inputField);
        this.inputPanel.add(GuiView.submitBtn);

        GuiView.submitBtn.setAction(new AbstractAction(){
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                synchronized (submitBtn) {
                    submitBtn.notify();
                }
            }
        });

        this.mapFrame.pack();
        this.mapFrame.setVisible(true);
    }

    public void drawMessage(String message) {
        writeOutputBox(message);
    }

    public void drawArtifactPickup(Artifact artifact) {
        String type;

        if (artifact instanceof Helmet)
            type = "a helmet";
        else if (artifact instanceof Armor)
            type = "armor";
        else
            type = "a weapon";

        writeOutputBox("You found " + type +  " with power " + artifact.getPower() + "\nequip artifact? (Y/N)");
    }

    public void drawTile(boolean visited) {

    }

    private void drawInfoPanel(Hero hero) {
        this.infoPanel.removeAll();

        this.infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        this.infoPanel.add(new JLabel("Name: " + hero.getName()));
        this.infoPanel.add(new JLabel("Class: " + hero.getCharClass()));
        this.infoPanel.add(new JLabel("Xp: " + hero.getXp()));
        this.infoPanel.add(new JLabel("Level: " + hero.getLevel()));
        this.infoPanel.add(new JLabel("Hp: " + hero.getHp()));
        this.infoPanel.add(new JLabel("Attack: " + hero.getAttack()));
        this.infoPanel.add(new JLabel("Defense: " + hero.getDefense()));
        this.infoPanel.add(new JLabel("Helmet: " + ((hero.getHelmet() != null) ? hero.getHelmet().getPower() : "None")));
        this.infoPanel.add(new JLabel("Armor: " + ((hero.getArmor() != null) ? hero.getArmor().getPower() : "None")));
        this.infoPanel.add(new JLabel("Weapon: " + ((hero.getWeapon() != null) ? hero.getWeapon().getPower() : "None")));
        this.infoPanel.revalidate();
    }

    public void drawMap(Map map) {
        Object[][] grid = map.getGrid();
        int rows = grid.length;
        int cols = grid[0].length;
        JLabel tile;

        this.grid.removeAll();
        this.grid.setLayout(new GridLayout(rows, cols, 1, 1));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] instanceof Hero) {
                    tile = new JLabel(String.valueOf("\u263A"));
                    tile.setForeground(Color.blue);
                } else {
                    tile = new JLabel(String.valueOf("\u2588"));
                    tile.setForeground(Color.red);
                }
                this.grid.add(tile);
            }
        }
        this.drawInfoPanel(map.getPlayer());
        this.grid.revalidate();
        this.infoPanel.revalidate();
        this.infoPanel.repaint();
        this.mapFrame.repaint();
    }

    public void drawPlayer() {
    }

    public void drawMonster() {
    }

    public void drawSelectionSceen(ArrayList<Hero> heroes) {
        writeOutputBox("- Saved Heroes -");
        int i = 1;

        for (Hero hero : heroes) {
            writeOutputBox(i + ". name: " + hero.getName() + " lvl: " + hero.getLevel());
            i++;
        }
    }

    public void drawCharacterOptionScreen() {
        writeOutputBox("- Load previous character? (Y/N) -");
    }

    public void drawStartup() {
        writeOutputBox("--- Starting Swingy ---");
    }

    public void drawEndScreen(boolean won) {
        writeOutputBox("  ////////////////////////////");
        if (won == true) {
            writeOutputBox(" //        YOU WON!!!     ///");
        } else {
            writeOutputBox("//        YOU LOST :(    ///");
        }
        writeOutputBox("////////////////////////////");
    }

    public void drawCharacterCreationScreen() {
        writeOutputBox("- Please select a character type -"
                       + "\n1. Knight\n2. Barbarian\n3. Paladin\n4. Mage\n5. Assassin");
    }

    public void drawContinueScreen() {
        writeOutputBox("Want to continue playing? (Y/N): ");
    }

    public void drawEnemyEncounterOption() {
        writeOutputBox("You encountered a monster!\n1. run\n2. Fight");
    }

    public void drawEscape(boolean escaped) {
        if (escaped == true) {
            writeOutputBox("You succesfully returned to your previous position!");
        } else {
            writeOutputBox("You failed to escape!");
        }
    }

    public void drawVictory(String name, String type) {
        writeOutputBox("You won against " + name + " the " + type);
    }
}

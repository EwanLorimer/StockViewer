package com.company;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
//Creates the menu bar which allows us to switch between portfolio and market pages
public class GUI extends JFrame implements ActionListener {
    //Use Swing to create a front end for the user
    JMenuItem marketMenu; JMenuItem portfolioMenu;
    JMenuItem marketItem; JMenuItem portfolioItem;

    public GUI(){
        //Constructor to be used
        JMenuBar menuBar = new JMenuBar();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.setLayout(new FlowLayout());
        marketMenu = new JMenuItem("Market");
        menuBar.add(marketMenu);

        marketMenu.addActionListener(this);

        portfolioMenu = new JMenuItem("Portfolio");
        menuBar.add(portfolioMenu);
        portfolioMenu.addActionListener(this);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == marketMenu){
            MarketPage marketGUI = new MarketPage();
        }

        else if(e.getSource() == portfolioMenu){
            portfolioPage portfolioGUI = new portfolioPage();
        }
    }

    public static void main(String[] args) {
        GUI run = new GUI();
    }
}

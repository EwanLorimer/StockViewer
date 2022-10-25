package com.company;

import javax.swing.*;
import java.awt.*;

public class MarketPage{

    public MarketPage(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        frame.setSize(720, 576);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Stock Viewer");
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MarketPage testGUI = new MarketPage();

    }

}

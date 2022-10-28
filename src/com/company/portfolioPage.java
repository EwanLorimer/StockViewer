package com.company;

import javax.swing.*;
import java.awt.*;

public class portfolioPage extends GUI{

    public portfolioPage(){
        GUI run = new GUI();
        this.setSize(1920, 1080);
        this.setVisible(true);

        JLabel wip = new JLabel();
        wip.setText("Work in progress");
        this.add(wip);
    }


}


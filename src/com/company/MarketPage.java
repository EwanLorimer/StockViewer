package com.company;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class MarketPage extends GUI implements ActionListener{
    JPanel infoPanel;
    JTextField stockSearcher;
    JButton stockSearchButton;

    public MarketPage(){
        GUI userInterface = new GUI();

        //infoPanel = new JPanel();
        stockSearcher = new JTextField(20);
        stockSearchButton = new JButton("Search");
        stockSearchButton.addActionListener(this);

        this.add(stockSearcher);
        this.add(stockSearchButton);

        //this.getContentPane().add(infoPanel);
        this.setSize(300, 300);
        this.setVisible(true);

        this.setLayout(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == marketMenu){
            MarketPage marketGUI = new MarketPage();
        }

        else if(e.getSource() == portfolioMenu){
            portfolioPage portfolioGUI = new portfolioPage();
        }
        else if(e.getSource() == stockSearchButton){
            String stock = stockSearcher.getText();
            try {
                stockInfoRetriever retriever = new stockInfoRetriever(stock);
                String price = retriever.returnPrice();
                String dividendYield = retriever.returnDividendYield();
                String dividendYieldPercentage = retriever.returnDividendYieldPercentage();
                String priceToEarnings = retriever.returnPERatio();
                String listedExchange = retriever.returnStockExchange();

                JOptionPane.showMessageDialog(null, " Price: " + price +
                        "\n Dividend Yield: " + dividendYield +
                        "\n Dividend Yield Percentage: " + dividendYieldPercentage +
                        "\n PE Ratio: " + priceToEarnings +
                        "\n Exchange: " + listedExchange);

            }
            catch (IOException ioException) {
                System.out.println("Coulnd't find stock");
            }
            catch (NullPointerException nullPointerException){
                JOptionPane.showMessageDialog(null,"Stock couldn't be found, try again");
            }
        }
    }
}

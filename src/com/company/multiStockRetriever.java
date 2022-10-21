package com.company;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.Map;

//Retrieves stock info for multiple stocks
public class multiStockRetriever {
    private Stock stocks;
    String[] stockArray;

    //Constructor - create map of multiple stocks to allow system to search multiple stocks at once
    public multiStockRetriever(String[] inputtedStocks)throws IOException{
        stockArray = inputtedStocks;
        Map<String, Stock> stocks = YahooFinance.get(stockArray);
    }

}

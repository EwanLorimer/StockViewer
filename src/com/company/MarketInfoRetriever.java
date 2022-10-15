package com.company;

import yahoofinance.*;
import yahoofinance.histquotes.HistoricalQuote;

//IOException must be thrown in case information cannot be retrieved, it won't break the program if info is not retrieved
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class MarketInfoRetriever {
    //Use YahooFinance API to retrieve real time market data
    private final String ticker;
    private Stock stock;

    public MarketInfoRetriever(String symbol) throws IOException {
        //Constructor - will instantiate with the symbol of the stock and then will use the API to retrieve stock info
        ticker = symbol;
        stock = YahooFinance.get(symbol);
    }

    public String returnTicker(){
        return ticker;
    }

    public BigDecimal returnPrice() throws IOException {

        BigDecimal price = stock.getQuote().getPrice();
        return price;
    }

    public BigDecimal returnDividendYield() throws IOException{
        BigDecimal dividendYield = stock.getDividend().getAnnualYield();
        return dividendYield;
    }

    public BigDecimal returnDividendYieldPercentage() throws IOException{
        BigDecimal dividendYieldPercentage = stock.getDividend().getAnnualYieldPercent();
        return dividendYieldPercentage;
    }

    public BigDecimal returnPERatio() throws IOException{
        BigDecimal PERatio = stock.getStats().getPe();
        return PERatio;
    }

    public String returnStockExchange() throws IOException{
        String stockExchange = stock.getStockExchange();
        return stockExchange;
    }

    public List returnHistory() throws IOException{
        List<HistoricalQuote> history = stock.getHistory();
        return history;
    }


    public static void main(String[] args) throws IOException {
        MarketInfoRetriever retriever = new MarketInfoRetriever("INTC");

        System.out.println(retriever.returnTicker());
        System.out.println(retriever.returnPrice());
        System.out.println(retriever.returnDividendYield());
        System.out.println(retriever.returnDividendYieldPercentage());
        System.out.println(retriever.returnPERatio());
        System.out.println(retriever.returnStockExchange());
        System.out.println(retriever.returnHistory());



    }
}

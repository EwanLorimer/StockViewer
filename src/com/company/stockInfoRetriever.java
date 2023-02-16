package com.company;
/**
 * @author Ewan Lorimer
 * - No Copyright
 * @version 1.0
 *
 */

import yahoofinance.*;
import yahoofinance.histquotes.HistoricalQuote;

//IOException must be thrown in case information cannot be retrieved, it won't break the program if info is not retrieved
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
//Will retrieve data for a single stock
public class stockInfoRetriever {
    //Use YahooFinance API to retrieve real time market data
    private final String ticker;
    private Stock stock;

    /**
     * Stock info constructor, uses yahoofinance API to retrieve stock
     * @param symbol Ticker value for the stock e.g. KO, BABA, INTL etc
     * @throws IOException Throws IOException if stock cannot be found by API
     */
    public stockInfoRetriever(String symbol) throws IOException {
        ticker = symbol;
        stock = YahooFinance.get(symbol);
    }

    /**
     * Returns ticker value of the stock
     * @return ticker
     */
    public String returnTicker(){

        return ticker;
    }

    public String returnPrice() throws IOException {

        BigDecimal price = stock.getQuote().getPrice();
        String output = price.toString();
        return output;
    }

    public String returnDividendYield() throws IOException{
        BigDecimal dividendYield = stock.getDividend().getAnnualYield();
        String output = dividendYield.toString();
        return output;
    }

    public String returnDividendYieldPercentage() throws IOException{
        BigDecimal dividendYield = stock.getDividend().getAnnualYieldPercent();
        String dividendYieldPercentage = dividendYield.toString() + "%";
        return dividendYieldPercentage;
    }

    public String returnPERatio() throws IOException{
        BigDecimal PERatio = stock.getStats().getPe();
        String output = PERatio.toString();
        return output;
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
        stockInfoRetriever retriever = new stockInfoRetriever("BABA");
    }

}

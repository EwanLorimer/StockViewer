package com.company;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import com.opencsv.*;
public class csvReader {
    private String file = "userInfo.csv";
    private String line = "";
    private BufferedReader reader;
    private ArrayList<String> tickers = new ArrayList<String>();
    private ArrayList<Integer> holdings = new ArrayList<Integer>();
    CSVWriter writer = new CSVWriter(new FileWriter(file));

    public csvReader() throws IOException {

    }


    public void appendTickers(String value){
        tickers.add(value);
    }
    public ArrayList<String> getTickers(){
        return tickers;
    }


    public void appendHoldings(Integer value){
        holdings.add(value);
    }


    public ArrayList<Integer> getHoldings(){

        return holdings;
    }

    public String removeQuotes(String input){
        //When new items are added to the csv, they are surrounded by commas
        //This method will remove the surrounding commas
        StringBuilder remover = new StringBuilder(input);
        remover.deleteCharAt(0);
        remover.deleteCharAt(input.length() - 2);
        return remover.toString();
    }

    public void refreshLists() throws IOException{
        /*
        When csv file has been edited, the list will need to be changed
        Delete contents from the list
        re-read csv file to add everything back into the list
        */
        tickers.clear();
        holdings.clear();
        readFile();
    }

    public void addRecord(String ticker, String holding) throws IOException {
        //Add record then refresh lists
        System.out.println(ticker + " " + holding);
        String[] toAdd = {ticker, holding};
        System.out.println(toAdd[0] + " " + toAdd[1]);
        writer.writeNext(toAdd);
        writer.flush();
        writer.close();
        refreshLists();
    }

    public void editHolding(String ticker, String holding) throws IOException {
        readFile();


    }


    public void deleteRecord(){

    }



    //Throw IO exception for when reader is closed
    public void readFile() throws IOException {

        try {
            //Create a BufferedReader to read the csv file, like scanner but for csv files
            reader = new BufferedReader(new FileReader(file));

            //Parse through the csv file, store it in the array values, then into two lists for ticker and amount held
            while ((line = reader.readLine()) != null){

                String[] values = line.split(",");

                //Strip the quotes off the values
                String ticker = removeQuotes(values[0]);
                String holding = removeQuotes(values[1]);

                appendTickers(ticker);

                //Convert holding value from string to integer
                String tempString = holding;
                Integer integerForHolding = Integer.parseInt(tempString);
                appendHoldings(integerForHolding);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        csvReader test = new csvReader();

        test.readFile();


        test.readFile();

        System.out.println(test.getTickers());
        System.out.println(test.getHoldings());


    }
}

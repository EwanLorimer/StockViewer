package com.company;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class csvReader {
    private String file = "userInfo.csv";
    private String line = "";
    private BufferedReader reader;
    private ArrayList<String> tickers = new ArrayList<String>();
    private ArrayList<Integer> holdings = new ArrayList<Integer>();

    public csvReader(){

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


    public void refreshArrays(){
        //When csv file has been edited, the arrays will need to be changed
        
    }
    public void addRecord(String ticker, String holding){

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
                System.out.println(values[0] + "    " + values[1]);
                appendTickers(values[0]);
                //Convert holding value from string to integer

                String tempString = values[1];
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
        System.out.println(test.getTickers());
        System.out.println(test.getHoldings());
    }
}

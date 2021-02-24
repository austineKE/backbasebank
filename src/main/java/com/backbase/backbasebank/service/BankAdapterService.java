package com.backbase.backbasebank.service;


import com.backbase.backbasebank.model.Backbase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankAdapterService{
    public List<Backbase> getAllTransactions() {
        List<Backbase> transactionlist=new ArrayList<>();
        try {
            URL url = new URL("http://localhost:8081/transaction/list");
            HttpURLConnection con= (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");

            if (con.getResponseCode() != 200)
                throw new RuntimeException("Failed, HTTP error code " + con.getResponseCode());

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;
            System.out.println("\nOutput from server .......");
            ObjectMapper mapper=new ObjectMapper();

            while ((output=bufferedReader.readLine()) != null){
                System.out.println(output);
                transactionlist=mapper.readValue(output, new TypeReference<List<Backbase>>(){});

            }
            con.disconnect();
        }

        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return transactionlist;
    }

    public List<Backbase> getAllTransactionsBasedOnType(String type) {
        List<Backbase> transactionlist=new ArrayList<>();
        Backbase backbase=new Backbase();
        System.out.println("\nAccount id " +backbase.getAccountId());
        try{
            URL url=new URL("http://localhost:8081/transaction/list/"+type);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");

            if (con.getResponseCode() !=200)
                throw new RuntimeException("Failed with response code "+con.getResponseCode());
            BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;
            System.out.println("\n Output from server");
            ObjectMapper mapper=new ObjectMapper();

            while ((output=reader.readLine()) !=null){
                System.out.println(output);
                transactionlist=mapper.readValue(output, new TypeReference<List<Backbase>>(){ });
            }
            con.disconnect();
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return transactionlist;
    }

    public Double getTotalTransactionsAmountBasedOnType(String type) {
        double totalTransaction=0.0;
        try {
            URL url=new URL("http://localhost:8081/totalAmount/" + type);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");

            if (con.getResponseCode() != 200)
                throw new RuntimeException("Failed with Http Response code "+ con.getResponseCode());
            BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
            totalTransaction=reader.read();

        } catch (IOException e){
            e.printStackTrace();
        }
        return totalTransaction;
    }
}

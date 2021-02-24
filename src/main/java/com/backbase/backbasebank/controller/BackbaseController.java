package com.backbase.backbasebank.controller;

import com.backbase.backbasebank.model.Backbase;
import com.backbase.backbasebank.service.BankAdapterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BackbaseController {

    @Autowired
    BankAdapterImpl bankAdapter;

    @Autowired
    RandomTypeChooser chooser;

    @GetMapping("/transaction/list")
    public List<Backbase> getAllTransactions(){
    return bankAdapter.getAllTransactions();
    }

    @GetMapping("/transaction/list/{type}")
    public List<Backbase> getAllTransactionsBasedOnType(@PathVariable String type){
        return bankAdapter.getAllTransactionsBasedOnType(type);

//        chooser.getType()
    }

    @GetMapping("/totalAmount/{type}")
    public double getTotalTransactionsAmountBasedOnType(@PathVariable String type){
        return bankAdapter.getTotalTransactionsAmountBasedOnType(type);
    }
}

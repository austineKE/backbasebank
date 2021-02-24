package com.backbase.backbasebank.service;

import com.backbase.backbasebank.model.Backbase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAdapterImpl implements BankAdapter {

    @Autowired
    BankAdapterService service = new BankAdapterService();

    @Override
    public List<Backbase> getAllTransactions() {
        List<Backbase> list = new ArrayList<>();
        Backbase backbase = new Backbase();

        for (Backbase backbase1 : service.getAllTransactions()) {
            backbase.setId(backbase1.getId());
            backbase.setAccountId(backbase1.getAccountId());
            backbase.setCounterpartyAccount(backbase1.getCounterpartyAccount());
            backbase.setCounterpartyName(backbase1.getCounterpartyName());
            backbase.setCounterPartyLogoPath(backbase1.getCounterPartyLogoPath());
            backbase.setInstructedAmount(backbase1.getInstructedAmount());
            backbase.setInstructedCurrency(backbase1.getInstructedCurrency());
            backbase.setTransactionAmount(backbase1.getTransactionAmount());
            backbase.setTransactionCurrency(backbase1.getTransactionCurrency());
            backbase.setTransactionType(backbase1.getTransactionType());
            backbase.setDescription(backbase1.getDescription());
            list.add(backbase);
        }
        return list;
    }

    @Override
    public List<Backbase> getAllTransactionsBasedOnType(String type) {
        List<Backbase> list = new ArrayList<>();
        Backbase backbase = new Backbase();


        for (Backbase backbase1 : service.getAllTransactionsBasedOnType(type)) {
            backbase.setId(backbase1.getId());
            backbase.setAccountId(backbase1.getAccountId());
            backbase.setCounterpartyAccount(backbase1.getCounterpartyAccount());
            backbase.setCounterpartyName(backbase1.getCounterpartyName());
            backbase.setCounterPartyLogoPath(backbase1.getCounterPartyLogoPath());
            backbase.setInstructedAmount(backbase1.getInstructedAmount());
            backbase.setInstructedCurrency(backbase1.getInstructedCurrency());
            backbase.setTransactionAmount(backbase1.getTransactionAmount());
            backbase.setTransactionCurrency(backbase1.getTransactionCurrency());
            backbase.setTransactionType(backbase1.getTransactionType());
            backbase.setDescription(backbase1.getDescription());
            list.add(backbase);
        }
        return list;
    }

    @Override
    public Double getTotalTransactionsAmountBasedOnType(String type) {
        return service.getTotalTransactionsAmountBasedOnType(type);
    }
}
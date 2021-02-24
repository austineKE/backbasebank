package com.backbase.backbasebank.service;

import com.backbase.backbasebank.model.Backbase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BankAdapter {
    List<Backbase> getAllTransactions();
    List<Backbase> getAllTransactionsBasedOnType(final String type);
    Double getTotalTransactionsAmountBasedOnType(final String type);
}

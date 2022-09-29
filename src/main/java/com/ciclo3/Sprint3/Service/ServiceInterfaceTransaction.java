package com.ciclo3.Sprint3.Service;

import com.ciclo3.Sprint3.Models.Transaction;

import java.util.List;

public interface ServiceInterfaceTransaction {

    public List<Transaction> getTransaction();

    public Transaction getOnlyOneTransaction(Long idTransaction) throws Exception;

    public String getCreateTransaction(Transaction TransactionIn);

    public Transaction getUpdateTransaction(Transaction TransactionIn) throws Exception;

    public String getDeleteTransaction(Long idTransaction) throws Exception;

}

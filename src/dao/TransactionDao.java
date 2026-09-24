package dao;

import entity.Transaction;

import java.util.ArrayList;

public interface TransactionDao  {
    void save(Transaction transaction);
    ArrayList<Transaction> findAll();

}

package service;

import dao.TransactionDao;
import entity.Transaction;

import java.util.ArrayList;

public class TransactionServiceImpl implements TransactionService {

    private TransactionDao transactionDao;

    public TransactionServiceImpl(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public ArrayList<Transaction> findAllTransactions() {
        return transactionDao.findAll();
    }
}
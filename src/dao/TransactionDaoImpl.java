package dao;

import entity.Transaction;

import java.util.ArrayList;

public class TransactionDaoImpl implements TransactionDao{
    private ArrayList<Transaction> Transactions=new ArrayList<Transaction>();

    @Override
    public void save(Transaction transaction) {
            Transactions.add(transaction);

    }

    @Override
    public ArrayList<Transaction> findAll() {
        return Transactions;
    }
}

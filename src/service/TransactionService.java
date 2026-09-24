package service;

import entity.Transaction;
import java.util.ArrayList;

public interface TransactionService {

    ArrayList<Transaction> findAllTransactions();

}
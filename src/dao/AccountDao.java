package dao;

import entity.BankAccount;

import java.util.ArrayList;

public interface AccountDao {
    void save(BankAccount account);
    BankAccount findByAccountNumber(int accountNumber);
    ArrayList<BankAccount> findAll();
    void delete(int accountNumber);


}

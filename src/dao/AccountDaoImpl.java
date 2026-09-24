package dao;

import entity.BankAccount;

import java.util.ArrayList;

public class AccountDaoImpl implements AccountDao{
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    @Override
    public void save(BankAccount account) {
        accounts.add(account);
    }

    @Override
    public BankAccount findByAccountNumber(int accountNumber) {
        for(int i=0;i<accounts.size();i++) {
            if (accounts.get(i).getAccountNumber() ==accountNumber){
                return accounts.get(i);
            }
        }
        return null;
    }

    @Override
    public ArrayList<BankAccount> findAll() {
        return accounts;
    }

    @Override
    public void delete(int accountNumber) {
        for(int i=0;i<accounts.size();i++) {
            if (accounts.get(i).getAccountNumber() ==accountNumber){
                 accounts.remove(i);
                 return;
            }
        }
    }
}

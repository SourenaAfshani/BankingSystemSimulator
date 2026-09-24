package service;

import entity.BankAccount;

import java.util.ArrayList;

public interface BankAccountService {

    void createAccount(BankAccount account);

    ArrayList<BankAccount> findAllAccounts();

    BankAccount findAccount(int accountNumber);

    void deleteAccount(int accountNumber);

    void deposit(int accountNumber, float amount);

    void withdraw(int accountNumber, float amount);

    void TransferC2C(int senderAccountNumber, int receiverAccountNumber, float amount);
    void changeToCurrentAccount(int accountNumber, double overDraftLimit);

    void changeToDepositAccount(int accountNumber, float interestRate);

    void changeInterestRate(int accountNumber, float interestRate);

    void changeOverDraftLimit(int accountNumber, double overDraftLimit);
}
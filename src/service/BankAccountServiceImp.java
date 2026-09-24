package service;

import dao.AccountDao;
import dao.TransactionDao;
import entity.BankAccount;
import entity.CurrentAccount;
import entity.DepositAccount;
import entity.Transaction;

import java.util.ArrayList;

public class BankAccountServiceImp implements BankAccountService{
    private AccountDao accountdao;
    private TransactionDao transactionDao;

    public BankAccountServiceImp(AccountDao accountdao,TransactionDao transactionDao){
        this.accountdao=accountdao;
        this.transactionDao=transactionDao;
    }
    @Override
    public void createAccount(BankAccount account) {
        accountdao.save(account);
    }

    @Override
    public BankAccount findAccount(int accountNumber) {
        return accountdao.findByAccountNumber(accountNumber);
    }

    @Override
    public void deleteAccount(int accountNumber) {
        accountdao.delete(accountNumber);
    }

    @Override
    public void deposit(int accountNumber, float amount) {

        BankAccount account =
                accountdao.findByAccountNumber(accountNumber);

        if(account != null){

            account.Deposit(amount);

            Transaction transaction = new Transaction("Deposit", null, account, amount);
            transactionDao.save(transaction);
        }
        else{
            System.out.println("همچین حسابی در برنامه وجود ندارد");
        }
    }

    @Override
    public void withdraw(int accountNumber, float amount) {

        BankAccount account = accountdao.findByAccountNumber(accountNumber);
        if(account != null){
            account.Withdraw(amount);
            Transaction transaction = new Transaction("Withdraw",
                    account,
                    null, amount);
            transactionDao.save(transaction);
        }
        else{
            System.out.println("همچین حسابی در برنامه وجود ندارد");
        }
    }

    @Override
    public void TransferC2C(int senderAccountNumber, int receiverAccountNumber, float amount) {

        BankAccount sender = accountdao.findByAccountNumber(senderAccountNumber);

        BankAccount receiver = accountdao.findByAccountNumber(receiverAccountNumber);
        if(sender == null){
            System.out.println("حساب مبدا پیدا نشد");
            return;
        }

        if(receiver == null){
            System.out.println("حساب مقصد پیدا نشد");
            return;
        }

        if(senderAccountNumber == receiverAccountNumber){
            System.out.println("حساب مبدا و مقصد نباید یکی باشد");
            return;
        }
        sender.TransferC2C(amount, receiver);
        Transaction transaction = new Transaction(
                        "Transfer", sender, receiver, amount);
        transactionDao.save(transaction);
    }
    @Override
    public ArrayList<BankAccount> findAllAccounts() {
        return accountdao.findAll();
    }
    @Override
    public void changeOverDraftLimit(int accountNumber, double overDraftLimit) {

        BankAccount account = accountdao.findByAccountNumber(accountNumber);

        if (account == null) {
            System.out.println("حساب مورد نظر پیدا نشد");
            return;
        }

        if (account instanceof CurrentAccount) {

            CurrentAccount currentAccount = (CurrentAccount) account;

            currentAccount.setOverDraftLimit(overDraftLimit);

            System.out.println("سقف برداشت با موفقیت تغییر کرد");

        } else {

            System.out.println("این حساب از نوع جاری نیست");
        }
    }
    @Override
    public void changeInterestRate(int accountNumber, float interestRate) {

        BankAccount account = accountdao.findByAccountNumber(accountNumber);

        if (account == null) {
            System.out.println("حساب مورد نظر پیدا نشد");
            return;
        }

        if (account instanceof DepositAccount) {

            DepositAccount depositAccount = (DepositAccount) account;

            depositAccount.setInterestRate(interestRate);

            System.out.println("نرخ سود با موفقیت تغییر کرد");

        } else {

            System.out.println("این حساب از نوع سپرده بلند مدت نیست");
        }
    }
    @Override
    public void changeToCurrentAccount(int accountNumber, double overDraftLimit) {

        BankAccount account =
                accountdao.findByAccountNumber(accountNumber);

        if (account == null) {
            System.out.println("حساب مورد نظر پیدا نشد");
            return;
        }

        if (account instanceof CurrentAccount) {
            System.out.println("این حساب از قبل جاری است");
            return;
        }

        CurrentAccount currentAccount =
                new CurrentAccount(
                        account.getAccountNumber(),
                        account.getAccountBalance(),
                        account.getAccountOwnerName(), overDraftLimit);

        accountdao.delete(accountNumber);
        accountdao.save(currentAccount);

        System.out.println("حساب با موفقیت به حساب جاری تغییر کرد");
    }
    @Override
    public void changeToDepositAccount(int accountNumber, float interestRate) {

        BankAccount account = accountdao.findByAccountNumber(accountNumber);

        if (account == null) {
            System.out.println("حساب مورد نظر پیدا نشد");
            return;
        }

        if (account instanceof DepositAccount) {
            System.out.println("این حساب از قبل سپرده است");
            return;
        }

        DepositAccount depositAccount =
                new DepositAccount(
                        account.getAccountNumber(),
                        account.getAccountBalance(),
                        account.getAccountOwnerName(), interestRate);
        accountdao.delete(accountNumber);
        accountdao.save(depositAccount);
        System.out.println("حساب با موفقیت به حساب سپرده تغییر کرد");
    }
}

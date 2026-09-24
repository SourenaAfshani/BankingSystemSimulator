package entity;

public abstract class BankAccount {
    private final int AccountNumber;
    private float AccountBalance;
    final String AccountOwnerName;
    BankAccount(int AccountNumber,float AccountBalance,String AccountOwnerName){
        this.AccountNumber=AccountNumber;
        this.AccountBalance=AccountBalance;
        this.AccountOwnerName=AccountOwnerName;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public float getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        AccountBalance = accountBalance;
    }
    public void Deposit(float num){
        AccountBalance += num;
    }
    public void Withdraw(float num ){
        if(AccountBalance>=num) {
            AccountBalance -= num;
        }
        else {
            System.out.println("موجودی کافی نیست.");
        }
    }
    public void TransferC2C(float num , BankAccount Receiver){
        if(AccountBalance>=num) {
            AccountBalance -= num;
            Receiver.AccountBalance += num;
        }
        else {
            System.out.println("موجودی کافی نیست.");
        }
    }


    public abstract String ShowAccountInfo();

    public String getAccountOwnerName() {
        return AccountOwnerName;
    }
}

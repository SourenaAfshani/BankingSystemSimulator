package entity;

public class DepositAccount extends BankAccount{
    float InterestRate;

    public DepositAccount(int AccountNumber,float AccountBalance,String AccountOwnerName,float InterestRate){
        super(AccountNumber, AccountBalance, AccountOwnerName);
        this.InterestRate=InterestRate;
    }
    public void ApplyInterest(int intr,float AccountBalance){
        AccountBalance*=intr;
        setAccountBalance(AccountBalance);
    }
    @Override
    public String ShowAccountInfo(){
        return "Owner's Name:"+" "+AccountOwnerName+" " + "Account Number:"+" "+getAccountNumber()+"Account Balance"+" "+getAccountBalance();
    }
    public void setInterestRate(float interestRate) {
        InterestRate = interestRate;
    }

}

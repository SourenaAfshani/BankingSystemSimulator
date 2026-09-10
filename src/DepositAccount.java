public class DepositAccount extends BankAccount {
    float InterestRate;

    DepositAccount(int AccountNumber,float AccountBalance,String AccountOwnerName,float InterestRate){
     super(AccountNumber, AccountBalance, AccountOwnerName);
     this.InterestRate=InterestRate;
    }
    public void ApplyInterest(int intr,float AccountBalance){
        AccountBalance*=intr;
        SetAccountBalance(AccountBalance);
    }
    @Override
    public String ShowAccountInfo(){
        return "Owner's Name:"+" "+AccountOwnerName+" " + "Account Number:"+" "+GetAccountNumber()+"Account Balance"+" "+GetAccountBalance();
    }
}

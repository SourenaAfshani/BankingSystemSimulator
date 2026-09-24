package entity;

public class CurrentAccount extends BankAccount{
    double OverDraftLimit;

    public CurrentAccount(int AccountNumber, float AccountBalance, String AccountOwnerName,double OverDraftLimit) {
        super(AccountNumber, AccountBalance, AccountOwnerName);
        this.OverDraftLimit=OverDraftLimit;
    }
    @Override
    public void Withdraw(float num ){
        float AccountBalanceCurrent=getAccountBalance();
        if(AccountBalanceCurrent + OverDraftLimit>=num) {
            AccountBalanceCurrent -= num;
            setAccountBalance(AccountBalanceCurrent);
        }
        else {
            System.out.println("موجودی کافی نیست.");
        }
    }
    @Override
    public void TransferC2C(float num , BankAccount Receiver){
        float AccountBalanceCurrent=getAccountBalance();
        if(AccountBalanceCurrent+OverDraftLimit>=num) {
            AccountBalanceCurrent -= num;
            Receiver.setAccountBalance(Receiver.getAccountBalance()+num);
            setAccountBalance(AccountBalanceCurrent);
        }
        else {
            System.out.println("موجودی کافی نیست.");
        }
    }
    @Override
    public String ShowAccountInfo(){
        return "Owner's Name:"+" "+AccountOwnerName+" " + "Account Number:"+" "+getAccountNumber()+"Account Balance"+" "+getAccountBalance() +"OverDraftLimit"+" "+OverDraftLimit;
    }
    public void setOverDraftLimit(double overDraftLimit) {
        OverDraftLimit = overDraftLimit;
    }

}

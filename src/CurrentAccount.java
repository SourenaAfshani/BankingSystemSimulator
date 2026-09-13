public class CurrentAccount extends BankAccount{
     double OverDraftLimit;

    CurrentAccount(int AccountNumber, float AccountBalance, String AccountOwnerName,double OverDraftLimit) {
        super(AccountNumber, AccountBalance, AccountOwnerName);
        this.OverDraftLimit=OverDraftLimit;
    }
    @Override
    public void Withdraw(float num ){
        float AccountBalanceCurrent=GetAccountBalance();
        if(AccountBalanceCurrent + OverDraftLimit>=num) {
            AccountBalanceCurrent -= num;
            SetAccountBalance(AccountBalanceCurrent);
        }
        else {
            System.out.println("موجودی کافی نیست.");
        }
    }
    @Override
    public void TransferC2C(float num , BankAccount Receiver){
        float AccountBalanceCurrent=GetAccountBalance();
        if(AccountBalanceCurrent+OverDraftLimit>=num) {
            AccountBalanceCurrent -= num;
            Receiver.SetAccountBalance(Receiver.GetAccountBalance()+num);
            SetAccountBalance(AccountBalanceCurrent);
        }
        else {
            System.out.println("موجودی کافی نیست.");
        }
    }
    @Override
    public String ShowAccountInfo(){
        return "Owner's Name:"+" "+AccountOwnerName+" " + "Account Number:"+" "+GetAccountNumber()+"Account Balance"+" "+GetAccountBalance() +"OverDraftLimit"+" "+OverDraftLimit;
    }
}

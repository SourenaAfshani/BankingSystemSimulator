public class BankAccount {
    private final int AccountNumber;
    private float AccountBalance;
    final String AccountOwnerName;
    BankAccount(int AccountNumber,float AccountBalance,String AccountOwnerName){
        this.AccountNumber=AccountNumber;
        this.AccountBalance=AccountBalance;
        this.AccountOwnerName=AccountOwnerName;
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
    public String ShowAccountInfo(){
       return "Owner's Name:"+" "+AccountOwnerName+" " + "Account Number:"+" "+AccountNumber+"Account Balance"+" "+AccountBalance;
    }
    public void SetAccountBalance(float num1){
        AccountBalance=num1;
    }
    public float GetAccountBalance(){
        return AccountBalance;
    }
    public int GetAccountNumber(){
        return AccountNumber;
    }



}

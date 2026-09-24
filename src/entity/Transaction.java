package entity;

public class Transaction {
    private String TransactionType;
    BankAccount Sender;
    BankAccount Receiver;
    private float TransactionAmount;
    public Transaction(String TransactionType,
                       BankAccount Sender,
                       BankAccount Receiver,
                       float TransactionAmount){
        this.TransactionType=TransactionType;
        this.Sender=Sender;
        this.Receiver=Receiver;
        this.TransactionAmount=TransactionAmount;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public float getTransactionAmount() {
        return TransactionAmount;
    }

    public void setTransactionAmount(float transactionAmount) {
        TransactionAmount = transactionAmount;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }
    public String ShowTransactionInfo(){
        if(Sender==null){
            return "Transaction Type:  "+
                    TransactionType+
                    " "+"TransactionAmount:  "+
                    TransactionAmount+" "+"Transaction Sender:  "+
                    Sender+"  "+ "Transaction Receiver:  "+Receiver.getAccountNumber();}
        else if (Receiver==null){
            return "Transaction Type:  "+
                    TransactionType+
                    " "+"TransactionAmount:  "+
                    TransactionAmount+" "+"Transaction Sender:  "+
                    Sender.getAccountNumber()+"  "+ "Transaction Receiver:  "+Receiver;

        }
        else {
            return "Transaction Type:  "+
                    TransactionType+
                    " "+"TransactionAmount:  "+
                    TransactionAmount+" "+"Transaction Sender:  "+
                    Sender.getAccountNumber()+"  "+ "Transaction Receiver:  "+Receiver.getAccountNumber();

        }

    }
}

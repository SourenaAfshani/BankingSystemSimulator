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
    public Transaction(String TransactionType, BankAccount Receiver, float TransactionAmount){
        this.TransactionType=TransactionType;
        this.Receiver=Receiver;
        this.TransactionAmount=TransactionAmount;
    }
    public String getTransactionType(){
        return TransactionType;
    }
    public void setTransactionType(String type){
        TransactionType=type;
    }
    public float getTransactionAmount(){
        return TransactionAmount;
    }
    public void setTransactionAmount(float Tra){
        TransactionAmount=Tra;
    }
    public String ShowTransactionInfo(){
        if(Sender==null){
        return "Transaction Type:  "+
                TransactionType+
                " "+"TransactionAmount:  "+
                TransactionAmount+" "+"Transaction Sender:  "+
                Sender+"  "+ "Transaction Receiver:  "+Receiver.GetAccountNumber();}
        else if (Receiver==null){
            return "Transaction Type:  "+
                    TransactionType+
                    " "+"TransactionAmount:  "+
                    TransactionAmount+" "+"Transaction Sender:  "+
                    Sender.GetAccountNumber()+"  "+ "Transaction Receiver:  "+Receiver;

        }
        else {
            return "Transaction Type:  "+
                    TransactionType+
                    " "+"TransactionAmount:  "+
                    TransactionAmount+" "+"Transaction Sender:  "+
                    Sender.GetAccountNumber()+"  "+ "Transaction Receiver:  "+Receiver.GetAccountNumber();

        }

    }


}

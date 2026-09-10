import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Random random = new Random();
        BankAccount[] Accounts=new BankAccount[4];
        int RegisteredAccounts=0;
        SourenaBankingProject:
        while(true){
        Menu();
        int InputMenu=input.nextInt();
        switch(InputMenu){
            case 1:
                if(RegisteredAccounts>=Accounts.length*0.75) {
                    BankAccount[] Accounts2 = new BankAccount[Accounts.length * 2];
                    for (int i = 0; i < RegisteredAccounts; i++) {
                        Accounts2[i] = Accounts[i];
                    }
                    Accounts = Accounts2;
                }
                System.out.println("نام سازنده حساب را وارد کنید");
                String AccountOwnerName=input.next();
                System.out.println("موجودی اولیه را وارد کنید");
                float AccountBalance=input.nextFloat();
                System.out.println("نوع حساب را بر اساس عدد وارد کنید(بلند مدت 1 و جاری 2 )");
                int AccountType=input.nextInt();
                int AccountNumber=62190000 + random.nextInt(10000);
                if(AccountType==1){
                    System.out.println("مقدار سود مدنظر برای این حساب بلند مدت را وارد کنید");
                    float InterestRate=input.nextFloat();
                    Accounts[RegisteredAccounts]=new DepositAccount(AccountNumber,AccountBalance,AccountOwnerName,InterestRate);
                    System.out.println("حساب جدید با موفقیت ثبت شد.");
                    RegisteredAccounts++;
                }
                else if(AccountType==2){
                    System.out.println("مقدار سقف اضافه برداشت را برای این حساب جاری وارد کنید");
                    double OverDraftLimit=input.nextDouble();
                    Accounts[RegisteredAccounts]=new CurrentAccount(AccountNumber,AccountBalance,AccountOwnerName,OverDraftLimit);
                    System.out.println("حساب جدید با موفقیت ثبت شد.");
                    RegisteredAccounts++;
                }
                break ;
            case 2:
                for(int i=0;i<RegisteredAccounts;i++){
                    System.out.println("َAccount Creator:"+Accounts[i].AccountOwnerName+"   ");
                    if(Accounts[i] instanceof DepositAccount){
                        System.out.println("Account Type is DepositAccount ");
                    }
                    else if(Accounts[i] instanceof CurrentAccount){
                        System.out.println("Account Type is CurrentAccount ");

                    }
                    System.out.println("َAccount Number:"+Accounts[i].GetAccountNumber()+"   ");
                    System.out.println("َAccount Balance:"+Accounts[i].GetAccountBalance()+"   ");


                }
                break ;
            case 3:
                System.out.println("شماره ی کارتی که قصد واریز وجه را به آن دارید وارد کنید (8رقمی)");
                int AccountNumberInput=input.nextInt();
                boolean AccountFound=false;
                for (int i=0;i<RegisteredAccounts;i++) {
                    if (Accounts[i].GetAccountNumber() == AccountNumberInput) {
                        System.out.println("مبلغ مورد نظر برای واریزی را وارد کنید");
                        float TransferringValue= input.nextFloat();
                        Accounts[i].Deposit(TransferringValue);
                        System.out.println("New AccountBalance:"+"     "+Accounts[i].GetAccountBalance());
                        AccountFound=true;
                        break;
                    }


                }
                if(AccountFound==false) {
                    System.out.println("شماره کارت اشتباه است و در سامانه ثبت نشده است");
                }
                break;
            case 4 :
                System.out.println("شماره کارتی که قصد واریز وجه را به آن دارید را وارد کنید(8 رقمی)");
                int AccountNumberInput2=input.nextInt();
                boolean AccountFound2=false;
                for (int i = 0; i<RegisteredAccounts; i++) {
                    if(Accounts[i].GetAccountNumber()==AccountNumberInput2){
                        System.out.println("مبلغی که میخواهید برداشت شود را وارد کنید.");
                        float TransferringValue2=input.nextFloat();
                        Accounts[i].Withdraw(TransferringValue2);
                        AccountFound2=true;
                        break;

                    }

                }
                if(AccountFound2==false){
                    System.out.println("حساب مورد نظر پیدا نشد");
                }
                break;
            case 5:
                BankAccount Sender=null;
                BankAccount Receiver=null;
                System.out.println("شماره کارت مبدا را وارد کنید.");
                int TransferFirstC=input.nextInt();
                System.out.println("شماره کارت مقصد را وارد کنید");
                int TransferSecondC=input.nextInt();
                for (int i = 0; i<RegisteredAccounts ; i++) {
                    if(Accounts[i].GetAccountNumber()==TransferFirstC){
                         Sender=Accounts[i];
                        break;
                    }

                }
                if (Sender == null) {
                    System.out.println("شماره کارت مبدا اشتباه است");
                }
                for(int i=0;i<RegisteredAccounts;i++){
                    if(Accounts[i].GetAccountNumber()==TransferSecondC){
                         Receiver=Accounts[i];
                        break;
                    }
                }
                if (Receiver==null) {
                System.out.println("شماره کارت مقصد اشتباه است");
                }
                if(Sender!=null && Receiver!=null) {
                    if(Sender.GetAccountNumber()!=Receiver.GetAccountNumber()){
                    System.out.println("مبلغ انتقال را وارد کنید.");
                    float TransferFee = input.nextFloat();
                    Sender.TransferC2C(TransferFee, Receiver);}
                    else {
                        System.out.println("شماره کارت مبدا و مقصد نباید یکی باشد");
                    }
                }
                break ;
            case 6:
                System.out.println("شماره کارت را وارد کنید");
                boolean AccountNumberFound=false;
                int CardNumberInput=input.nextInt();
                for(int i=0;i<RegisteredAccounts;i++){
                    if(Accounts[i].GetAccountNumber()==CardNumberInput){
                        System.out.println("Account Owner:"+" "+Accounts[i].AccountOwnerName);
                        System.out.println("Account Number:"+" "+Accounts[i].GetAccountNumber());
                        System.out.println("Account Balance:"+" "+Accounts[i].GetAccountBalance());
                        AccountNumberFound=true;
                        break ;
                    }

                }
                if(AccountNumberFound==false){
                    System.out.println("شماره کارت وارد شده در سامانه موجود نیست");
                }
                break ;
            case 7:
                System.out.println("شماره کارت حساب مورد نظر خود را وارد کنید.");
                int CardNumberInput2= input.nextInt();
                boolean AccountNumberFound2=false;
                for(int i=0;i<RegisteredAccounts;i++){
                    if(Accounts[i].GetAccountNumber()==CardNumberInput2){
                        AccountNumberFound2=true;
                        Case7Menu();
                        int Case7Input= input.nextInt();
                        switch (Case7Input){
                            case 1:
                                if(Accounts[i] instanceof DepositAccount){
                                    System.out.println("یک نرخ سقف برداشت برای حساب جاری وارد کنید");
                                    double OverDraftLimit= input.nextDouble();
                                    Accounts[i]=new CurrentAccount(Accounts[i].GetAccountNumber(),
                                            Accounts[i].GetAccountBalance(),
                                            Accounts[i].AccountOwnerName,
                                            OverDraftLimit);

                                }
                                else if(Accounts[i] instanceof CurrentAccount){
                                    System.out.println("نرخ سود برای حساب بلند مدت وارد کنید");
                                    float InterestRateInput1=input.nextFloat();
                                    Accounts[i]=new DepositAccount(Accounts[i].GetAccountNumber(),
                                            Accounts[i].GetAccountBalance(),
                                            Accounts[i].AccountOwnerName,
                                            InterestRateInput1);

                                }
                                break;
                            case 2 :
                                boolean AccountIsDeposit=false;
                                if(Accounts[i] instanceof DepositAccount){
                                    AccountIsDeposit=true;
                                    System.out.println("نرخ سود جدید وارد کنید");
                                    float InterestRateInput2=input.nextFloat();
                                   ((DepositAccount) Accounts[i]).InterestRate=InterestRateInput2;
                                    System.out.println("نرخ سود جدید با موفقیت ثبت شد");
                                    break;
                                }
                                if(AccountIsDeposit==false){
                                    System.out.println("حساب شما بلند مدت نیست در نتیجه امکان تغییر سود وجود ندارد");
                                }
                                break;
                            case 3:
                                boolean AccountIsCurrent=false;
                                if(Accounts[i] instanceof CurrentAccount){
                                    AccountIsCurrent=true;
                                    System.out.println("نرخ سقف برداشت جدید را وارد کنید");
                                    double OverDraftLimitInput=input.nextDouble();
                                    ((CurrentAccount) Accounts[i]).OverDraftLimit=OverDraftLimitInput;
                                    System.out.println("نرخ سقف برداشت جدید ثبت شد");
                                    break ;
                                }
                                if(AccountIsCurrent==false){
                                    System.out.println("حساب جاری نیست پس امکان تغییر نرخ سقف برداشت وجود ندارد");
                                }
                                break;
                            case 4:
                                break;

                        }

                    }
                }
                if(AccountNumberFound2==false){
                    System.out.println("شماره کارت اشتباه است");
                }
                break;
            case 8:
                System.out.println("شماره کارت حساب مورد نظر خود را وارد کنید.");
                int CardNumberInput3= input.nextInt();
                boolean AccountNumberFound3=false;
                for(int i=0;i<RegisteredAccounts;i++){
                    if(Accounts[i].GetAccountNumber()==CardNumberInput3){
                        AccountNumberFound3=true;
                        for(int j=i;j<RegisteredAccounts-1;j++){
                            Accounts[j]=Accounts[j+1];
                        }
                        RegisteredAccounts--;
                        Accounts[RegisteredAccounts]=null;
                        System.out.println("حساب با موفقیت حذف شد");
                        break;
                    }
                }
                if(!AccountNumberFound3){
                    System.out.println("شماره کارت اشتباه است");
                }
                break;
            case 9:
                int DepositCount=0;
                int CurrentCount=0;
                for(int i=0;i<RegisteredAccounts;i++){
                    if(Accounts[i] instanceof DepositAccount){
                        DepositCount++;
                    }
                    else if(Accounts[i] instanceof CurrentAccount){
                        CurrentCount++;
                    }
                }
                System.out.println("There are "+" "+DepositCount+"Deposit Accounts");
                System.out.println("There are "+" "+CurrentCount+"Current Accounts");
                break ;

            case 10:
                BankAccount[] TempArray=new BankAccount[RegisteredAccounts];
                BankAccount[] TempArray2=new BankAccount[RegisteredAccounts];
                int ArrayIndex=0;
                int RegisteredAccountsTemp =RegisteredAccounts;

                for(int i=0;i<RegisteredAccounts;i++){
                    TempArray[i]=Accounts[i];
                }
                while(RegisteredAccountsTemp>0){
                    int HighestIndex=0;
                    for (int i = 1; i < RegisteredAccountsTemp; i++) {

                        if (TempArray[i].GetAccountBalance() >
                                TempArray[HighestIndex].GetAccountBalance()) {

                            HighestIndex = i;
                        }
                    }
                    TempArray2[ArrayIndex] = TempArray[HighestIndex];
                    ArrayIndex++;
                    for (int i = HighestIndex; i < RegisteredAccountsTemp - 1; i++) {
                        TempArray[i] = TempArray[i + 1];
                    }
                    RegisteredAccountsTemp--;

                    TempArray[RegisteredAccountsTemp] = null;
                }
                for (int i=0;i<RegisteredAccounts;i++){
                    System.out.println(TempArray2[i].ShowAccountInfo());
                }
                break;
            case 11:
                break SourenaBankingProject;



        }

        }



    }
    public static void Menu(){
        System.out.println("==================== Banking System Menu ====================");

        System.out.println("1. ایجاد حساب جدید");
        System.out.println("2. نمایش تمام حساب ها");
        System.out.println("3. واریز وجه");
        System.out.println("4. برداشت وجه");
        System.out.println("5. انتقال وجه");
        System.out.println("6. جستجوی حساب بر اساس شماره حساب");
        System.out.println("7. تغییر اطلاعات حساب");
        System.out.println("8. حذف حساب");
        System.out.println("9. نمایش تعداد حساب ها بر اساس نوع");
        System.out.println("10. مرتب سازی حساب ها بر اساس موجودی");
        System.out.println("11. خروج");

        System.out.println("==============================================================");
    }
    public static void Case7Menu(){
        System.out.println("لطفا یکی از گزینه های زیر را انتخاب کنید");
        System.out.println("1. تغییر نوع حساب");
        System.out.println("2. تغییر نرخ سود حساب بلند مدت");
        System.out.println("3. تغییر سقف برداشت حساب جاری");
        System.out.println("4. بازگشت");
    }
}

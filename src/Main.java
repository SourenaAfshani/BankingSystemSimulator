import dao.AccountDao;
import dao.AccountDaoImpl;
import dao.TransactionDao;
import dao.TransactionDaoImpl;
import service.BankAccountService;
import service.BankAccountServiceImp;
import entity.CurrentAccount;
import entity.DepositAccount;
import entity.BankAccount;
import entity.Transaction;
import service.TransactionService;
import service.TransactionServiceImpl;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Random random = new Random();
        AccountDao accountDao = new AccountDaoImpl();
        TransactionDao transactionDao = new TransactionDaoImpl();
        BankAccountService bankAccountService = new BankAccountServiceImp(accountDao,transactionDao);
        TransactionService transactionService = new TransactionServiceImpl(transactionDao);
        SourenaBankingProject:
        while(true){
            Menu();
            int InputMenu=input.nextInt();
            switch(InputMenu){
                case 1:
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
                        bankAccountService.createAccount(new DepositAccount(AccountNumber, AccountBalance, AccountOwnerName, InterestRate));
                        System.out.println("حساب جدید با موفقیت ثبت شد.");
                    }
                    else if(AccountType==2){
                        System.out.println("مقدار سقف اضافه برداشت را برای این حساب جاری وارد کنید");
                        double OverDraftLimit=input.nextDouble();
                        bankAccountService.createAccount(new CurrentAccount(AccountNumber,AccountBalance,AccountOwnerName,OverDraftLimit));
                        System.out.println("حساب جدید با موفقیت ثبت شد.");
                    }
                    break ;
                case 2:
                    ArrayList<BankAccount> accounts = bankAccountService.findAllAccounts();
                    for(int i=0;i<accounts.size();i++){
                        System.out.println(
                                accounts.get(i).ShowAccountInfo()
                        );

                    }
                    break ;
                case 3:
                    System.out.println("شماره ی کارتی که قصد واریز وجه را به آن دارید وارد کنید (8رقمی)");
                    int AccountNumberInput=input.nextInt();
                            System.out.println("مبلغ مورد نظر برای واریزی را وارد کنید");
                            float TransferringValue= input.nextFloat();
                    bankAccountService.deposit(AccountNumberInput, TransferringValue);
                            break;
                case 4 :
                    System.out.println("شماره کارتی که قصد واریز وجه را به آن دارید را وارد کنید(8 رقمی)");
                    int AccountNumberInput2=input.nextInt();
                    System.out.println("مبلغی که میخواهید برداشت شود را وارد کنید.");
                    float TransferringValue2=input.nextFloat();
                    bankAccountService.withdraw(AccountNumberInput2,TransferringValue2);
                    break;
                case 5:
                    System.out.println("شماره کارت مبدا را وارد کنید.");
                    int TransferFirstC=input.nextInt();
                    System.out.println("شماره کارت مقصد را وارد کنید");
                    int TransferSecondC=input.nextInt();
                    System.out.println("مبلغ تراکنش را وارد کنید");
                    float TransferValue=input.nextFloat();
                   bankAccountService.TransferC2C(TransferFirstC,TransferSecondC,TransferValue);
                    break ;
                case 6:
                    System.out.println("شماره کارت را وارد کنید");
                    int AccountNumberInput3=input.nextInt();
                    accountDao.findByAccountNumber(AccountNumberInput3);
                    break ;
                case 7:
                            Case7Menu();
                            int Case7Input= input.nextInt();
                            switch (Case7Input){
                                case 1:
                                    System.out.println("شماره حساب را وارد کنید:");
                                    int accountNumber = input.nextInt();

                                    System.out.println("نوع حساب جدید را انتخاب کنید:");
                                    System.out.println("1. حساب جاری");
                                    System.out.println("2. حساب سپرده");

                                    int accountType = input.nextInt();
                                    if (accountType == 1) {
                                        System.out.println("سقف اضافه برداشت را وارد کنید:");
                                        double overDraftLimit = input.nextDouble();

                                        bankAccountService.changeToCurrentAccount(
                                                accountNumber, overDraftLimit);

                                    } else if (accountType == 2) {

                                        System.out.println("نرخ سود را وارد کنید:");
                                        float interestRate = input.nextFloat();

                                        bankAccountService.changeToDepositAccount(accountNumber, interestRate);
                                    } else {
                                        System.out.println("گزینه نامعتبر است.");
                                    }
                                    break;

                                case 2 :
                                    System.out.println("شماره حساب را وارد کنید:");
                                    int depositAccountNumber = input.nextInt();

                                    System.out.println("نرخ سود جدید را وارد کنید:");
                                    float interestRate = input.nextFloat();

                                    bankAccountService.changeInterestRate(depositAccountNumber, interestRate);

                                    break;
                                case 3:
                                    System.out.println("شماره حساب را وارد کنید:");
                                    int currentAccountNumber = input.nextInt();
                                    System.out.println("سقف اضافه برداشت جدید را وارد کنید:");
                                    double overDraftLimit = input.nextDouble();
                                    bankAccountService.changeOverDraftLimit(currentAccountNumber, overDraftLimit);

                                    break;
                                case 4:
                                    break;

                            }

                case 8:
                    System.out.println("شماره کارت حساب مورد نظر خود را وارد کنید.");
                    int cardNumberInput3 = input.nextInt();
                    BankAccount account = bankAccountService.findAccount(cardNumberInput3);
                    if(account != null){
                        bankAccountService.deleteAccount(cardNumberInput3);
                        System.out.println("حساب با موفقیت حذف شد");
                    }
                    else{
                        System.out.println("شماره کارت اشتباه است");
                    }
                    break;
                case 9:
                    int DepositCount=0;
                    int CurrentCount=0;
                    ArrayList<BankAccount> accounts2 = bankAccountService.findAllAccounts();
                    for(int i=0;i<accounts2.size();i++){
                        if(accounts2.get(i) instanceof DepositAccount){
                            DepositCount++;
                        }
                        else if(accounts2.get(i) instanceof CurrentAccount){
                            CurrentCount++;
                        }
                    }
                    System.out.println("There are "+" "+DepositCount+"Deposit Accounts");
                    System.out.println("There are "+" "+CurrentCount+"Current Accounts");
                    break ;

                case 10:
                    ArrayList<BankAccount> accounts3 = bankAccountService.findAllAccounts();
                    BankAccount[] TempArray=new BankAccount[accounts3.size()];
                    BankAccount[] TempArray2=new BankAccount[accounts3.size()];
                    int ArrayIndex=0;
                    int RegisteredAccountsTemp =accounts3.size();

                    for(int i=0;i<accounts3.size();i++){
                        TempArray[i]=accounts3.get(i);
                    }
                    while(RegisteredAccountsTemp>0){
                        int HighestIndex=0;
                        for (int i = 1; i < RegisteredAccountsTemp; i++) {

                            if (TempArray[i].getAccountBalance() >
                                    TempArray[HighestIndex].getAccountBalance()) {

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
                    for (int i=0;i<accounts3.size();i++){
                        System.out.println(TempArray2[i].ShowAccountInfo());
                    }
                    break;
                case 11:
                    ArrayList<Transaction> transactions = transactionService.findAllTransactions();
                    for(int i = 0; i < transactions.size(); i++){
                        System.out.println(transactions.get(i).ShowTransactionInfo());
                    }
                    break;
                case 12:
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
        System.out.println("11. نمایش لیست تراکنش ها ");
        System.out.println("12. خروج");


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
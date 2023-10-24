package PracticeForMidSemExamination;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main extends BankingManageMentSystem {
    static ArrayList<BankingManageMentSystem> objList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public Main(int accNumber, String accType, String serviceBranchIFSC, float availableBalance, String customerName, int customerID, float minimumBalance) {
        super(accNumber, accType, serviceBranchIFSC, availableBalance, customerName, customerID, minimumBalance);
    }

    public static void main(String[] args) {
        while (true){
            System.out.println("1 : Update details of an account. ");
            System.out.println("2 : Get details of an account");
            System.out.println("3 : Deposit money.");
            System.out.println("4 : Withdraw money.");
            System.out.println("5 : Set details.");
            System.out.println("6 : Exit.");
            System.out.println("Enter choice :");
            int choice = sc.nextInt();
            switch (choice){
                case 1 : {
                    System.out.println("Enter the ID of the account :");
                    int id = sc.nextInt() ;
                    sc.nextLine();
                    BankingManageMentSystem foundAccount = null ;
                    for (BankingManageMentSystem acc : objList){
                        if(acc.getCustomerID() == id){
                            foundAccount = acc;
                            break;
                        }
                    }
                    System.out.println("Chose what do you want to update :\n" +
                            "1. All the details.\n" +
                            "2. Name\n" +
                            "3. Account type\n" +
                            "4. Account number\n" +
                            "5. Service branch IFSC\n" +
                            "6. Available balance.\n" +
                            "7. Enter the name of the customer ID.\n" +
                            "8. Enter the name of the minimum balance.");
                            int tempChoice = sc.nextInt() ;
                            switch (tempChoice){
                                case 1 : {
                                    System.out.println("Enter the name of the customer: ");
                                    String customerName = sc.nextLine();
                                    sc.nextLine();
                                    foundAccount.setCustomerName(customerName);
                                    System.out.println("Enter the name of the account type: ");
                                    String accType = sc.nextLine();
                                    foundAccount.setAccType(accType);//AccType(accType);
                                    System.out.println("Enter the name of the account number: ");
                                    int accNumber = sc.nextInt();
                                    sc.nextLine();foundAccount.setAccNumber(accNumber);
                                    System.out.println("Enter the name of the service branch IFSC: ");
                                    String serviceBranchIFSC = sc.nextLine();foundAccount.setServiceBranchIFSC(serviceBranchIFSC);
                                    System.out.println("Enter the name of the available balance: ");
                                    float availableBalance = sc.nextFloat();foundAccount.setAvailableBalance(availableBalance);
                                    System.out.println("Enter the name of the customer ID: ");
                                    int customerID = sc.nextInt();foundAccount.setCustomerID(customerID);
                                    System.out.println("Enter the name of the minimum balance: ");
                                    float minimumBalance = sc.nextFloat();foundAccount.setMinimumBalance(minimumBalance);
                                    break;
                                }case 2 :{
                                    System.out.println("Enter the name of the customer: ");
                                    String customerName = sc.nextLine();
                                    sc.nextLine();
                                    foundAccount.setCustomerName(customerName);
                                    break;
                                }case 3 :{
                                    System.out.println("Enter the name of the account type: ");
                                    String accType = sc.nextLine();
                                    foundAccount.setAccType(accType);
                                    break;
                                } case 4 :{
                                    System.out.println("Enter the name of the account number: ");
                                    int accNumber = sc.nextInt();
                                    sc.nextLine();foundAccount.setAccNumber(accNumber);
                                    break;
                                } case 5 :{
                                    System.out.println("Enter the name of the service branch IFSC: ");
                                    String serviceBranchIFSC = sc.nextLine();foundAccount.setServiceBranchIFSC(serviceBranchIFSC);
                                    break;
                                } case 6 :{
                                    System.out.println("Enter the name of the available balance: ");
                                    float availableBalance = sc.nextFloat();foundAccount.setAvailableBalance(availableBalance);
                                    break;
                                } case 7 :{
                                    System.out.println("Enter the name of the customer ID: ");
                                    int customerID = sc.nextInt();foundAccount.setCustomerID(customerID);
                                    break;
                                } case 8 :{
                                    System.out.println("Enter the name of the minimum balance: ");
                                    float minimumBalance = sc.nextFloat();foundAccount.setMinimumBalance(minimumBalance);
                                    break;
                                } default:{
                                    System.out.println("Invalid choice " + tempChoice);
                                }
                            }
                    break;
                }
                case 2 : {
                    System.out.println("Enter the ID of the account :");
                    int id = sc.nextInt() ;
                    sc.nextLine();
                    BankingManageMentSystem foundAccount = null ;
                    for (BankingManageMentSystem acc : objList){
                        if(acc.getCustomerID() == id){
                            foundAccount = acc;
                            break;
                        }
                    }
                    System.out.println("Name : " + foundAccount.getCustomerName());
                    System.out.println("Account type : " + foundAccount.getAccType());
                    System.out.println("Account number : " + foundAccount.getAccNumber());
                    System.out.println("Service branch IFSC : " + foundAccount.getServiceBranchIFSC());
                    System.out.println("Available balance : " + foundAccount.getAvailableBalance());
                    System.out.println("Enter the name of the customer ID : " + foundAccount.getCustomerID());
                    System.out.println("Enter the name of the minimum balance : "+ foundAccount.getMinimumBalance());
                    break;
                }
                case 3 : {
                    System.out.println("Enter the ID of the account :");
                    int id = sc.nextInt() ;
                    sc.nextLine();
                    BankingManageMentSystem foundAccount = null ;
                    for (BankingManageMentSystem acc : objList){
                        if(acc.getCustomerID() == id){
                            foundAccount = acc;
                            break;
                        }
                    }
                    System.out.println("Enter the amount you want deposit : ");
                    int temp = sc.nextInt();
                    int store = (int) (temp + foundAccount.availableBalance);
                    foundAccount.setAvailableBalance(store);
                    break;
                }
                case 4 : {
                    System.out.println("Enter the ID of the account :");
                    int id = sc.nextInt() ;
                    sc.nextLine();
                    BankingManageMentSystem foundAccount = null ;
                    for (BankingManageMentSystem acc : objList){
                        if(acc.getCustomerID() == id){
                            foundAccount = acc;
                            break;
                        }
                    }
                    System.out.println("Enter the amount you want withdraw  : ");
                    int temp = sc.nextInt();
                    if(foundAccount.availableBalance < temp){
                        System.out.println("Insufficient balance");
                    }
                    else {
                        int store = (int) foundAccount.availableBalance - temp ;
                        foundAccount.setAvailableBalance(store);
                    }
                    break;
                }
                case 5 : {
                    System.out.println("Enter the name of the customer: ");
                    String customerName = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter the name of the account type: ");
                    String accType = sc.nextLine();
                    System.out.println("Enter the name of the account number: ");
                    int accNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the name of the service branch IFSC: ");
                    String serviceBranchIFSC = sc.nextLine();
                    System.out.println("Enter the name of the available balance: ");
                    float availableBalance = sc.nextFloat();
                    System.out.println("Enter the name of the customer ID: ");
                    int customerID = sc.nextInt();
                    System.out.println("Enter the name of the minimum balance: ");
                    float minimumBalance = sc.nextFloat();
                    setDetails(accNumber, accType, serviceBranchIFSC, availableBalance, customerName, customerID, minimumBalance);
                    break;
                }
                case 6 : {
                    exit(0);
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
    public static void setDetails(int accNumber , String accType , String serviceBranchIFSC , float availableBalance , String customerName , int customerID , float minimumBalance ){
        BankingManageMentSystem tempBoj = new BankingManageMentSystem(accNumber,accType,serviceBranchIFSC,availableBalance,customerName,customerID,minimumBalance);
        objList.add(tempBoj);
    }
}
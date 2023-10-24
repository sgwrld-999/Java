package PracticeForMidSemExamination;
import java.util.*;
public class BankingManageMentSystem {
    int accNumber ;
    String accType ;
    String serviceBranchIFSC ;
    float availableBalance ;
    String customerName ;
    int customerID ;
    float minimumBalance ;
    static int totalNumberOfAccounts = 0;
    BankingManageMentSystem(){}
    public BankingManageMentSystem(int accNumber, String accType, String serviceBranchIFSC, float availableBalance, String customerName, int customerID, float minimumBalance) {
        this.accNumber = accNumber;
        this.accType = accType;
        this.serviceBranchIFSC = serviceBranchIFSC;
        this.availableBalance = availableBalance;
        this.customerName = customerName;
        this.customerID = customerID;
        this.minimumBalance = minimumBalance;
        totalNumberOfAccounts++;
    }
    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getServiceBranchIFSC() {
        return serviceBranchIFSC;
    }

    public void setServiceBranchIFSC(String serviceBranchIFSC) {
        this.serviceBranchIFSC = serviceBranchIFSC;
    }

    public float getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(float minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public float getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(float availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}

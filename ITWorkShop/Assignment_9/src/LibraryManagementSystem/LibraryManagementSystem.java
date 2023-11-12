package LibraryManagementSystem;
import java.util.*;


public class LibraryManagementSystem {
    public Date dateOfEntry ;
    public String ISBN  ;
    public int availableQuantity ;
    public char category ;
    static int countOfItems = 0 ;
    public LibraryManagementSystem(){} // Default constructor
    public LibraryManagementSystem(Date date, String ISBN, int availableQuantity, char category) {
        this.dateOfEntry = date;
        this.ISBN = ISBN;
        this.availableQuantity = availableQuantity;
        this.category = category;
        countOfItems++;
    }// Parameterized constructor  // Getter and Setter methods
    public Date getDate() {
        return dateOfEntry;
    }

    public void setDate(Date date) {
        this.dateOfEntry = date;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
    public char getCategory() {
        return category;
    }

    public void setCategory(char category) {
        this.category = category;
    }
// Method to check the availability of an item
    public boolean checkAvailableOfAnItem(LibraryManagementSystem obj){
        if(obj.getAvailableQuantity() > 0 ){
            return true ;
        }
        else{
            return false ;
        }
    }
    // Method to display the info of the object
   public void displayInfoOfObject(LibraryManagementSystem obj){
        System.out.println("ISBN : " + obj.getISBN());
        System.out.println("Available Quantity : " + obj.getAvailableQuantity());
        System.out.println("Category : " + obj.getCategory());
        System.out.println("Date : " + obj.getDate());
    }
    //Method to remove an object from the library
    public void removeObjectFromArrayList(LibraryManagementSystem obj){
        countOfItems--;
    }
}

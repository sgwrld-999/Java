package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Date;

public class Books extends LibraryManagementSystem{
    public String authorOfTheBook ;
    public String titleOfTheBook ;
    public Date publicationDateOfTheBook ;
    static int countOFBooks = 0 ;
    static ArrayList<Books> booksArrayList = new ArrayList<Books>();
    public Books(){} // Default constructor
    public Books(String authorOfTheBook, String titleOfTheBook, Date publicationDateOfTheBook) {
        this.authorOfTheBook = authorOfTheBook;
        this.titleOfTheBook = titleOfTheBook;
        this.publicationDateOfTheBook = publicationDateOfTheBook;
        countOFBooks++ ;
    }// Parameterized constructor
    // Getter and Setter methods

    public String getAuthorOfTheBook() {
        return authorOfTheBook;
    }

    public void setAuthorOfTheBook(String authorOfTheBook) {
        this.authorOfTheBook = authorOfTheBook;
    }

    public String getTitleOfTheBook() {
        return titleOfTheBook;
    }

    public void setTitleOfTheBook(String titleOfTheBook) {
        this.titleOfTheBook = titleOfTheBook;
    }

    public static int getCountOFBooks() {
        return countOFBooks;
    }

    public Date getPublicationDateOfTheBook() {
        return publicationDateOfTheBook;
    }

    public void setPublicationDateOfTheBook(Date publicationDateOfTheBook) {
        this.publicationDateOfTheBook = publicationDateOfTheBook;
    }
    // Method to display the info of the object
    public void displayInfoOfObject(Books obj){
        super.displayInfoOfObject(obj);
        System.out.println("Author of the book : " + obj.getAuthorOfTheBook());
        System.out.println("Title of the book : " + obj.getTitleOfTheBook());
        System.out.println("Publication date of the book : " + obj.getPublicationDateOfTheBook());
    }
    //Method to remove an object from the array list
    public void removeObjectFromArrayList(Books obj){
        countOFBooks--;
        booksArrayList.remove(obj);
    }
    public void addBookToArrayList(Books obj){
        booksArrayList.add(obj);
    }
}

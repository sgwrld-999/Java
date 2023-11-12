package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Date;

public class Magazine extends LibraryManagementSystem{

    public String authorOfTheMagazine ;
    public String titleOfTheMagazine ;
    public Date publicationDateOfTheMagazine ;
    static int countOfMagazines = 0 ;
    static ArrayList<Magazine> magazineArrayList = new ArrayList<Magazine>();
    public Magazine(){} // Default constructor
    public Magazine(Date date , String ISBN , int availableQuantity,char category,String authorOfTheMagazine, String titleOfTheMagazine, Date publicationDateOfTheMagazine) {
        super(date,ISBN, availableQuantity,category);
        this.authorOfTheMagazine = authorOfTheMagazine;
        this.titleOfTheMagazine = titleOfTheMagazine;
        this.publicationDateOfTheMagazine = publicationDateOfTheMagazine;
        countOfMagazines++ ;
    }// Parameterized constructor
    // Getter and Setter methods

    public String getAuthorOfTheMagazine() {
        return authorOfTheMagazine;
    }

    public static int getCountOfMagazines() {
        return countOfMagazines;
    }

    public void setAuthorOfTheMagazine(String authorOfTheMagazine) {
        this.authorOfTheMagazine = authorOfTheMagazine;
    }

    public String getTitleOfTheMagazine() {
        return titleOfTheMagazine;
    }

    public void setTitleOfTheMagazine(String titleOfTheMagazine) {
        this.titleOfTheMagazine = titleOfTheMagazine;
    }

    public Date getPublicationDateOfTheMagazine() {
        return publicationDateOfTheMagazine;
    }

    public void setPublicationDateOfTheMagazine(Date publicationDateOfTheMagazine) {
        this.publicationDateOfTheMagazine = publicationDateOfTheMagazine;
    }
    // Method to display the info of the object
    public void displayInfoOfObject(Magazine obj){
        super.displayInfoOfObject(obj);
        System.out.println("Author of the magazine : " + obj.getAuthorOfTheMagazine());
        System.out.println("Title of the magazine : " + obj.getTitleOfTheMagazine());
        System.out.println("Publication date of the magazine : " + obj.getPublicationDateOfTheMagazine());
    }
    //Method to remove an object from the array list
    public void removeObjectFromArrayList(Magazine obj){
        countOfMagazines--;
        magazineArrayList.remove(obj);
    }
}

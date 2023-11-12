package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Date;

public class NewsPaper extends LibraryManagementSystem{
    public String pressOfTheNewsPaper ;
    public String titleOfTheNewsPaper ;
    public Date publicationDateOfTheNewsPaper ;
    static int countOfNewsPapers = 0 ;
    static ArrayList<NewsPaper> newsPaperArrayList = new ArrayList<NewsPaper>();
    public NewsPaper(){} // Default constructor
    public NewsPaper(Date date , String ISBN , int availableQuantity,char category,String pressOfTheNewsPaper, String titleOfTheNewsPaper, Date publicationDateOfTheNewsPaper) {
        super(date,
                ISBN,
                availableQuantity,
                category);
        this.pressOfTheNewsPaper = pressOfTheNewsPaper;
        this.titleOfTheNewsPaper = titleOfTheNewsPaper;
        this.publicationDateOfTheNewsPaper = publicationDateOfTheNewsPaper;
        countOfNewsPapers++ ;
    }// Parameterized constructor

    public static int getCountOfNewsPapers() {
        return countOfNewsPapers;
    }

    // Getter and Setter methods
    public String getPressOfTheNewsPaper() {
        return pressOfTheNewsPaper;
    }

    public void setPressOfTheNewsPaper(String pressOfTheNewsPaper) {
        this.pressOfTheNewsPaper = pressOfTheNewsPaper;
    }

    public String getTitleOfTheNewsPaper() {
        return titleOfTheNewsPaper;
    }

    public void setTitleOfTheNewsPaper(String titleOfTheNewsPaper) {
        this.titleOfTheNewsPaper = titleOfTheNewsPaper;
    }

    public Date getPublicationDateOfTheNewsPaper() {
        return publicationDateOfTheNewsPaper;
    }

    public void setPublicationDateOfTheNewsPaper(Date publicationDateOfTheNewsPaper) {
        this.publicationDateOfTheNewsPaper = publicationDateOfTheNewsPaper;
    }
    // Method to display the info of the object
    public void displayInfoOfObject(NewsPaper obj){
        super.displayInfoOfObject(obj);
        System.out.println("Press of the newspaper : " + obj.getPressOfTheNewsPaper());
        System.out.println("Title of the newspaper : " + obj.getTitleOfTheNewsPaper());
        System.out.println("Publication date of the newspaper : " + obj.getPublicationDateOfTheNewsPaper());
    }
    //Method to remove an object from the array list
    public void removeObjectFromArrayList(NewsPaper obj){
        countOfNewsPapers--;
        newsPaperArrayList.remove(obj);
    }
}

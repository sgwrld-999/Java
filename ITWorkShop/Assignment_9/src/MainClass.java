import java.lang.reflect.Array;
import java.util.*;
import LibraryManagementSystem.*;
public class MainClass {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Books books = new Books();
        Magazine magazine = new Magazine();
        NewsPaper newsPaper = new NewsPaper();
        do{
            System.out.println("Welcome to the library management system");
            System.out.println("Menu is displayed below");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a magazine");
            System.out.println("3. Add a newspaper");
        }while(true){
            System.out.println("Enter the choice");
            int choice = scanner.nextInt();
            if(choice == 1){
               bookInput();
            }
            else if(choice == 2){
//                magazine.addMagazine();
            }
            else if(choice == 3){
//                newsPaper.addNewsPaper();
            }
            else{
                System.out.println("Invalid choice");
            }
        };
    }
    public static void bookInput(){
        System.out.println("Enter the author of the book");
        String authorOfTheBook = scanner.nextLine();
        System.out.println("Enter the title of the book");
        String titleOfTheBook = scanner.nextLine();
        System.out.println("Enter the publication date of the book");
        Date publicationDateOfTheBook ;
        System.out.println("Enter the date in the format of yyyy-mm-dd");
        String temp = scanner.nextLine();
        String[] tempArray = temp.split("-");
        int year = Integer.parseInt(tempArray[0]);
        int month = Integer.parseInt(tempArray[1]);
        int day = Integer.parseInt(tempArray[2]);
        publicationDateOfTheBook = new Date(year,month,day);
        System.out.println("Enter the ISBN of the book of 6 Digits : ");
        String ISBN = scanner.nextLine();
        for(int i = 0 ; i < ISBN.length() ; i++){
            if(ISBN.charAt(i) >= '0' && ISBN.charAt(i) <= '9'){
                continue;
            } else if (ISBN.charAt(i) >= 'a' && ISBN.charAt(i) <= 'z'){
                continue;
            } else if (ISBN.charAt(i) >= 'A' && ISBN.charAt(i) <= 'Z'){
                continue;
            } else {
                System.out.println("Invalid ISBN");break;
            }
        }
        System.out.println("Enter the available quantity of the book");
        int availableQuantity = scanner.nextInt();
        Books books = new Books(authorOfTheBook,titleOfTheBook,publicationDateOfTheBook);
        return ;
    }
}

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//class LibraryItem {
//    String title;
//    String author;
//    String publicationDate;
//    String ISBN;
//    int availableQuantity;
//
//    public LibraryItem(String title, String author, String publicationDate, String ISBN, int availableQuantity) {
//        this.title = title;
//        this.author = author;
//        this.publicationDate = publicationDate;
//        this.ISBN = ISBN;
//        this.availableQuantity = availableQuantity;
//    }
//
//    public void displayInfo() {
//        System.out.println("Title: " + title);
//        System.out.println("Author: " + author);
//        System.out.println("Publication Date: " + publicationDate);
//        System.out.println("ISBN: " + ISBN);
//        System.out.println("Available Quantity: " + availableQuantity);
//    }
//
//    public boolean validate() {
//        if (!ISBN.matches("^[a-zA-Z0-9]{10}$")) {
//            System.out.println("Invalid ISBN format. ISBN should be 10 characters long and alphanumeric.");
//            return false;
//        }
//
//        if (!publicationDate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
//            System.out.println("Invalid publication date format. It should be in yyyy-mm-dd format.");
//            return false;
//        }
//
//        if (availableQuantity < 0) {
//            System.out.println("Invalid available quantity. It should be a non-negative integer.");
//            return false;
//        }
//
//        return true;
//    }
//}
//
//class Book extends LibraryItem {
//    public Book(String title, String author, String publicationDate, String ISBN, int availableQuantity) {
//        super(title, author, publicationDate, ISBN, availableQuantity);
//    }
//}
//
//class Magazine extends LibraryItem {
//    public Magazine(String title, String author, String publicationDate, String ISBN, int availableQuantity) {
//        super(title, author, publicationDate, ISBN, availableQuantity);
//    }
//}
//
//class Newspaper extends LibraryItem {
//    public Newspaper(String title, String author, String publicationDate, String ISBN, int availableQuantity) {
//        super(title, author, publicationDate, ISBN, availableQuantity);
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ArrayList<LibraryItem> libraryItems = new ArrayList<>();
//
//        while (true) {
//            System.out.println("Enter the type of item (Book, Magazine, Newspaper):");
//            String itemType = scanner.nextLine();
//
//            if (itemType.equalsIgnoreCase("book") || itemType.equalsIgnoreCase("magazine")
//                    || itemType.equalsIgnoreCase("newspaper")) {
//                System.out.println("Enter title:");
//                String title = scanner.nextLine();
//
//                System.out.println("Enter author:");
//                String author = scanner.nextLine();
//
//                System.out.println("Enter publication date (yyyy-mm-dd):");
//                String publicationDate = scanner.nextLine();
//
//                System.out.println("Enter ISBN (10 characters alphanumeric):");
//                String ISBN = scanner.nextLine();
//
//                System.out.println("Enter available quantity:");
//                int availableQuantity = Integer.parseInt(scanner.nextLine());
//
//                LibraryItem newItem;
//
//                if (itemType.equalsIgnoreCase("book")) {
//                    newItem = new Book(title, author, publicationDate, ISBN, availableQuantity);
//                } else if (itemType.equalsIgnoreCase("magazine")) {
//                    newItem = new Magazine(title, author, publicationDate, ISBN, availableQuantity);
//                } else {
//                    newItem = new Newspaper(title, author, publicationDate, ISBN, availableQuantity);
//                }
//
//                if (newItem.validate()) {
//                    libraryItems.add(newItem);
//                    System.out.println("Item added successfully.");
//                } else {
//                    System.out.println("Item validation failed. Please re-enter the details.");
//                }
//            } else {
//                System.out.println("Invalid item type. Please enter 'Book', 'Magazine', or 'Newspaper'.");
//            }
//
//            System.out.println("Do you want to add another item? (yes/no):");
//            String continueInput = scanner.nextLine();
//
//            if (continueInput.equalsIgnoreCase("no")) {
//                break;
//            }
//        }
//
//        // Sort library items by title
//        Collections.sort(libraryItems, (item1, item2) -> item1.title.compareTo(item2.title));
//
//        System.out.println("Library items sorted by title:");
//        for (LibraryItem item : libraryItems) {
//            item.displayInfo();
//            System.out.println();
//        }
//
//        // Sort library items by publication date
//        Collections.sort(libraryItems, (item1, item2) -> item1.publicationDate.compareTo(item2.publicationDate));
//
//        System.out.println("Library items sorted by publication date:");
//        for (LibraryItem item : libraryItems) {
//            item.displayInfo();
//            System.out.println();
//        }
//    }
//}
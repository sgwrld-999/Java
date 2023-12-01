import java.util.ArrayList;
import java.util.Scanner;

class User {
    String name, dateOfBirth, address, PAN;

    User(String name, String dateOfBirth, String address, String PAN) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.PAN = PAN;
    }
}

class SuperUser extends User {
    String superUserID, password, dateOfJoining;
    double salary;
    int permissibleOperations;

    SuperUser(String name, String dateOfBirth, String address, String PAN, String superUserID, String password,
              String dateOfJoining, double salary, int permissibleOperations) {
        super(name, dateOfBirth, address, PAN);
        this.superUserID = superUserID;
        this.password = password;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        this.permissibleOperations = permissibleOperations;
    }

    void addNewStock(Item item, ArrayList<Item> itemList) {
        // Implementation to add new stock
        itemList.add(item);
        System.out.println("New stock added successfully.");
    }

    void deleteStock(int itemCode, ArrayList<Item> itemList) {
        // Implementation to delete stock
        for (Item item : itemList) {
            if (item.getItemCode() == itemCode) {
                if (item.getAvailableQty() > 0) {
                    System.out.println("Cannot delete item with non-zero available quantity.");
                    return;
                }
                itemList.remove(item);
                System.out.println("Stock deleted successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    void modifyStock(int itemCode, double newPrice, int newAvailableQty, ArrayList<Item> itemList) {
        // Implementation to modify stock
        for (Item item : itemList) {
            if (item.getItemCode() == itemCode) {
                item.setPrice(newPrice);
                item.setAvailableQty(newAvailableQty);
                System.out.println("Stock modified successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }
}

class NormalUser extends User {
    String userID, dateOfJoining;
    double salary;
    int dutyHourPerDay;

    NormalUser(String name, String dateOfBirth, String address, String PAN, String userID, String dateOfJoining,
               double salary, int dutyHourPerDay) {
        super(name, dateOfBirth, address, PAN);
        this.userID = userID;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        this.dutyHourPerDay = dutyHourPerDay;
    }

    void sellItem(int itemCode, int quantity, ArrayList<Item> itemList, ArrayList<Sell> sellList) {
        // Implementation to sell item
        for (Item item : itemList) {
            if (item.getItemCode() == itemCode) {
                if (item.getAvailableQty() >= quantity) {
                    item.setAvailableQty(item.getAvailableQty() - quantity);
                    Sell sell = new Sell(itemCode, quantity, item.getPrice() * quantity);
                    sellList.add(sell);
                    System.out.println("Item sold successfully.");
                    return;
                } else {
                    System.out.println("Insufficient stock available.");
                    return;
                }
            }
        }
        System.out.println("Item not found.");
    }

    void returnItem(int itemCode, int quantity, ArrayList<Item> itemList, ArrayList<Return> returnList) {
        // Implementation to return item
        for (Item item : itemList) {
            if (item.getItemCode() == itemCode && item instanceof NonConsumables) {
                item.setAvailableQty(item.getAvailableQty() + quantity);
                Return returnItem = new Return(itemCode, quantity, item.getPrice() * quantity);
                returnList.add(returnItem);
                System.out.println("Item returned successfully.");
                return;
            }
        }
        System.out.println("Non-consumable item not found.");
    }

    void displayStock(int itemCode, ArrayList<Item> itemList) {
        // Implementation to display stock
        for (Item item : itemList) {
            if (item.getItemCode() == itemCode) {
                System.out.println("Item Code: " + item.getItemCode());
                System.out.println("Price: " + item.getPrice());
                System.out.println("Available Quantity: " + item.getAvailableQty());
                if (item instanceof Consumables) {
                    System.out.println("Date of Expiry: " + ((Consumables) item).getDateOfExpiry());
                } else if (item instanceof NonConsumables) {
                    System.out.println("Return Count: " + ((NonConsumables) item).getReturnCount());
                }
                return;
            }
        }
        System.out.println("Item not found.");
    }

    void displayToBeExpiredItems(int m, ArrayList<Item> itemList) {
        // Implementation to display consumable items to be expired
        // (Assuming dateOfExpiry is stored in the format "YYYY-MM-DD")
        System.out.println("Consumable items to be expired after " + m + " months:");
        for (Item item : itemList) {
            if (item instanceof Consumables) {
                String[] expiryDateParts = ((Consumables) item).getDateOfExpiry().split("-");
                int expiryYear = Integer.parseInt(expiryDateParts[0]);
                int expiryMonth = Integer.parseInt(expiryDateParts[1]);

                // Assuming the current date is January 2023
                int currentYear = 2023;
                int currentMonth = 1;

                if ((expiryYear * 12 + expiryMonth) - (currentYear * 12 + currentMonth) <= m) {
                    System.out.println("Item Code: " + item.getItemCode());
                    System.out.println("Date of Expiry: " + ((Consumables) item).getDateOfExpiry());
                }
            }
        }
    }

    void displaySell(String startDate, String endDate, ArrayList<Sell> sellList) {
        // Implementation to display sold items within the date range
        System.out.println("Sell details within the date range " + startDate + " to " + endDate + ":");
        for (Sell sell : sellList) {
            if (sell.getDateOfSell().compareTo(startDate) >= 0 && sell.getDateOfSell().compareTo(endDate) <= 0) {
                System.out.println("Date of Sell: " + sell.getDateOfSell());
                System.out.println("Item Code: " + sell.getItemCode());
                System.out.println("Quantity: " + sell.getQuantity());
                System.out.println("Total Amount: " + sell.getTotalAmount());
            }
        }
    }
}

class Item {
    int itemCode;
    double price;
    int availableQty;

    Item(int itemCode, double price, int availableQty) {
        this.itemCode = itemCode;
        this.price = price;
        this.availableQty = availableQty;
    }

    int getItemCode() {
        return itemCode;
    }

    double getPrice() {
        return price;
    }

    int getAvailableQty() {
        return availableQty;
    }

    void setPrice(double price) {
        this.price = price;
    }

    void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }
}

class Consumables extends Item {
    String dateOfExpiry;

    Consumables(int itemCode, double price, int availableQty, String dateOfExpiry) {
        super(itemCode, price, availableQty);
        this.dateOfExpiry = dateOfExpiry;
    }

    String getDateOfExpiry() {
        return dateOfExpiry;
    }
}

class NonConsumables extends Item {
    int returnCount;

    NonConsumables(int itemCode, double price, int availableQty, int returnCount) {
        super(itemCode, price, availableQty);
        this.returnCount = returnCount;
    }

    int getReturnCount() {
        return returnCount;
    }
}

class Sell {
    String dateOfSell;
    int itemCode, quantity;
    double totalAmount;

    Sell(int itemCode, int quantity, double totalAmount) {
        this.dateOfSell = "2023-01-01";  // Assuming a default date for simplicity
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    String getDateOfSell() {
        return dateOfSell;
    }

    int getItemCode() {
        return itemCode;
    }

    int getQuantity() {
        return quantity;
    }

    double getTotalAmount() {
        return totalAmount;
    }
}

class Return {
    String dateOfReturn;
    int itemCode, quantity;
    double returnAmount;

    Return(int itemCode, int quantity, double returnAmount) {
        this.dateOfReturn = "2023-01-01";  // Assuming a default date for simplicity
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.returnAmount = returnAmount;
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        SuperUser superUser = null;
        ArrayList<NormalUser> normalUsers = new ArrayList<>();
        ArrayList<Item> itemList = new ArrayList<>();
        ArrayList<Sell> sellList = new ArrayList<>();
        ArrayList<Return> returnList = new ArrayList<>();

        do {
            System.out.println("Main Menu:");
            System.out.println("1. Setup");
            System.out.println("2. SuperUser mode");
            System.out.println("3. NormalUser mode");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (superUser == null) {
                        System.out.print("Enter SuperUser details:\nName: ");
                        String name = scanner.next();
                        System.out.print("Date of Birth: ");
                        String dateOfBirth = scanner.next();
                        System.out.print("Address: ");
                        String address = scanner.next();
                        System.out.print("PAN: ");
                        String PAN = scanner.next();
                        System.out.print("SuperUserID: ");
                        String superUserID = scanner.next();
                        System.out.print("Password: ");
                        String password = scanner.next();
                        System.out.print("Date of Joining: ");
                        String dateOfJoining = scanner.next();
                        System.out.print("Salary: ");
                        double salary = scanner.nextDouble();
                        System.out.print("Permissible Operations: ");
                        int permissibleOperations = scanner.nextInt();

                        superUser = new SuperUser(name, dateOfBirth, address, PAN, superUserID, password,
                                dateOfJoining, salary, permissibleOperations);
                        System.out.println("SuperUser created successfully.");
                    } else {
                        System.out.println("Setup already completed. Cannot re-run setup.");
                    }
                    break;

                case 2:
                    if (superUser == null) {
                        System.out.println("Setup not completed. Cannot enter SuperUser mode.");
                        break;
                    }

                    System.out.print("Enter SuperUserID: ");
                    String enteredSuperUserID = scanner.next();
                    System.out.print("Enter password: ");
                    String enteredPassword = scanner.next();

                    if (enteredSuperUserID.equals(superUser.superUserID) && enteredPassword.equals(superUser.password)) {
                        int superUserChoice;
                        do {
                            System.out.println("\nSuperUser mode:");
                            System.out.println("1. Add New Stock");
                            System.out.println("2. Delete Stock");
                            System.out.println("3. Modify Stock");
                            System.out.println("4. Back to Main Menu");
                            System.out.print("Enter your choice: ");
                            superUserChoice = scanner.nextInt();

                            switch (superUserChoice) {
                                case 1:
                                    System.out.print("Enter item details:\nItem Code: ");
                                    int itemCode = scanner.nextInt();
                                    System.out.print("Price: ");
                                    double price = scanner.nextDouble();
                                    System.out.print("Available Quantity: ");
                                    int availableQty = scanner.nextInt();

                                    if (itemCode % 2 == 0) {
                                        System.out.print("Date of Expiry (YYYY-MM-DD): ");
                                        String dateOfExpiry = scanner.next();
                                        Consumables consumables = new Consumables(itemCode, price, availableQty, dateOfExpiry);
                                        superUser.addNewStock(consumables, itemList);
                                    } else {
                                        NonConsumables nonConsumables = new NonConsumables(itemCode, price, availableQty, 0);
                                        superUser.addNewStock(nonConsumables, itemList);
                                    }
                                    break;

                                case 2:
                                    System.out.print("Enter item code to delete: ");
                                    int deleteItemCode = scanner.nextInt();
                                    superUser.deleteStock(deleteItemCode, itemList);
                                    break;

                                case 3:
                                    System.out.print("Enter item code to modify: ");
                                    int modifyItemCode = scanner.nextInt();
                                    System.out.print("Enter new price: ");
                                    double newPrice = scanner.nextDouble();
                                    System.out.print("Enter new available quantity: ");
                                    int newAvailableQty = scanner.nextInt();
                                    superUser.modifyStock(modifyItemCode, newPrice, newAvailableQty, itemList);
                                    break;

                                case 4:
                                    break;

                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                                    break;
                            }
                        } while (superUserChoice != 4);

                    } else {
                        System.out.println("SuperUserID or password incorrect. Exiting SuperUser mode.");
                    }
                    break;

                case 3:
                    if (superUser == null) {
                        System.out.println("Setup not completed. Cannot enter NormalUser mode.");
                        break;
                    }

                    System.out.print("Enter NormalUserID: ");
                    String enteredNormalUserID = scanner.next();

                    boolean userExists = false;
                    for (NormalUser normalUser : normalUsers) {
                        if (normalUser.userID.equals(enteredNormalUserID)) {
                            userExists = true;
                            int normalUserChoice;
                            do {
                                System.out.println("\nNormalUser mode:");
                                System.out.println("1. Sell Item");
                                System.out.println("2. Return Item");
                                System.out.println("3. Display Stock");
                                System.out.println("4. Display To Be Expired Items");
                                System.out.println("5. Display Sell");
                                System.out.println("6. Back to Main Menu");
                                System.out.print("Enter your choice: ");
                                normalUserChoice = scanner.nextInt();

                                switch (normalUserChoice) {
                                    case 1:
                                        System.out.print("Enter item code to sell: ");
                                        int sellItemCode = scanner.nextInt();
                                        System.out.print("Enter quantity to sell: ");
                                        int sellQuantity = scanner.nextInt();
                                        normalUser.sellItem(sellItemCode, sellQuantity, itemList, sellList);
                                        break;

                                    case 2:
                                        System.out.print("Enter item code to return: ");
                                        int returnItemCode = scanner.nextInt();
                                        System.out.print("Enter quantity to return: ");
                                        int returnQuantity = scanner.nextInt();
                                        normalUser.returnItem(returnItemCode, returnQuantity, itemList, returnList);
                                        break;

                                    case 3:
                                        System.out.print("Enter item code to display: ");
                                        int displayItemCode = scanner.nextInt();
                                        normalUser.displayStock(displayItemCode, itemList);
                                        break;

                                    case 4:
                                        System.out.print("Enter the number of months to check for expiry: ");
                                        int monthsToCheck = scanner.nextInt();
                                        normalUser.displayToBeExpiredItems(monthsToCheck, itemList);
                                        break;

                                    case 5:
                                        System.out.print("Enter start date (YYYY-MM-DD): ");
                                        String startDate = scanner.next();
                                        System.out.print("Enter end date (YYYY-MM-DD): ");
                                        String endDate = scanner.next();
                                        normalUser.displaySell(startDate, endDate, sellList);
                                        break;

                                    case 6:
                                        break;

                                    default:
                                        System.out.println("Invalid choice. Please enter a valid option.");
                                        break;
                                }
                            } while (normalUserChoice != 6);
                            break;
                        }
                    }

                    if (!userExists) {
                        System.out.println("NormalUser not found. Exiting NormalUser mode.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the Inventory Management System. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}
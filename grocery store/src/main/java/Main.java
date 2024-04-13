import com.grocery.store.appl.data.dao.item.ItemDao;
import com.grocery.store.appl.data.dao.item.impl.ItemDaoImpl;
import com.grocery.store.appl.model.item.Item;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ItemDao itemDao = new ItemDaoImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add item");
            System.out.println("2. Get all items");
            System.out.println("3. Get item by id");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Item item = new Item();
                    System.out.print("Enter id: ");
                    item.setId(scanner.nextLine());
                    System.out.print("Enter title: ");
                    item.setTitle(scanner.nextLine());
                    System.out.print("Enter genre: ");
                    item.setGenre(scanner.nextLine());
                    System.out.print("Enter copies: ");
                    item.setCopies(scanner.nextInt());
                    scanner.nextLine();
                    boolean isAdded = itemDao.addItem(item);
                    System.out.println("Item added: " + isAdded);
                    break;
                case 2:
                    List<Item> items = itemDao.getAllItems();
                    System.out.println("All items:");
                    for (Item i : items) {
                        System.out.println(i.getId() + " - " + i.getTitle() + " - " + i.getGenre() + " - " + i.getCopies());
                    }
                    break;
                case 3:
                    System.out.print("Enter id: ");
                    Item itemById = itemDao.getItemById(scanner.nextLine());
                    System.out.println("Item by id:");
                    System.out.println(itemById.getId() + " - " + itemById.getTitle() + " - " + itemById.getGenre() + " - " + itemById.getCopies());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
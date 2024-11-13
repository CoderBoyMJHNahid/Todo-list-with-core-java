package app;
import java.util.ArrayList;
import java.util.Scanner;

public class List {

    private ArrayList<String> list = new ArrayList<String>();

    public Scanner scan = new Scanner(System.in);

    public void listDisplay() {
        System.out.print("\033[H\033[2J");
        if (list.size() == 0) {
            System.out.println("No List Found!");
        } else {
            System.out.println("Your List:");
            int serial_number = 1;
            for (String item : list) {
                System.out.println(serial_number + " " + item);
                serial_number++;
            }
        }

        System.out.println("Press 1 to add create list");
        System.out.println("Press 2 to update");
        System.out.println("Press 3 for delete");
        this.getUserOption();
    }

    private void addList() {
        System.out.print("\033[H\033[2J");
        System.out.print("Enter you list item: ");
        scan.nextLine();
        String item = scan.nextLine();
        list.add(item);
        System.out.print("\033[H\033[2J");
        System.out.println("Successfully added your item in our todo list");
        System.out.println("Press 0 to go to main menu");
        System.out.println("Press 1 to add more item");
        int option = scan.nextInt();
        if (option == 1) {
            addList();
        } else if (option == 0) {
            listDisplay();
        } else {
            System.out.println("Invalid Option");
            listDisplay();
        }
    }

    private void updateList() {
        System.out.print("Enter your list item id: ");
        int id = scan.nextInt();
        System.out.print("What is the new name of list item:  ");
        scan.nextLine();
        String update_item = scan.nextLine();

        list.set((id - 1), update_item);

        listDisplay();

    }

    private void deleteList() {
        System.out.print("Enter your list item id: ");
        int id = scan.nextInt();

        list.remove((id - 1));

        listDisplay();

    }

    private void getUserOption() {

        System.out.print("Enter your Choose: ");
        int choose = scan.nextInt();
        
        switch (choose) {
            case 1:
                addList();
                break;
            case 2:
                updateList();
                break;
            case 3:
                deleteList();
                break;
            default:
                System.out.println("Invalid Input");
                listDisplay();
        }
    }

    
}

import java.util.*;

class Main {
    public static void main(String args[]) {
        int choice;
        Scanner sc = new Scanner(System.in);
        InventoryManager obj=new InventoryManager();
        try{
        while (true) {
            System.out.println("1 Add Items");
            System.out.println("2 Edit Items");
            System.out.println("3 Remove Items");
            System.out.println("4 Search Items");
            System.out.println("5 View Items");
            System.out.println("6 View History");
            System.out.println("7 Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Category of Item");
                    String s1 = sc.next();
                    System.out.println("Enter the Id of Item");
                    int v1 = sc.nextInt();
                    System.out.println("Enter the name of Item");
                    String n1 = sc.next();
                    System.out.println("Enter the price of Item");
                    double d1 = sc.nextDouble();
                    System.out.println("Enter the quantity of Item");
                    int q1 = sc.nextInt();
                    obj.addItems(s1, v1, n1, d1, q1);
                    break;

                case 2:
                    System.out.println("Enter the name of Item");
                    String s2 = sc.next();
                    obj.editItem(s2);
                    break;

                case 3:
                    System.out.println("Enter the Category of Item");
                    String s3 = sc.next();
                    System.out.println("Enter the Id of Item");
                    int d3 = sc.nextInt();
                    obj.removeItem(s3, d3);
                    break;

                case 4:
                    System.out.println("Enter the name of Item");
                    String s4 = sc.next();
                    obj.searchItem(s4);
                    break;

                case 5:
                    System.out.println("------------------Inventory Report----------");
                    obj.displayIn();
                    break;

                case 6:
                    System.out.println("-------------History------------------");
                    obj.history();
                    break;

                case 7:
                    System.exit(0);

                default:
                    System.out.println("Enter the valid Option");
            }
        }
    }catch(Exception e){System.out.println("Process will give an error");}
    }
}
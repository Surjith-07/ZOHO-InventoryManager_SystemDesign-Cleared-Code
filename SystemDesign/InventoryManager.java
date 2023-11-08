import java.util.*;


public class InventoryManager {

    Map<String, List<Item>> inventory;
    Map<String, List<Item>> history;
    Scanner sc = new Scanner(System.in);

    public InventoryManager() {
        this.inventory = new TreeMap<>();
        this.history = new HashMap<>();

        inventory.put("Electronics", new ArrayList<>(Arrays.asList(new Item(1, "earbuds", 1600.00, 1))));
        inventory.put("Cloths", new ArrayList<>(Arrays.asList(new Item(1, "jeans", 800.00, 1))));
    }

    public void addItems(String catogry, int ItemId, String Itemname, double price, int quan) {
        if (!inventory.containsKey(catogry)) {
            System.out.println("This kind Of Category Not Available Try Valid..............");
        }
        inventory.computeIfAbsent(catogry, k -> new ArrayList<>()).add(new Item(ItemId, Itemname, price, quan));
        history.computeIfAbsent("Added Items", k -> new ArrayList<>()).add(new Item(ItemId, Itemname, price, quan));
        System.out.println("Item Added Successfully..!!");
    }

    public void removeItem(String catogry, int ItemId) {

        if (!inventory.containsKey(catogry)) {
            System.out.println("This kind Of Category Not Available Try Valid..............");
        }

        for (String ele : inventory.keySet()) {
            if (catogry.equals(ele)) {
                List<Item> list = inventory.getOrDefault(ele, new ArrayList<>());
                if (list.isEmpty()) {
                    System.out.println("Invalid Item....");
                    break;
                }
                for (Item subL : list) {
                    if (ItemId == subL.getItemId()) {
                        history.computeIfAbsent("Removed Items", k -> new ArrayList<>()).add(subL);
                        list.remove(subL);
                        break;
                    }
                }
                inventory.computeIfAbsent(catogry, k -> new ArrayList<>()).addAll(list);
            }
        }
        displayIn();
        System.out.println("Item Removed Successfully...!!");
    }

    public void searchItem(String name) {
        int count = 1;
        for (String ele : inventory.keySet()) {
            for (Item it : inventory.get(ele)) {
                if (it.getItemname().equals(name)) {
                    it.display();
                    count = 0;
                }
            }
        }

        if (count == 1) {
            System.out.println("Item not found...");
        }
    }

    public void editItem(String name) {
        Item val = new Item();
        int count = 0;
        for (String ele : inventory.keySet()) {
            for (Item it : inventory.get(ele)) {
                if (it.getItemname().equals(name)) {
                    val = it;
                    inventory.get(ele).remove(it);
                    val = update(val);
                    inventory.get(ele).add(val);
                    history.computeIfAbsent("Edited Items", k -> new ArrayList<>()).add(val);
                    count = 1;
                    System.out.println("Updated Items....");
                    displayIn();
                    break;
                }
            }
        }

        if (count == 0) {
            System.out.println("Item not found.....");
            return;
        }
    }

    public Item update(Item item) {
        char ch;
        System.out.println("a.For Update ItemId");
        System.out.println("b.For Update Itemname");
        System.out.println("c.For Update Itemprice");
        System.out.println("d.For Update ItemQuantity");
        ch = sc.next().charAt(0);
        switch (ch) {
            case 'a':
                System.out.println("Enter the Updated ItemId : ");
                int id = sc.nextInt();
                item.setItemId(id);
                break;
            case 'b':
                System.out.println("Enter the Updated Itemname : ");
                String Iname = sc.next();
                item.setItemname(Iname);
                break;
            case 'c':
                System.out.println("Enter the Updated ItemPrice : ");
                double d = sc.nextDouble();
                item.setprice(d);
                break;
            case 'd':
                System.out.println("Enter the Updated Quantity : ");
                int qua = sc.nextInt();
                item.setquantity(qua);
                break;
            default:
                System.out.println("Invalid Option");
        }
        return item;
    }

    public void displayIn() {
        char choice;
        System.out.println("a.For Display OverAll");
        System.out.println("b.For Display CatogryWise");
        System.out.println("c.For Display PriceWise");
        choice = sc.next().charAt(0);
        switch (choice) {
            case 'a':
                for (String ele : inventory.keySet()) {
                    System.out.println("Catogry : " + ele + "\n");
                    print(ele);
                    System.out.println();
                }
                break;
            case 'b':
                System.out.println("Enter the Catogry name : ");
                String Iname = sc.next();
                print(Iname);
                break;
            case 'c':
                System.out.println("For Ascending Order 2\nFor Descending Order 1");
                int val=sc.nextInt();
                if(val==1){
                    pricewiseprint(-1);
                }else if(val==2){
                    pricewiseprint(1);
                }
                break;
            default:
                System.out.println("Invalid choice");
        }

    }

    public void pricewiseprint(int val){
        if(val<0){
        PriorityQueue<Item> pq=new PriorityQueue<>(new Comparator<Item>(){
            @Override
            public int compare(Item a,Item b){
                return Double.compare(b.getItemprice(), a.getItemprice());
            }
        });
        for(List<Item> item:inventory.values()){
            for(Item ele:item) pq.add(ele);
        }

        while(!pq.isEmpty()){
            pq.poll().display();
        }
    }else{
        PriorityQueue<Item> pq=new PriorityQueue<>(new Comparator<Item>(){
            @Override
            public int compare(Item a,Item b){
                return Double.compare(a.getItemprice(), b.getItemprice());
            }
        });
        for(List<Item> item:inventory.values()){
            for(Item ele:item) pq.add(ele);
        }

        while(!pq.isEmpty()){
           pq.poll().display();
        }
    }


    }
    public void print(String ele) {
        inventory.get(ele).forEach(y -> y.display());
    }

    public void history() {
        for (String ele : history.keySet()) {
            System.out.println("History : " + ele + "\n");
            history.get(ele).forEach(y -> y.display());
            System.out.println();
        }
    }

}

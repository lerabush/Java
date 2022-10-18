package second;

import java.util.ArrayList;

public class Task15 {

   public static class Invoice {
        public static class Item { // Открытый вложенный класс
            private String description;
            private int quantity;
            private double unitPrice;

            public Item(String description, int quantity, double unitPrice) {
                this.description = description;
                this.quantity = quantity;
                this.unitPrice = unitPrice;
            }

            public double price() {
                return quantity * unitPrice;
            }
            public void printPrice(){
                System.out.println(price());
            }

        }

        private ArrayList<Item> items = new ArrayList<>();

        public void add(Item item) {
            items.add(item);
        }
    }
    public static void main(String[] args){
       Invoice.Item newItem = new Invoice.Item("H&M",300,2);
       newItem.printPrice();
    }
}

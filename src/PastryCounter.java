public class PastryCounter {
    String flavors[] = {"pineapple", "mango", "chocolate", "strawberry", "black forest"};
    double price[] = {1.25, 3.35, 2.50, 2.50, 3.75};

    double totalCost;
    PastryCounter(String flavor,int quantity){
        int position = 0;

        for(int i = 0; i < flavors.length; i++){
            if(flavor == flavors[i]){
                position = i;
            }
        }
        totalCost = price[position] * quantity;
        System.out.println("Quantity: "+ quantity +"\n"+ " Price for Each Flavor: " + price[position] + " Total Cost: " + totalCost);
    }
}

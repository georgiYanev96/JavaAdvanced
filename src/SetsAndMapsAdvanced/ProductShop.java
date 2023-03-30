package SetsAndMapsAdvanced;
//Write a program that prints information about food shops in Sofia and the products they store.
//Until the "Revision" command you will receive an input in the format: "{shop}, {product}, {price}"
//Take in mind that if you receive a shop you already have received, you must collect its product information.
//Your output must be ordered by shop name and must be in the format:
//{shop}->
//Product: {product}, Price: {price}
//The price should be formated to one digit after the decimal point.

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> myMap = new TreeMap<>();
        while(true){
            String[] input = scanner.nextLine().split(", ");
            if(input[0].equals("Revision")){
                break;
            }
            if(!myMap.containsKey(input[0])){
                Map<String, Double> producAndPrice = new TreeMap<>();
                producAndPrice.put(input[1], Double.parseDouble(input[2]));
                myMap.put(input[0], producAndPrice);
            }else{
                Map<String, Double> implementedProducsAndPrices=  myMap.get(input[0]);
                implementedProducsAndPrices.put(input[1], Double.parseDouble(input[2]));
                myMap.put((input[0]), implementedProducsAndPrices);
            }
        }

        for (Map.Entry<String, Map<String, Double>> entry : myMap.entrySet()) {
            StringBuilder output = new StringBuilder();
            output.append(entry.getKey()).append("->").append(System.getProperty("line.separator"));
            for (Map.Entry<String, Double> product : entry.getValue().entrySet()) {
            output.append("Product: ").append(product.getKey()).append(", Price: ").append(product.getValue()).append("\n");
            }
            System.out.println(output);
        }

    }

}

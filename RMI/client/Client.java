import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.rmi.Naming;

public class Client {
    private static String name;
    private static ProductInter stub;
    private static double price, total=0.00, calTotal;
    public static void main(String [] args) {
        try{    
            // Get the reference of exported object from RMI registry
            // Locate the registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            ProductInter stub = (ProductInter) registry.lookup("");

            maininterface(registry, stub);

        }catch(Exception e){
            System.out.println("Error occured in client ..." + e);
        }
    }

    public static void maininterface(Registry registry, ProductInter stub){
        try{
            System.out.println("Welcome to VirtualRestaurant!");
            System.out.println("Choose item that you would like to pick up later");
    
            System.out.println("Item 1 | Drinks: cup of JAVA");
            System.out.println("Item 2 | Drinks: pINT of beer");
            System.out.println("Item 3 | Main: steak and shoeSTRING fries");
            System.out.println("Item 4 | Dessert: scOOP of ice cream");
            System.out.println("Item 5 | Dessert: freshly baked COOKIES");
    
            // Takes user input
            Scanner input = new Scanner(System.in);
            System.out.println("Please input item choice (1,2,3,4,or 5): ");
            int userInput = input.nextInt();

            price= stub.getPrice(userInput);

            System.out.println("Cost of selected food is :" + String.valueOf(price));
            calTotal = price;
    
            subInterface(registry, stub);
        } catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
        
    }

    private static void subInterface(Registry registry, ProductInter stub){
        try{
            
            Scanner input = new Scanner(System.in);
            System.out.println("    SEND ORDER IN OR ADD ANOTHER ITEM? ");
            System.out.println("    1 --> See menu and add item");
            System.out.println("    2 --> Get total and send order in");
            int subInput = input.nextInt();
            
            if (subInput == 1){
                maininterface(registry, stub);
            } else if (subInput == 2){
                System.out.println("Your total+tax is: $ " + stub.calculateTotal(calTotal) );
            }
        } catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
    }
}

import java.rmi.RemoteException;
import java.rmi.Remote;


public class ProductImpl implements ProductInter {
    // Attributes of product  
    public String foodItem, name, description;
    public double price, total, tax, calTotal;

    public ProductImpl() {
		super();
	}

    public double getPrice(int userInp){
        if (userInp == 1){
            price = 2.10;
            return price;
        } else if (userInp == 2){
            price = 3.50;
            return price;
        } else if (userInp == 3){
            price = 12.25;
            return price;
        } else if (userInp == 4){
            price = 5.75;
            return price;
        } else if (userInp == 5){
            price = 4.25;
            return price;
        } else{
            System.out.println("Selection not valid. Try again.");
        } 

        System.out.println("Price of chosen food item is " + price);
        return price;
    }

    public double calculateTotal(double price) throws RemoteException{
        double taxTranscation = price*0.13;
        calTotal = price + taxTranscation;
        return calTotal;
    }
}

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.Remote;

public interface ProductInter extends Remote{
    // Define the API
    public double getPrice(int userInput) throws RemoteException;
    public double calculateTotal(double total) throws RemoteException;
}

import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server{
    public static void main(String [] args){

        try{

            // Set hostname for the server using the javaProperty
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            System.out.println("Server has been started");

            // Create objects ysing implementation class
            ProductInter obj = new ProductImpl();

            // Export objects using Unicast.RemoteObject class
            ProductInter stub = (ProductInter) UnicastRemoteObject.exportObject(obj,0);

            // Register the exported RMI registry with some name
            // Client will use that name to get teh referent of those exported objects

            // Get the registry to register the object
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            registry.rebind("",stub);

            System.out.println("Exporting and Binding of objects has been completed");

        } catch (Exception e){
            System.out.println("Error detected in server....");
        }
    }
}
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.io.*;
public class Server extends UnicastRemoteObject implements IServer {
	public IClient client=null;	
	public Server() throws RemoteException {
		try {
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			Naming.rebind("rmi://127.0.0.1/Server",this);
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				String str = b.readLine();
				client.recebeClient(str);			
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void recebeServer(String str) throws RemoteException {
		System.out.println("Mensagem do Cliente: "+str);
	}
	public void getRef(IClient client) throws RemoteException {
		this.client=client;
	}
	public static void main(String args[]) {
		try {
			Server server = new Server();
			System.exit(0);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}



import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
public class Client extends UnicastRemoteObject implements IClient {
	public Client() throws RemoteException {
		try {
			IServer server = (IServer) Naming.lookup("rmi://127.0.0.1/Server");
			server.getRef(this);
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				String str = b.readLine();
				server.recebeServer(str);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void recebeClient(String str) throws RemoteException {
		System.out.println("Mensagem do Servidor: "+str);
	}
	public static void main(String args[]) {
		try {
			Client client = new Client();
			System.exit(0);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

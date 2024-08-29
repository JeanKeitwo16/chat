import java.rmi.*;
interface IServer extends Remote {
	public void getRef(IClient client) throws RemoteException;
	public void recebeServer(String str) throws RemoteException;
}

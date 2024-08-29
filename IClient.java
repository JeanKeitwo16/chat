import java.rmi.*;
interface IClient extends Remote {
	public void recebeClient(String str) throws RemoteException;
}

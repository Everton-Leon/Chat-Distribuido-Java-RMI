package chatrmi.stub;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatIF extends Remote{
    public void enviarMsg(String user, String msg) throws RemoteException;
    public void registrarCliente(ClientListenerIF cl, String nome) throws RemoteException;
    public String getAllMsg() throws RemoteException;
}

package chatrmi.servidor;

import chatrmi.stub.ChatIF;
import chatrmi.stub.ClientListenerIF;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

class ChatObj extends UnicastRemoteObject implements ChatIF{
    List<String> messageLog = new ArrayList<>();
    List<ClientListenerIF> clientes = new ArrayList<>();
    public ChatObj() throws RemoteException {
        super(); // Chama o construtor de UnicastRemoteObject
    }

    @Override
    public void enviarMsg(String user, String msg) throws RemoteException {
        String displayMsg = user+": "+msg;
        messageLog.add(displayMsg);
        for (var cliente : clientes) {
            cliente.notificar(displayMsg);
        }
    }

    @Override
    public String getAllMsg() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        for (String msg : messageLog) {
            sb.append(msg);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void registrarCliente(ClientListenerIF cl, String nome) throws RemoteException {
        clientes.add(cl);
        enviarMsg("Servidor", nome+" entrou no chat");
    }
}

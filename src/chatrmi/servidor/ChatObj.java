package chatrmi.servidor;

import chatrmi.stub.ChatIF;
import chatrmi.stub.ClientListenerIF;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class ChatObj extends UnicastRemoteObject implements ChatIF{   
    List<String> messageLog = new ArrayList<>();
    List<ClientListenerIF> clientes = new ArrayList<>();
    public ChatObj() throws RemoteException {
        super(); // Chama o construtor de UnicastRemoteObject
    }

    @Override
    public void enviarMsg(String user, String msg) throws RemoteException {
        Date dataHoraAtual = new Date();
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        String displayMsg = "[" + hora + "] " + user + ": "+msg;
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
        notifyAtualizarClientes();
        enviarMsg("Servidor", nome+" entrou no chat!");
    }
    
    @Override
    public void desconectCliente(ClientListenerIF cl) throws RemoteException {
        clientes.remove(cl);
        notifyAtualizarClientes();
        enviarMsg("Servidor", cl.getNome()+" saiu no chat!");
    }

    @Override
    public List<ClientListenerIF> getClientes() throws RemoteException {
        return clientes;
    }
    
    private void notifyAtualizarClientes() throws RemoteException {
        for (var cl : clientes) {
            cl.atualizarClientes();
        }
    }
}

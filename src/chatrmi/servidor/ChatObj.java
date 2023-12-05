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
    public void enviarMsg(String user, String msg, String cor) throws RemoteException {
        Date dataHoraAtual = new Date();
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        String displayMsg = "[" + hora + "] " + user + ": "+msg;
        messageLog.add(displayMsg);
        for (var cliente : clientes) {
            cliente.notificar(hora, user, msg, cor);
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
        atualizarClientesBroadcast();
        enviarMsg("Servidor", nome+" entrou no chat!", ClientListenerIF.ENTROU);
    }
    
    @Override
    public void desconectCliente(ClientListenerIF cl) throws RemoteException {
        clientes.remove(cl);
        atualizarClientesBroadcast();
        enviarMsg("Servidor", cl.getNome()+" saiu no chat!", ClientListenerIF.SAIU);
    }

    @Override
    public List<ClientListenerIF> getClientes() throws RemoteException {
        return clientes;
    }
    
    private void atualizarClientesBroadcast() throws RemoteException {
        for (var cl : clientes) {
            cl.atualizarClientes();
        }
    }
}

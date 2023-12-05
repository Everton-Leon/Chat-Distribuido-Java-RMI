/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package chatrmi.stub;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientListenerIF extends Remote {
    public void notificar(String hora, String user, String msg, String cor) throws RemoteException;
    public void atualizarClientes() throws RemoteException;
    public String getNome() throws RemoteException;
    
    public static final String MENSAGEM = "black";
    public static final String ENTROU = "green";
    public static final String SAIU = "red";
}

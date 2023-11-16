/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MeuObjetoRemoto extends UnicastRemoteObject implements MinhaInterfaceRemota{
    public MeuObjetoRemoto() throws RemoteException {
        super(); // Chama o construtor de UnicastRemoteObject
    }

    @Override
    public String enviarMsg(String msg) throws RemoteException {
        return msg;
    }
}

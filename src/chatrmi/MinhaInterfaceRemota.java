/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package chatrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MinhaInterfaceRemota extends Remote{
    public String enviarMsg(String msg) throws RemoteException;
}

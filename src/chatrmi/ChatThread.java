/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatrmi;

import chatrmi.cliente.Cliente;

/**
 *
 * @author naoki
 */
public class ChatThread extends Thread{
    private int x=-1, y=-1;

    public ChatThread(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ChatThread() {
    }
    
    @Override
    public void run() {
        Cliente cl = new Cliente();
        if (x>=0 && y>=0) {
            cl.setLocation(x, y);
        }
        cl.setVisible(true);
    }
}

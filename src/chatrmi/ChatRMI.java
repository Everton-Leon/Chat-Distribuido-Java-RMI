package chatrmi;

import chatrmi.cliente.Cliente;
import chatrmi.servidor.Servidor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ChatRMI extends Thread{
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ChatRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O lookAndFeel em uso é: "+UIManager.getLookAndFeel().getDescription());
        new Servidor().setVisible(true);
        ChatRMI chat = new ChatRMI();
        chat.start();
        chat = new ChatRMI();
        chat.start();
    }

    @Override
    public void run() {
        new Cliente().setVisible(true);
    }
}

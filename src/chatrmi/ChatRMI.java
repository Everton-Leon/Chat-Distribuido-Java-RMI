package chatrmi;

import chatrmi.cliente.Cliente;
import chatrmi.servidor.Servidor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ChatRMI{
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ChatRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("O lookAndFeel em uso é: "+UIManager.getLookAndFeel().getDescription());
        Servidor servidor1 = new Servidor();
        servidor1.setLocation(200, 0);
        servidor1.setVisible(true);
        new ChatThread(200, 400).start();
        new ChatThread(1000, 400).start();
    }
}

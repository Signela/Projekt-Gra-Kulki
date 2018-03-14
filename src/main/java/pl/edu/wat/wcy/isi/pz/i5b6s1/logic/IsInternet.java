package pl.edu.wat.wcy.isi.pz.i5b6s1.logic;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Klasa odpowiedzialna za sprawdzenie istnienia połączenia z internetem
 */
public class IsInternet {
    public boolean isInernet() {
        Socket sock = new Socket();
        InetSocketAddress addr = new InetSocketAddress("google.com", 80);
        try {
            sock.connect(addr, 3000);
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                sock.close();
            } catch (IOException e) {
            }
        }
    }
}

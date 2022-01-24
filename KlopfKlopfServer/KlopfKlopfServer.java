// aus Java von Kopf bis Fuß

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class KlopfKlopfServer {

    int portNummer;

    public KlopfKlopfServer(int portnummer_)
    {
        portNummer = portnummer_;
    }

    public void start() {



        try {
            ServerSocket serverSock = new ServerSocket(portNummer);
            Socket socket = serverSock.accept();

            // Zum Schreiben in die Socket
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            // Zum Lesen aus der Socket
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            // Schickt Klopf klopf
            writer.println("Klopf klopf!");
            writer.flush();
            
            //Liest wer da
            String nachricht = reader.readLine();
            System.out.println(nachricht);
            
            //Schickt einen Vornamen
            writer.println("Anna");
            writer.flush();
            
            //Liest wer da
            nachricht = reader.readLine();
            System.out.println(nachricht);
            
            // Schickt den Witz
            
            writer.println("Anna Tür hat wer geklingelt");
            writer.flush();
            
            
            
            reader.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    } 

}


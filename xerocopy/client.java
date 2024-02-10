import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class client {
    public static void main(String[] args) {
        String des = "E:\\project\\os receivefile\\New folder\\testrin.mp4";
        String serverIP = "192.168.64.7";
        int P = 2546;
        
        try {
            SocketChannel clientSocket = SocketChannel.open();
            clientSocket.connect(new InetSocketAddress( serverIP,P));
            System.out.println("Connected");

            FileOutputStream outputS = new FileOutputStream(des);
            FileChannel fileC = outputS.getChannel();
            
            long bytesRead = fileC.transferFrom(clientSocket, 0, Long.MAX_VALUE);
            
            System.out.println("Download Complete");
            
            clientSocket.close();
            fileC.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }
}
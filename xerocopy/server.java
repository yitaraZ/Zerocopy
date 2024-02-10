import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.FileChannel;

    


public class server {
    public static void main(String[] args){
        String filePath = "E:\\project\\os receivefile\\New folder\\rin.mp4";
        String IP ="192.168.64.7";
        int P = 2546;
        
        try{
            RandomAccessFile source = new RandomAccessFile(filePath, "r");
            FileChannel channel = source.getChannel();
            
            
            
            ServerSocketChannel server = ServerSocketChannel.open();
            System.out.println("Server open");
            server.socket().bind(new InetSocketAddress(IP,P));
            
            SocketChannel clientSocket = server.accept();
            
            long bytesSent = channel.transferTo(0, channel.size(), clientSocket);
            
            clientSocket.close();
            server.close();
            channel.close();
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
    }
}
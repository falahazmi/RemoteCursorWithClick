/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendfileudp;

/**
 *
 * @author ASUS
 */
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        File file = new File("D:\\FileFromUDP\\tes.txt");
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bao = new ByteArrayOutputStream((int) file.length());
        byte[] b = new byte[1024];
        int len;
        while ((len = fis.read(b)) != -1) {
            bao.write(b, 0, len);
        }
        byte[] bs = bao.toByteArray();
        DatagramPacket dp = new DatagramPacket(bs, bs.length, InetAddress.getByName("10.10.100.19"), 1234);
        ds.send(dp);
        fis.close();
        ds.close();
    }

}

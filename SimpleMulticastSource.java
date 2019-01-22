import java.io.*;
import java.net.*;
public class SimpleMulticastSource
{
public static void main(String[] args)
{
try
{
DatagramSocket s=new DatagramSocket();
byte[] line=new byte[100];
System.out.print("Enter text to send:");
int len=System.in.read(line);
InetAddress dest=InetAddress.getByName("224.0.0.1");
DatagramPacket pkt=new DatagramPacket(line,len,dest,16900);
s.send(pkt);
s.close();
}
catch(Exception err)
{
System.err.println(err);
}
}
}
	
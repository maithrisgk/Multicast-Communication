import java.io.*;
import java.net.*;
public class SimpleMulticastDestination
{
public static void main(String[] args)
{
try
{
MulticastSocket ms=new MulticastSocket(16900);
ms.joinGroup(InetAddress.getByName("224.0.0.1"));
String msg;
do
{
byte[] line=new byte[100];
DatagramPacket pkt=new DatagramPacket(line,line.length);
ms.receive(pkt);
msg=new String(pkt.getData());
System.out.println("From"+pkt.getAddress()+":"+msg.trim());
}
while(!msg.trim().equals("close"));
ms.close();
}
catch(Exception err)
{
System.err.println(err);
}
}
}

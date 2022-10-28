package network;

import java.util.ArrayList;
import java.util.List;

public class TermStudy {
    public static void main(String[] args) {

        String[] ss = {"MTU", "CIDR", "TCP/IP", "NAT", "RIP", "OSPF", "MAC",
        "ARP", "RARP", "WWW", "ICMP", "IGMP", "DHCP", "CSMA/CD", "LLC", "DNS",
        "LAN", "MAN", "WAN", "UDP", "ISP"};

        ArrayList<String> list = new ArrayList<>(List.of(ss));

        while(list.size() > 0){
            int index = (int)(Math.random()*list.size());
            System.out.print(list.remove(index)+"   ");
        }
    }
}
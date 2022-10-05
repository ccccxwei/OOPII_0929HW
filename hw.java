import java.util.*;

class ticketClass implements Runnable{
    static int ticket = 10000;
    int sale;
    int total=0;
    Thread t;

    ticketClass(String name){
        sale = 0;
        
        t = new Thread(this, name);
        t.start();
    }
    
    public void run(){
        while(saleticket()==true){

            sale = (int)(Math.random()*4)+1;
            
            System.out.println(t.getName()+"售出"+sale+"張票");
            total = total + sale;
            
        }
        System.out.println(t.getName()+"總共售出"+total+"張票");
    }

    synchronized private static boolean saleticket(){
        if(ticket > 0){
            int sale = (int)(Math.random()*4)+1;
            ticket = ticket - sale;
            return true;
        }else{
            return false;
        }
    }
}

public class hw{
    public static void main(String[] args) {
        ticketClass tA = new ticketClass("售票機A");
        ticketClass tB = new ticketClass("售票機B");
        ticketClass tC = new ticketClass("售票機C");
        ticketClass tD = new ticketClass("售票機D");

    }
}
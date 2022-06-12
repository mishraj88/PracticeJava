//import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TicketSystem {

    static AtomicInteger numAvailable  = new AtomicInteger(10);
    //BlockingQueue<User> q = new ArrayBlockingQueue<>(10);
    public static void bookTickets(int numberOfTickets, User user){

        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        try{
               Lock writeLock = lock.writeLock();
               if(writeLock!=null){
                if(numberOfTickets <= 4 && numAvailable.get() > numberOfTickets){
                    for(int i =0; i < numberOfTickets; i++){
                        if(numAvailable.get()>0){
                        System.out.println(Thread.currentThread().getName()+
                        " now available: "+numAvailable.decrementAndGet());
                        }else{
                            break;
                        }
                        
        
                    }
                    
                }else{
                    System.out.println("Thread: "+Thread.currentThread().getName());
                    System.out.println("No tickets available");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
                lock.notifyAll();
        }
        
    }


    public static void main(String[] args) throws Exception{

        User user1=  new User("a", 4);
        User user2 = new User("b", 2);
        User user3 = new User("c", 3);
        User user4 = new User("d", 4);
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run(){
                TicketSystem.bookTickets(user1.numberOfTickets, user1);   
            }
            
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run(){
                TicketSystem.bookTickets(user2.numberOfTickets, user2);   
            }
            
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run(){
                TicketSystem.bookTickets(user3.numberOfTickets, user3);   
            }
            
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run(){
                TicketSystem.bookTickets(user4.numberOfTickets, user4);   
            }
            
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("main thread exiting");
    }

}


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class crystalVase implements Lock{

    public static void main(String[] args){
        System.out.println("How many guests?");
        String Nstr = System.console().readLine();
        int N = Integer.parseInt(Nstr);
        crystalVase guestQ = new crystalVase(N);
        for(int i = 0; i < N; i++){
            guestQ.lock();
            guestQ.unlock();
        }
        
    }

    ThreadLocal<Integer> mySlotIndex = new ThreadLocal<Integer> (){
        protected Integer initialValue() {
        return 0;
         }
    };
    AtomicInteger tail;
    volatile boolean[] flag;
    int size;
    public crystalVase(int capacity) {
        size = capacity;
        tail = new AtomicInteger(0);
        flag = new boolean[capacity];
        flag[0] = true;
    }
    public void lock() {
        int slot = tail.getAndIncrement() % size;
        System.out.println("guest " + slot + "has entered the vase room");
        mySlotIndex.set(slot);
        while (! flag[slot]) {};
    }
    public void unlock() {
        int slot = mySlotIndex.get();
        System.out.println("guest " + slot + "has exited the vase room");
        flag[slot] = false;
        flag[(slot + 1) % size] = true;
    }
    public Condition newCondition(){
        return null;
    }
    @Override
    public void lockInterruptibly() throws InterruptedException {
        // TODO Auto-generated method stub
        
    }
    @Override
    public boolean tryLock() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        // TODO Auto-generated method stub
        return false;
    }
    
    
}   

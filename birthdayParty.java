import java.util.concurrent.Semaphore;

public class birthdayParty {

    public static void main(String[] args) throws InterruptedException{
        System.out.println("How many guests?");
        String Nstr = System.console().readLine();
        int N = Integer.parseInt(Nstr);

        nThreads.setN(N);
        
        Thread myThreads[] = new Thread[N];

        for (int j = 0; j < N; j++) {
            myThreads[j] = new Thread(new nThreads(j));
            myThreads[j].start();
        }



        for (int j = 0; j < N ; j++) {
            myThreads[j].join(); //todo add catch exception
        }

        System.out.println("All guests have visited the labrynth at least once.");

    }
}

class nThreads implements Runnable {

    private final int i;

    //used by leader thread to count 
    //how many guests have been through maze
    static int counter;

    //represents if there is a cupcake present
    //when each guest reaches end of maze
    static  boolean cupcake = true;

    //used by each guest to make sure
    //they only eat one cupcake
    // 0 = have not eaten, 1 = have eaten
    private int eat;

    //used by leader to announce when all guests have entered
    static boolean game = true;

    //number of guests
    static private int Nguests;

    //mutex lock 
    public static Semaphore mutex = new Semaphore(1);

    public nThreads(int i) {
        this.i = i;
        this.eat = 0;
    }

    public static void setN(int N){
        Nguests = N;
    }
;
    @Override
    public void run() {
        while(game){ 
            try{
                mutex.acquire();

                //each guest eats one cupcake
                if(this.eat == 0 && cupcake == true){
                    this.eat = 1;
                    cupcake = false;
                }

                if(this.i == 0){
                    if (cupcake == false){
                        cupcake = true;
                        counter++;
                    }
                    if(counter == Nguests){
                        game = false;
                    }
                }

    
                mutex.release();

            } catch (Exception x) {
                x.printStackTrace();

            }
        }
    }
}
class ThreadOne extends Thread {
    public void run(){
        for(int i = 1; i <= 5; i++) {
            if(i == 3){
                // Stop the thread and give chance to other thread
                Thread.yield();
            }
            System.out.println("Thread One: " + i);
        }
    }
}

class ThreadTwo extends Thread {
    public void run(){
        for(int i = 1; i <= 5; i++){
            if(i == 3){
                try {
                    Thread.sleep(1000);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
            System.out.println("Thread Two: " + i);
        }
    }
}

class MT {
    public static void main(String[] args) throws InterruptedException {
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();
        t1.start();
        t2.start();
    }
}
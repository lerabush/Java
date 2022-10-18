package third;

public class Greeter implements Runnable {
    private String target;
    private int n;

    public Greeter(int n, String target){
        this.n = n;
        this.target = target;
    }

    @Override
    public void run() {
        for(int i = 0; i<n;i++){
            System.out.println("Hello, "+target);
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

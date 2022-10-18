package example;

public class Computer {
    private MusicStrategy strategy;

    public Computer(MusicStrategy strategy){
        this.strategy = strategy;
    }

    public void setNewStrategy(MusicStrategy strategy){
        this.strategy = strategy;
    }

    public void playMusic() {
        this.strategy.execute();
    }
}

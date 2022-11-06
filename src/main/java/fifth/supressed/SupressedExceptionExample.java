package fifth.supressed;

public class SupressedExceptionExample {
    public static void main(String[] args) throws Exception {
        long start1 = System.nanoTime();
        for(int i=0;i<10000000;i++){
            suppressedExample();
        }
        long time1 = System.nanoTime()-start1;
        long start2 = System.nanoTime();
        for(int i=0;i<10000000;i++){
            chainedExample();
        }
        long time2= System.nanoTime()-start2;
        System.out.println(time1);//74797969100
        System.out.println(time2);//94560144800
    }

    public static void suppressedExample() {
        try (Door door = new Door()) {
            door.swing();
        } catch (Exception e) {
            //e.printStackTrace()
        }
    }

    public static void chainedExample(){
        Door door = new Door();
        Exception mainEx = null;
        try {
            door.swing();
        } catch (Exception ex) {
            mainEx = ex;
        } finally {
            try {
                door.close();
            } catch (Exception exception) {
                mainEx = new SwingException("Main exception", exception);
                //mainEx.printStackTrace();
            }
        }
    }

}
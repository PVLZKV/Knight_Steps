/**
 * @author Pavel
 */
public class cousor extends Thread {
    @Override
    public void run() {
        System.out.print("Enter first Knight point (like this: 1 5) ");
        while (!isInterrupted()) {
            try {
                System.out.print("-> ");
                Thread.sleep(500);
                System.out.print("\b\b\b");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


import java.util.concurrent.Semaphore;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vansh
 */
public abstract class UserlandProcess implements Runnable {

    private static final int MAX_AVAILABLE_SEM = 100;
    private final Semaphore userland_semaphore = new Semaphore(MAX_AVAILABLE_SEM, true);
    private Boolean is_quantum_expired = false;
    private Thread userland_thread = new Thread();

    @Override
    public void run() {
        userland_semaphore.tryAcquire();
        main();
    }

    void requestStop() {
        System.out.println("Func: requestStop: Setting quantum expiration to true");
        is_quantum_expired = true;
    }

    abstract void main();

    boolean isStopped() {
        if (userland_semaphore.tryAcquire()) {
            System.out.println("Func: isStopped: Semophore is not equal to 0");
            userland_semaphore.release();
            return false;
        }
        System.out.println("Func: isStopped: Semophore is equal to 0");
        return true;
    }

    boolean isDone() {
        if (userland_thread.isAlive()) {
            System.out.println("Func: isDone: Thread is alive");
            return false;
        }
        System.out.println("Func: isDone: Thread is not alive");
        return true;
    }

    void start() {
        System.out.println("Func: start: Releasing userland semaphore ");
        userland_semaphore.release();
    }

    void stop() {
        System.out.println("Func: stop: Aquiring semaphore");
        userland_semaphore.tryAcquire();
    }

    void cooperate() {
        if (is_quantum_expired) {
            is_quantum_expired = false;
            // OS.switchProcess();
        }
    }
}

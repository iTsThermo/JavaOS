
import java.util.concurrent.Semaphore;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vansh
 */
public abstract class UserlandProcess implements Runnable{
    private static final int MAX_AVAILABLE_SEM = 100;
    private final Semaphore syncronized_sem = new Semaphore(MAX_AVAILABLE_SEM, true);
    private Boolean quantum_is_expire = false;
    
    void requestStop() {
        
    }

    abstract void main();

    boolean isStopped() {
        return false;
    }

    boolean isDone() {
        return false;
    }

    void start(){

    }

    void stop() {

    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void cooperate() {

    }
}

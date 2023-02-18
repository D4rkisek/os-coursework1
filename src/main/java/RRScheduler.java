import java.util.Queue;
import java.util.LinkedList;
import java.util.Properties;

/**
 * Round Robin Scheduler
 * 
 * @version 2017
 */
public class RRScheduler extends AbstractScheduler {

  private int timeQuantum;
  private Queue<Process> readyQueue; //ready/unblock queue

    /**
     * Initializes the scheduler from the given parameters
     */
    @Override
    public void initialize(Properties parameters) {
        this.readyQueue = new LinkedList<>();
        this.timeQuantum = Integer.parseInt(parameters.getProperty("timeQuantum"));
    }

    /**
     * Adds a process to the ready queue.
     * usedFullTimeQuantum is true if process is being moved to ready
     * after having fully used its time quantum.
     */
    @Override
    public void ready(Process process, boolean usedFullTimeQuantum) {
        if (usedFullTimeQuantum) {
            // If the process has fully used its time quantum, add it to the back of the queue
            this.readyQueue.add(process);
        } else {
            // If the process has not fully used its time quantum, add it to the front of the queue
            this.readyQueue.offer(process);
        }
    }

    /**
     * Removes the next process to be run from the ready queue
     * and returns it.
     * Returns null if there is no process to run.
     */
    @Override
    public Process schedule() {
        if (!this.readyQueue.isEmpty()) {
            // Get the next process to run from the front of the queue
            Process nextProcess = this.readyQueue.poll();

            // Set the process state to RUNNING
            nextProcess.state = Process.State.RUNNING;

            // Return the process
            return nextProcess;
        } else {
            return null;
        }
    }
    /**
     * Returns the time quantum of this scheduler.
     */
    public int getTimeQuantum() {
        return this.timeQuantum;
    }

    /**

     Returns whether the scheduler is preemptive
     */
    public boolean isPreemptive() {
        return false;
    }
}
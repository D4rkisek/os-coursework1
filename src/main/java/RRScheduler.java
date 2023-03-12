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
        readyQueue = new LinkedList<>(); //setting up the ready queue
        timeQuantum = Integer.parseInt(parameters.getProperty("timeQuantum")); //reading the timeQuantum from the parameters
    }

    /**
     * Adds a process to the ready queue.
     * usedFullTimeQuantum is true if process is being moved to ready
     * after having fully used its time quantum.
     */
    @Override
    public void ready(Process process, boolean usedFullTimeQuantum) {
        if (usedFullTimeQuantum) {
            // If the processor has fully used its time quantum, add it to the back of the queue
            readyQueue.add(process);
        } else {
            // If the processor has not fully used its time quantum, add it to the front of the queue
            readyQueue.offer(process);
        }
    }

    /**
     * Removes the next process to be run from the ready queue
     * and returns it.
     * Returns null if there is no process to run.
     */
    @Override
    public Process schedule() {
        if (!readyQueue.isEmpty()) {
            // Get the next process to run from the front of the queue
            System.out.println("Scheduler selects process "+readyQueue.peek());
            return readyQueue.poll();
        } else {
            System.out.println("No process to run.");
            return null;
        }
    }

    /**
     * Returns the time quantum of this scheduler.
     */
    @Override
    public int getTimeQuantum() {
        return timeQuantum;
    }
    /**
     Returns whether the scheduler is preemptive
     */
    @Override
    public boolean isPreemptive() {
        return false;
    }
}
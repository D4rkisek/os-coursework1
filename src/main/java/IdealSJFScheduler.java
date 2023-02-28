import java.util.Queue;
import java.util.LinkedList;
import java.util.Properties;

/**
 * Ideal Shortest Job First Scheduler
 *
 * @version 2017
 */
public class IdealSJFScheduler extends AbstractScheduler {

  private Queue<Process> readyQueue;

  /**
   * Creates an instance of the Ideal SJF scheduler
   */

  @Override
  public void initialize(Properties parameters) {
    readyQueue = new LinkedList<>();
  }
  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
  public void ready(Process process, boolean usedFullTimeQuantum) {
    readyQueue.offer(process);
  }

  /**
   * Removes the next process to be run from the ready queue
   * and returns it.
   * Returns null if there is no process to run.
   */
  public Process schedule() {
    if (!readyQueue.isEmpty()) {
      // Find the process with the shortest next burst time
      Process shortestProcess = null;
      int shortestBurst = Integer.MAX_VALUE;
      for (Process p : readyQueue) {
        int nextBurst = p.getNextBurst();
        if (nextBurst < shortestBurst) {
          shortestProcess = p;
          shortestBurst = nextBurst;
        }
      }

      // Remove the process with the shortest next burst time from the queue and return it
      readyQueue.remove(shortestProcess);
      return shortestProcess;
    } else {
      System.out.println("No process to run.");
      return null;
    }
  }

}

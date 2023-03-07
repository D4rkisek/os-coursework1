import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

/**
 * Shortest Job First Scheduler
 * 
 * @version 2017
 */
public class SJFScheduler extends AbstractScheduler {

  private Queue<Process> readyQueue; //ready/unblock queue
  private int initialBurstEstimate;
  private double alphaBurstEstimate;

  /**
   * Creates an instance of the Ideal SJF scheduler
   */
  @Override
  public void initialize(Properties parameters) {
    readyQueue = new LinkedList<>();
    initialBurstEstimate = Integer.parseInt(parameters.getProperty("initialBurstEstimate"));
    alphaBurstEstimate = Double.parseDouble(parameters.getProperty("alphaBurstEstimate"));
  }

  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
  public void ready(Process process, boolean usedFullTimeQuantum) {
    // update the priority of the process using exponential averaging
    int recentBurst = process.getRecentBurst();
    if (recentBurst == -1) {
      // first time the process runs, set priority to initialBurstEstimate
      process.setPriority(initialBurstEstimate);
    } else {
      // calculate the estimated next burst time using exponential averaging
      int estimatedNextBurst = (int) (alphaBurstEstimate * recentBurst + (1 - alphaBurstEstimate) * process.getPriority());
      process.setPriority(estimatedNextBurst);
    }
    readyQueue.offer(process);
  }

  /**
   * Removes the next process to be run from the ready queue 
   * and returns it. 
   * Returns null if there is no process to run.
   */
  public Process schedule() {
    if (!readyQueue.isEmpty()) {
      // select the process with the shortest burst time
      Process selectedProcess = readyQueue.peek();
      for (Process p : readyQueue) {
        if (p.getPriority() < selectedProcess.getPriority()) {
          selectedProcess = p;
        }
      }
      readyQueue.remove(selectedProcess);
      return selectedProcess;
    } else {
      System.out.println("No process to run.");
      return null;
    }
  }
}

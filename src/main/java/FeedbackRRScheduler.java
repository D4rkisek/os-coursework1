import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

/**
 * Feedback Round Robin Scheduler
 */

public class FeedbackRRScheduler extends AbstractScheduler {

  private int timeQuantum;
  private Queue<Process> readyQueue; //ready/unblock queue

  /**
   * Initializes the scheduler from the given parameters
   */
  @Override
  public void initialize(Properties parameters) {
    readyQueue = new LinkedList<>();
    timeQuantum = Integer.parseInt(parameters.getProperty("timeQuantum"));
  }

  /**
   * Adds a process to the ready queue.
   * usedFullTimeQuantum is true if process is being moved to ready
   * after having fully used its time quantum.
   */
  public void ready(Process process, boolean usedFullTimeQuantum) {
    if (usedFullTimeQuantum) {
      // demote the process to a lower priority level
      process.setPriority(process.getPriority() + 1);
      // add the process to the end of the ready queue with its current priority
      readyQueue.add(process);
    }else{
      // If the processor has not fully used its time quantum, add it to the front of the queue
      readyQueue.offer(process);
    }
  }

  /**
   * Removes the next process to be run from the ready queue
   * and returns it.
   * Returns null if there is no process to run.
   */
  public Process schedule() {
    // select the process with the highest priority level
    Process selectedProcess = null;
    int highestPriority = Integer.MAX_VALUE;
    for (Process p: readyQueue) {
      if (p.getPriority() < highestPriority) {
        highestPriority = p.getPriority();
        selectedProcess = p;
      }
    }
    // if multiple processes have the same priority level, use a round-robin approach
    if (selectedProcess != null) {
      readyQueue.remove(selectedProcess);
      return selectedProcess;
    }else{
      System.out.println("No process to run.");
      return null;
    }
  }

  /**
   * Returns the time quantum of this scheduler
   * or -1 if the scheduler does not require a timer interrupt.
   */
  public int getTimeQuantum() {
    return timeQuantum;
  }

  /**
   * Returns whether the scheduler is preemptive
   */
  public boolean isPreemptive() {
    return true;
  }

}


/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling..
 */

import java.util.*;
import java.util.Scanner;

public class RR implements Algorithm {
    private List<Task> queue;
    private List<Task> completedTasks;
    private Task current;

    public RR(List<Task> queue) {
        this.queue = queue;
        this.completedTasks = new ArrayList<>();
    }

    public void schedule() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a time quantum...");
        int i = scan.nextInt();
        scan.close();
        System.out.println("Starting Round Robin CPU Scheduling...");
        int quantum = 10; // is 10 right for 10 mililmseconds or is there something i have to do to it?

        while (!queue.isEmpty()) {
            current = pickNextTask();

            // check to see if burst time is less than the time quantum or not
            if (current.getBurst() < i) {
                quantum = current.getBurst();
            } else {
                quantum = i;
            }

            // run task
            CPU.run(current, quantum);

            // set new burst time after running time quantum
            current.setBurst(current.getBurst() - quantum);

            // add back to queue if still has burst time left
            if (current.getBurst() > 0) {
                queue.add(current);
            } else {
                // Task completed, add to the completedTasks list and state its finished
                System.out.println("Task " + current.getName() + " has finished. \n");
                completedTasks.add(current);
            }
        }
        System.out.println("Order in which tasks finished first...");
        // prints out order of tasks
        for (Task task : completedTasks) {
            System.out.println(task.getName());
        }

    }

    public Task pickNextTask() {

        if (!queue.isEmpty()) {
            return queue.remove(0);
        } else {
            return null;
        }
    }
}
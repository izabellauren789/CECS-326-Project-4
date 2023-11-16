
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
        // not finished
    }

    public void schedule() {
        int quantum = 10;

        while (!queue.isEmpty()) {
            current = pickNextTask();

            // run task
            CPU.run(current, quantum);

            // set new burst time
            current.setBurst(current.getBurst() - quantum);

            // add back to queue
            if (current.getBurst() > 0) {
                queue.add(current);
            } else {
                completedTasks.add(current);
            }
        }
        for (Task task : completedTasks) {
            System.out.println(task);
        }
    }

    public Task pickNextTask() {
        // //for( int i =0; i < queue.get(i).getTid(); i++){
        // quantum = queue.get(i).getPriority();
        // queue.get(0).setBurst(queue.get(0).getBurst() -
        // queue.get(0).getPriority());// get task from queue, set burst time of queeue
        // get queue - quantum

        if (!queue.isEmpty()) {
            return queue.remove(0);
        } else {
            return null;
        }

        /*
         * Task temp;
         * Task next = null;
         * int max = 0;
         * 
         * for (int i = 0; i < queue.size(); i++) {
         * temp = queue.get(i);
         * if (temp.getPriority() > max) {
         * max = temp.getPriority();
         * next = temp;
         * }
         * }
         * queue.remove(next);
         * return next;
         */
    }
}
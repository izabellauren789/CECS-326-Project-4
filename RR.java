
/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling..
 */

import java.util.*;

public class RR implements Algorithm {
    private List<Task> queue;
    private Task scheduler;

    public RR(List<Task> queue) {
        this.queue = queue;
        // not finished
    }

    public void schedule() {
        while( !queue.isEmpty() && queue.get(0).getBurst() > 0){
            scheduler = pickNextTask();

            CPU.run(scheduler, scheduler.getBurst());
        }
    }

    public Task pickNextTask() {
        // //for( int i =0; i < queue.get(i).getTid(); i++){
        //     quantum = queue.get(i).getPriority();
        queue.get(0).setBurst(queue.get(0).getBurst() - queue.get(0).getPriority());// get task from queue, set burst time of queeue get queue  - quantum
        return queue.remove(0);
    }
}
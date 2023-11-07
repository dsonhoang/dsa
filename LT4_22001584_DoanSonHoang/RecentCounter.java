package LT4_22001584_DoanSonHoang;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        int sum = t - queue.peek();
        while(sum > 3000 && queue.size() > 0){
            queue.poll();
            sum = t - queue.peek();
        }
        return queue.size();
    }
}
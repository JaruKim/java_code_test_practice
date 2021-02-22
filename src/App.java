import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        int answer = 0;

        int bridge_length = 2;
        int weights = 10;
        int[] truck_weights = {7,4,5,6};
        int sec = 0;
        int idx = 0;

        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        while (true) {
            if (queue.size() == bridge_length) {
                int emt = queue.poll();
                weights += emt;
                
                if (emt > 0) {
                    queue2.add(emt);
                }
            }
            
            if (idx <= truck_weights.length-1) {
                if (weights-truck_weights[idx] >= 0) {
                    weights -= truck_weights[idx];
                    queue.add(truck_weights[idx]);
                    idx++;
                } else {
                    queue.add(0);
                }
            } else {
                queue.add(0);
            }

            sec++;

            if (queue2.size() == truck_weights.length ) {
                break;
            }
        }

        answer = sec;
        System.out.println(answer);
    }
}

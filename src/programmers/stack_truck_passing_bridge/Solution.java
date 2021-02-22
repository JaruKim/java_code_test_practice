package programmers.stack_truck_passing_bridge;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) throws Exception {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sec = 0;
        int idx = 0;

        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        while (true) {
            if (queue.size() == bridge_length) {
                int emt = queue.poll();
                weight += emt;
                
                if (emt > 0) {
                    queue2.add(emt);
                }
            }
            
            if (idx <= truck_weights.length-1) {
                if (weight-truck_weights[idx] >= 0) {
                    weight -= truck_weights[idx];
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

        return answer;
    }
}

/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;

        
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval meeting : intervals) {
            
            if (!pq.isEmpty() && pq.peek() <= meeting.start) {
                pq.poll();
            }
            
            pq.offer(meeting.end);
        }

        return pq.size();
    }
}

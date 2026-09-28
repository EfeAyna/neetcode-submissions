

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        record Tuple(char task, int freq) implements Comparable<Tuple> {
            public int compareTo(Tuple other) {
                return Integer.compare(other.freq, this.freq);
            }
        } 

        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            pq.offer(new Tuple(c, map.get(c)));
        }

        
        Tuple t = pq.poll();
        int emptySpace = n * (t.freq() - 1);

        
        while (!pq.isEmpty()) {
            Tuple cur = pq.poll();
            emptySpace -= Math.min(t.freq() - 1, cur.freq());
        }

        
        return tasks.length + Math.max(0, emptySpace);
    }
}
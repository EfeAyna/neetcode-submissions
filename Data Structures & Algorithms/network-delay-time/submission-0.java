class Solution {

   
    record Edge(int to, int weight) {}
    record State(int node, int time) implements Comparable<State> {
        @Override
        public int compareTo(State other) {
            return Integer.compare(this.time, other.time);
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Edge(v, w));
        }

        
        PriorityQueue<State> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.offer(new State(k, 0));

        
        while (!pq.isEmpty()) {
            State current = pq.poll();
            int u = current.node();
            int currTime = current.time();

            
            if (currTime > dist[u]) continue;

            for (Edge edge : adj.get(u)) {
                int nextNode = edge.to();
                int newTime = currTime + edge.weight();

                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    pq.offer(new State(nextNode, newTime));
                }
            }
        }

        
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; 
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
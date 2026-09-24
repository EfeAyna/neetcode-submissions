class Solution {
    public int minCostConnectPoints(int[][] points) {
        // create a edge class from to weight implemetns comparable
        // connect every dot with weight = distance
        // mst problem
        // we can implement union find and solve with kruskal 
        record Edge(int point, int point2, int w) implements Comparable<Edge>{
            public int compareTo(Edge other){
                return Integer.compare(this.w, other.w);
            }
        }

        List<Edge> graph = new ArrayList<>();

        for(int i = 0; i < points.length-1; i++){
            for(int j = i+1; j < points.length; j++){
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph.add(new Edge(i, j, weight));
            }
        }


        PriorityQueue<Edge> pq = new PriorityQueue<>();
        UnionFind u = new UnionFind(points.length);
        int res = 0;
        pq.addAll(graph);
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (u.union(cur.point(), cur.point2())) {
                res += cur.w();
            }
        }
        return res;


        
    }

    class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    boolean union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return false;
        parent[rootX] = rootY;
        return true;
    }
}
}

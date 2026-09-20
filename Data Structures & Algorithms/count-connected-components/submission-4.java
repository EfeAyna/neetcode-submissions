class Solution {
    public int countComponents(int n, int[][] edges) {
        if(edges.length == 0){
            return n;
        }
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.putIfAbsent(edge[1] , new ArrayList<>());
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return n - graph.keySet().size() + dfs(graph, edges[0][0], new HashSet<Integer>());

    }


    public int dfs(Map<Integer, List<Integer>> graph, int start, Set<Integer> set){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        stack.push(start);
        while(!stack.isEmpty()){
            int cur = stack.pop();
            int parent = stack.pop();
            if(set.contains(cur)){
               continue; 
            }
            set.add(cur);
            for(int i : graph.getOrDefault(cur, new ArrayList<Integer>())){
                if(i != parent){
                    stack.push(cur);
                    stack.push(i);
                }
            }
        }
        
        
        for(int i : graph.keySet()){
            if(!set.contains(i)){
                return 1 + dfs(graph, i, set);
            }
        }
        return 1;
    }
}

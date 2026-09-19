class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        Set<Integer> set = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, List<Integer>> m = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            m.putIfAbsent(edges[i][0], new ArrayList<>());
            m.putIfAbsent(edges[i][1], new ArrayList<>());
            m.get(edges[i][1]).add(edges[i][0]);
            m.get(edges[i][0]).add(edges[i][1]);
        }

        stack.push(-1);
        stack.push(0);
        

        while(!stack.isEmpty()){
            int cur = stack.pop();
            int parent = stack.pop();
            if(set.contains(cur)){
                return false;
            }
            set.add(cur);
            for(int i : m.getOrDefault(cur, new ArrayList<>())){
                if(i != parent){
                    stack.push(cur); 
                    stack.push(i);
                }
                
            }
        }

        return n == set.size();


    }
}

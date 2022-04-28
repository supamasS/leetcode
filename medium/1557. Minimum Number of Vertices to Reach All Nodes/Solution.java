class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        /*
            create an array of boolean isDest with size n
            iterate over edges with index i:
                isDest[edges.get(i).get(1)] = true;
                
            list = an empty list
            iterate over isDest with index j:
                if(!isDest[j])
                    list.add(j)
                    
            return list
            
              i=0
              isDest[1] = true
                   i=1
                   isDest[1] = true
                          i=2
                          isDest[1] = true
                                i=3
                                isDest[4] = true
                                      i=4
                                      isDest[4] = true
            [[0,1],[2,1],[3,1],[1,4],[2,4]]
        isDest: [f, t, f, f, t]
        list:   [0,    2, 3]
            
        */
        
        boolean[] isDest = new boolean[n];
        for(int i=0; i < edges.size(); i++) {
            isDest[edges.get(i).get(1)] = true;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int j=0; j < n; j++) {
            if(!isDest[j])
                list.add(j);
        }
        
        return list;
    }
}

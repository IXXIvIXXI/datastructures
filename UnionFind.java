public class UnionFind {
        int[] parents;
        int[] size;
        int numOfComponets = 0;
        
        public UnionFind(int n) {
            parents = new int[n];
            size = new int[n];
            numOfComponets = n;
            
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }
        
        public int find(int curr) {
            int root = curr;
            while (root != parents[root]) {
                root = parents[root];
            }
            
            while (curr != root) {
                int preParent = parents[curr];
                parents[curr] = root;
                curr = preParent;
            }
            
            return root;
        }
        
        public int findComponentSize(int n) {
            int parent = find(n);
            return size[parent];
        }
        
        public boolean union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            
            if (parentA == parentB) {
                return false;
            }
            
            if (size[parentA] > size[parentB]) {
                parents[parentB] = parentA;
                size[parentA] += size[parentB];
            } else {
                parents[parentA] = parentB;
                size[parentB] += size[parentA];
            }
            
            numOfComponets--;
            return true;
        }
    }

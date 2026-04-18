import java.awt.geom.GeneralPath;
import java.util.*;
public class Accounts_Merge{
    static class DisjointSet{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent  = new ArrayList<>();
        List<Integer> size= new ArrayList<>();



        public DisjointSet(int n ){
            for(int i = 0 ; i<= n ; i++){
                size.add(1);
                rank.add(0);
                parent.add(i);
            }
        }

        /// find ultimate Parent - with path compresion 
        public  int findParent(int node){
            if(node == parent.get(node)) return node;
            int up = findParent(parent.get(node)); // backtrack  
            parent.set(node, up); // path compreseed
            return parent.get(node);

        }

        // 
        void unionByRank(int u , int v){
            // find ultimate parent of u and v
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);

            // belongs to the same commponents
            if(ulp_u == ulp_v) return;

            int ranku = rank.get(ulp_u);
            int rankv = rank.get(ulp_v);

            if(ranku < rankv){
                parent.set(ulp_u , ulp_v);
            }else if( ranku > rankv ){
                parent.set(ulp_v, ulp_u);
            }else{
                // rank equal 
                parent.set(ulp_v, ulp_u);

                rank.set( ulp_u , ranku +1) ; // update rank
            }

        }


        void unionBySize(int u , int v){
             // find ultimate parent of u and v
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);

            // belongs to the same commponents
            if(ulp_u == ulp_v) return;

            int sizeu = size.get(ulp_u);
            int sizev = size.get(ulp_v);

            
            if(sizeu < sizev){
                // attach smaller to larger - 
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v , sizeu+sizev);
            }else{
                // equal condition is covers in this - bcz in equal size/rank  we can connect anyone with anyonne
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u , sizeu+sizev);
            }
        }
    }

 
    public static  List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String , Integer> mapMailNode = new HashMap<>();

        //stored all the mails in the map with its node and if ovelaping occur created a Disjoint Set
        for(int i = 0; i < n ; i++){
            for(int j  = 1  ; j< accounts.get(i).size() ;j++){
                String mail = accounts.get(i).get(j);
                if(!mapMailNode.containsKey(mail)){
                    mapMailNode.put(mail, i);
                }else{
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }
        // after this disjoint set will be created -
        
        //   array of list  - that stores all mails  in their - nodes indexx
        ArrayList<String>[] mergedmails = new ArrayList[n];
        for(int i =  0 ;i< n ;i++){
            mergedmails[i] = new ArrayList<String>();
        }
        // store all the mails acc to nodes -- index
         for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findParent(it.getValue());
            mergedmails[node].add(mail);  
        }

        // takeout all the mails and store in result - 
         List<List<String>> res = new ArrayList<>();

        for(int i = 0;i< n ;i++){
            if(mergedmails[i].size() == 0) continue;
            Collections.sort(mergedmails[i]);
            List<String> temp = new ArrayList<String>();
            // add account name  -  iin final list 
            temp.add(accounts.get(i).get(0));
            for(String it : mergedmails[i]){
                temp.add(it);
            }
            res.add(temp);
        }

       return res;

    }

    public static void main(String[] args) {
        

    }
}
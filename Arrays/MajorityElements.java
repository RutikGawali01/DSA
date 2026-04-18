import  java.util.*;
public  class MajorityElements{
    // elements > N/2 

    // TC - O(n) + O(nlogn) for map and sc - O(n) if all ele are unique
    public static int majority(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< arr.length ; i++){
            if(map.containsKey(arr[i])){
                int cnt = map.get(arr[i]);
                map.put(arr[i], cnt+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if(it.getValue()> arr.length/2){
                return it.getKey();
            }
            
        }
        return -1;
    }

    //Moore's voting Algorithm

    public static int MajorityElement(int[] arr){
        int cnt = 0;
        int ele= arr[0];

        // this finds expected ele > n/2 
        
        for(int i = 0 ; i< arr.length ; i++){
            // if at any case cnt = 0 that means  in that subarray  other ele cancels largest ele so this ele can not be the answers.

            if(cnt == 0){
                cnt = 1;
                ele = arr[i];
            }else if(arr[i] == ele){
                cnt++;
            }else{
                cnt--;
            }
        }

        int cnt1 = 0;
        // re-check if above expected ele is majority or not 
        for(int i = 0 ; i< arr.length ; i++){
            if(arr[i] == ele){
                cnt1++;
            }
        }
        if(cnt1 > arr.length /2)return ele;

        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {2, 2, 3, 3, 1 , 2, 2};
        System.out.println(majority(arr));
        System.out.println(MajorityElement(arr));
        
    }
}
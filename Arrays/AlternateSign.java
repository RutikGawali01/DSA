
import java.util.ArrayList;
import java.util.List;

public  class  AlternateSign{
    // rearrange given array  in alternate +ve and  -ve sign  - 2 variety
    // brute force = TC - O(n)+O(n/2) and Sc - O(n)
    public static int[] alternate(int[] arr){
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int i = 0; i< arr.length ; i++){
            if(arr[i] > 0){
                pos.set(i, arr[i]);
            }else if(arr[i]< 0){
                neg.set(i, arr[i]);
            }
        }
        for(int i = 0; i< arr.length/2 ; i++){
            arr[2*i] = pos.get(i);
            arr[2*i+1] = neg.get(i);
        }
        return arr;
    }

    // optimal - TC & SC - O(n) 
    public static ArrayList<Integer> alternateSign(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i< arr.length ; i++){
            int pos = 0;
            int neg = 1;
            if(arr[i]>0){
                ans.set(pos, arr[i]);
                pos = pos +2;
            }else{
                ans.set(neg, arr[i]);
                neg = neg+2;
            }
        }
        return ans;
    }


    
    // variety 2 --- if pos and neg are not equal -- add at end whatever is left

    // TC- O(2n) and SC = O(n)
    public static int[] ALTERNATE(int[] arr){
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // O(n)
        for(int i = 0; i< arr.length ; i++){
            if(arr[i] > 0){
                //pos.set(i, arr[i]);
                pos.add(arr[i]);
            }else if(arr[i]< 0){
                //neg.set(i, arr[i]);
                neg.add(arr[i]);
            }
        }

        int p = pos.size();
        int n = neg.size();
        // O(n) -- after taking all cases -- overall it will take - O(n) time 
        if(p > n){
            for(int i = 0; i< n ; i++){
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = n*2;
            for(int i = n ; i< p ; i++){
                arr[index] = pos.get(i);
                index++;
            }
        }else{
            for(int i = 0; i< p ; i++){
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = p*2;
            for(int i = p ; i< n ; i++){
                arr[index] = neg.get(i);
                index++;
            }
        }
        return arr;
    }


    public static void main(String[] args) {

        
    }
}
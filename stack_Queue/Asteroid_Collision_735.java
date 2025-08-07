import java.util.ArrayList;
public class Asteroid_Collision_735 {

    public static int[] asteroid(int [] arr){
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        for(int i = 0; i < n ; i++){
            if(arr[i] > 0){
                list.add(arr[i]);
            }else{
                while(!list.isEmpty() && (list.get(list.size() -1 )> 0 && list.get(list.size() - 1) < Math.abs(arr[i]))){
                    list.remove(list.size()-1);
                }

                if(!list.isEmpty() && list.get(list.size() -1 ) == Math.abs(arr[i])){
                    list.remove(list.size()-1);
                }else if(!list.isEmpty() && list.get(list.size() -1) <0){
                    list.add(arr[i]);
                }
            }
        }
        
        int [] res = new int[list.size()];
        for(int i =0 ; i < list.size() ; i++){
            res[i] = list.get(i);
        }
       
        return res;
    }
    public static void main(String[] args) {
        int []arr  = {4,7,1,1,2,-3,-7,17,15,-16};
        
        int [] res = asteroid(arr);

        for(int i = 0; i <res.length ; i++ ){
            System.out.print(res[i] + " ");
        }
    }

}

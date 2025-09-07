
import java.util.ArrayList;

public  class heaps{

    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            // add at last index
            arr.add(data);

            int x = arr.size()-1;// x is child index
            int par = (x-1)/2;// par index

            while(arr.get(x) < arr.get(par)){ // O(logn) total levels
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

            }
        }

        // peek from heap
        public int peek(){
            return arr.get(0);
        }

        private void  heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minInd = i;

            if(left < arr.size() && arr.get(left) < arr.get(minInd)){
                minInd = left;
            }
            if(right < arr.size() && arr.get(minInd) > arr.get(right)){
                minInd = right;
            }

            if(minInd != i){
                int temp = arr.get(minInd);
                arr.set(minInd, arr.get(i));
                arr.set(i, temp);

                heapify(minInd);

            }
        }
        // delete from heap 
        public int delete(){
            int data = arr.get(0);

            //step1 => swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //  step2 => remove last index
            arr.remove(arr.size()-1);

            // fix heap
            heapify(0);
            return data;

        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(8);
        h.add(1);
        h.add(7);
        h.add(5);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.delete();
        }
    }
}
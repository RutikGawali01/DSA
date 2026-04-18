public  class  Buy_Sell_Stock{
    // buy and selll stock - maximize profit

    public static int buySell(int[] arr){
        int min = arr[0];
        int profit = 0;
        for(int i = 1; i<arr.length ; i++){
           profit =  Math.max(profit, arr[i]-min);
            min = Math.min(arr[i], min);
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(buySell(arr));
        
    }
}
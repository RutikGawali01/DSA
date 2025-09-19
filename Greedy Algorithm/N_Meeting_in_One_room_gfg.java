
import java.util.Arrays;

public class N_Meeting_in_One_room_gfg{

    static class Meeting{
        int start;
        int end;
        int pos;

        public Meeting(int start , int end , int pos){
            this.start = start;
            this.end = end;
            this.pos = pos;


        }
    }

    public static int nMeetingInRoom(Meeting[] arr){
        Arrays.sort(arr , (a,b) -> (a.end - b.end)); // sorting in ascendinng order

        int count = 0;
        int freetime = -1;
        for(int i = 0 ; i< arr.length ; i++){
            if(arr[i].start > freetime){
                count++;
                freetime = arr[i].end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int start[] ={10, 12, 20};
        int end[] =  {20, 25, 30};

        Meeting a[] = new Meeting[start.length];

        for(int i = 0 ; i< start.length; i++){
            a[i] = new Meeting(start[i] , end[i] , i+1);
        }
        System.out.println(nMeetingInRoom(a));
    }
}
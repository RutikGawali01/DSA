public class LC_1942_The_Number_of_the_Smallest_Unoccupied_Chair {
    public int smallestChair(int[][] times, int targetFriend) {
        // int[] - len 3 -
        // 0 ind = arrival
        // 1 ind = leaving
        // 3  ind =  friend  no
        // this pq - map {arr time  , leav time}   with  friend no(ind) -
        PriorityQueue<int[]> timestoind = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        //  this is  executed bcz  after sorting index changes  so mapping and sorting in  single step
        for (int[] time : times) {
            timestoind.add(new int[] { time[0], time[1], i });
            i++;
        }
        // int[] - len 3 -
        // 0 ind = leaving time
        // 1 ind = chair no -
        // 3  ind =  friend  no
        //  track  all  ocupied  chairs with friends  leaving time
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> {
            // when only single chair becomes empty
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            // this is when 2 chairs becomes empty - at a same time then choose  chair with smallest chair no -
            return Integer.compare(a[1], b[1]);
        });

        int[] arr = timestoind.poll();
        // initially no chairs are  occupied
        occupied.add(new int[] { arr[1], 0, arr[2] });

        int maxchairno = 1;
        // it stores all available  - chairs - and then we'll select min from available
        PriorityQueue<Integer> available = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        while (!timestoind.isEmpty()) {
            // {arrival  , leaving ,  friend-no }
            int[] time = timestoind.poll();
            // check is there smallest chair is available or not -
            if (time[0] >= occupied.peek()[0]) {
                while (!occupied.isEmpty() && time[0] >= occupied.peek()[0]) {
                    int[] occupied_time = occupied.poll();
                    available.add(occupied_time[1]);
                }

                int minchair = available.poll();
                if (time[2] == targetFriend) {
                    return minchair;
                }
                occupied.add(new int[] { time[1], minchair, time[2] });

            } else {

                // if  chair is available =  take smallest chair from available chairs
                if (!available.isEmpty()) {
                    if (time[2] == targetFriend) {
                        return available.poll();
                    }
                    occupied.add(new int[] { time[1], available.poll(), time[2] });
                } else {
                    //  no chair is available - assign  consecutive chair to friend -
                    occupied.add(new int[] { time[1], maxchairno, time[2] });
                    if (time[2] == targetFriend) {
                        return maxchairno;
                    }
                    maxchairno++;
                }

            }

        }

        return 0;
    }
}
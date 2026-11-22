public class LC_4080_Design_Bus_Seat_Booking_System {
    class BusBooking {
        int[][] bus;
        int totalcost;

        int mintime;

        public BusBooking(int n) {
            bus = new int[n][4];
            // n rows - each with 4 sits - A , B, C  , D
            totalcost = 0;
            mintime = 0;

        }

        public void toggle(String seat) {

            char seat_c = seat.charAt(0);
            int seatno = 0;
            if (seat_c == 'B')
                seatno = 1;
            else if (seat_c == 'C')
                seatno = 2;
            else if (seat_c == 'D')
                seatno = 3;

            int rowno = Integer.parseInt(seat.substring(1, seat.length())) - 1;

            // middle seat
            if (seatno == 1 || seatno == 2) {
                // already booked
                if (bus[rowno][seatno] != 0) {
                    totalcost -= 1;
                    bus[rowno][seatno] = 0;
                    mintime--;
                } else {
                    totalcost += 1;
                    bus[rowno][seatno] = 1;
                    mintime++;
                }
            } else {
                // window seat - 0 and 3
                // window seat already booked - tooglle
                if (bus[rowno][seatno] != 0) {
                    totalcost -= bus[rowno][seatno];
                    mintime--;
                    bus[rowno][seatno] = 0;
                } else if (seatno == 0) {
                    // adjacent not booked
                    if (bus[rowno][seatno + 1] == 0) {
                        totalcost += 1;
                        mintime++;
                        bus[rowno][seatno] = 1;
                    } else {
                        // adjacent -  booked
                        totalcost += 3;
                        bus[rowno][seatno] = 3;
                        mintime++;
                    }

                } else {
                    // seat = 3;
                    if (bus[rowno][seatno - 1] == 0) {
                        totalcost += 1;
                        mintime++;
                        bus[rowno][seatno] = 1;
                    } else {
                        // adjacent -  booked
                        totalcost += 3;
                        bus[rowno][seatno] = 3;
                        mintime++;
                    }
                }
            }

        }

        public int getTotalTime() {
            return totalcost;
        }

        public int getMinTime() {
            return mintime;
        }
    }

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */
}

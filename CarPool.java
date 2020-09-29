class CarPool {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001];
        for (int[] trip : trips) {
            stops[trip[1]] += trip[0];
            stops[trip[2]] -= trip[0];
        }
        
        for (int i = 0; i < stops.length; i++) {
            if (capacity < 0) return false;
            capacity -= stops[i];
        }
        
        return capacity >= 0;
    }
}



/*
First, build up the array of stops by marking the capacity at index i, which represents the number of seats that are just taken up (+= trips[0]) and the number of seats that are just vacated (-= trips[0]);

Then, check if capacity ever is less than zero, else subtract the current capacity by the number of seats that are taken up, if the number of seats taken up is ever greater than capacity, return false

*/

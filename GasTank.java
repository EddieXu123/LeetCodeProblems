class Solution {
    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     int gasTank = 0;

    //     for (int i = 0; i < gas.length; i++) {
    //         int numTanksHit = 0;
    //         int j = i;
    //         while (numTanksHit < gas.length) {
    //             gasTank += (gas[j % gas.length] - cost[j % gas.length]);
    //             if (gasTank < 0) {
    //                 gasTank = 0;
    //                 break;
    //             }
    //             numTanksHit++;
    //             j++;
    //         }

    //         if (numTanksHit == gas.length && gasTank >= 0) return i;
    //         gasTank = 0;
    //     }

    //     return -1;
    // }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGasConsumed = 0;
        int gasTank = 0;
        int start = -1;

        for (int i = 0; i < gas.length; i++) {
            totalGasConsumed += gas[i] - cost[i];
            gasTank += gas[i] - cost[i];
            if (gasTank < 0) {
                gasTank = 0;
                start = i + 1;
            }
        }

        return totalGasConsumed < 0 ? -1 : start;
    }
}



/*

distanceTraveled = gas.length + 1; to return true

1,2,3,4,5,1,2,3,4,5


gasLeft

1,2,4,4,5
3,4,0,1,2

1,3,7,11,16
3,7,7,8,9


-2,-4,0,


total gas = [1,3,6,10,15]
cost = [3,7,12,13,15]

diff = [-2, -4, -6, -3, 0]


[1]



start from biggest positive diff, if there are two, start from earlier one.






*/

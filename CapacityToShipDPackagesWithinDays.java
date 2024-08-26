public int shipWithinDays(int[] weights, int days) {
        int left = getMax(weights);
        int right = getSum(weights);
        while (left < right) {
            int capacity = left + (right - left) / 2;
            int requiredDays = getRequiredDays(weights, capacity);

            if (requiredDays > days) {
                left = capacity + 1;
            } else {
                right = capacity;
            }
        }

        return left;
    }

    private int getRequiredDays(int[] weights, int maxCapacity) {
        int requiredDays = 1;
        int capacity = 0;
        for (int weight : weights) {
            capacity += weight;
            if (capacity > maxCapacity) {
                requiredDays++;
                capacity = weight;
            }
        }
        return requiredDays;
    }

    private int getSum(int[] arr) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return sum;
    }

    private int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
        }
        return max;
    }

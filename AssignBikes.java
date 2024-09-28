class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] answer = new int[workers.length];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            int distance = Integer.compare(a[0], b[0]);
            if (distance == 0) {
                int workerLocation = Integer.compare(a[1], b[1]);
                if (workerLocation == 0) return Integer.compare(a[2], b[2]);
                return workerLocation;
            }
            return distance;
        });

        for (int i = 0; i < workers.length; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < bikes.length; j++) {
                int[] bike = bikes[j];
                int distance = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
                queue.add(new int[]{distance, i, j});
            }
        }

        Arrays.fill(answer, -1);
        Set<Integer> usedBikes = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            if (answer[tuple[1]] == -1 && !usedBikes.contains(tuple[2])) {
                answer[tuple[1]] = tuple[2];
                usedBikes.add(tuple[2]);
            }
        }

        return answer;
    }
}



/*

distances = [3, 2, 6, 3]


Sort array based off of 0 index



helper func to get manhattan distance between two points


distance(int[] worker, int[] bike) {
    return abs(worker[0] - bike[0]) + abs(worker[1] - bike[1])
}



*/



class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int num : nums) {
            frequencies.put(
                num,
                frequencies.getOrDefault(num, 0) + 1
            );
        }

        int[] res = new int[k];
        Iterator<Integer> iterator = frequencies.keySet().iterator();

        // Initialize res with the first k distinct keys
        for (int i = 0; i < k; i++) {
            res[i] = iterator.next();
        }

        // Find the least frequent element currently in res
        int minIndex = 0;
        int minVal = frequencies.get(res[0]);

        for (int i = 1; i < k; i++) {
            int frequency = frequencies.get(res[i]);

            if (frequency < minVal) {
                minVal = frequency;
                minIndex = i;
            }
        }

        // Check the remaining keys
        while (iterator.hasNext()) {
            int key = iterator.next();
            int frequency = frequencies.get(key);

            if (frequency > minVal) {
                res[minIndex] = key;

                // Recalculate the minimum after replacement
                minIndex = 0;
                minVal = frequencies.get(res[0]);

                for (int i = 1; i < k; i++) {
                    int currentFrequency = frequencies.get(res[i]);

                    if (currentFrequency < minVal) {
                        minVal = currentFrequency;
                        minIndex = i;
                    }
                }
            }
        }

        return res;
    }
}
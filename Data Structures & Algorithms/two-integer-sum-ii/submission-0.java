class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            
            if (currentSum == target) {
                // Return 1-indexed positions
                return new int[]{left + 1, right + 1};
            } else if (currentSum > target) {
                // Sum is too high, move the right pointer leftward to reduce it
                right--;
            } else {
                // Sum is too low, move the left pointer rightward to increase it
                left++;
            }
        }
        
        // Return an empty array if no solution is found (guaranteed not to hit based on constraints)
        return new int[]{};
    }
}

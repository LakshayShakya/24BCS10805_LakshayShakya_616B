class Solution {

    public int minOperations(int[] nums, int x) {
        int target = 0;
        for (int n : nums)
            target += n;
        target -= x;
        if (target < 0)
            return -1;
        if (target == 0)
            return nums.length;
        int maxLen = -1;
        int left = 0;
        int windowSum = 0;
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            while (windowSum > target && left <= right) {
                windowSum -= nums[left++];
            }
            if (windowSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}
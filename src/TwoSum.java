import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public int[] twoSumST(int[] nums, int target) {
        // Key is the val, Value is the index
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (!result.containsKey(complement)) {
                result.put(nums[i], i);
            }
            else {
                return new int[] { result.get(complement), i};
            }
        }
        throw new IllegalArgumentException();
    }

}

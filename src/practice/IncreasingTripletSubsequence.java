package practice;

// LC - #334
public class IncreasingTripletSubsequence {

    /*
    If there's any need to return the index / values of Triplet
    Keep 3 other variables to hold the index / value
     */

    static boolean hasTriplet(int[] nums) {

        if(nums.length < 3) return false;

        int i = nums[0];
        int j = Integer.MAX_VALUE;

        for (int k : nums) {

            if(k > j) return true;

            if(k > i)
                j = k;

            i = k;
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 5, 12, 4, 6};

        System.out.println(hasTriplet(nums));

    }
}

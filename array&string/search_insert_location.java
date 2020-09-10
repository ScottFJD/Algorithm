class test2 {

    /*
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/array-and-string/cxqdh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    
    */ 



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testCase = {1,3,5,6};
        int target  = 7;
        System.out.println(solution.searchInsert(testCase, target));
    }

    static class Solution {

        //注意处理极限情况
        public int searchInsert(int[] nums, int target) {
            int length = nums.length;
            if(target>nums[length-1]){
                return length;
            }
    
            for(int i=0; i<nums.length-1;i++){
                if(nums[i]<target && target<=nums[i+1]){
                    return i+1;
                } 
            }
            return 0;
        }
    }
}

import java.util.Arrays;

class test3 {
    /*
    给出一个区间的集合，请合并所有重叠的区间。

 

示例 1:

输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: intervals = [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。

 

提示：

intervals[i][0] <= intervals[i][1]

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/array-and-string/c5tv3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    
    */
    

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCase = {{1,3},{2,6},{8,10},{15,18}};
        for (int[] is : solution.merge(testCase)) {
            System.out.println(String.valueOf(is[0])+String.valueOf(is[1]));
        }

        for (int[] is : solution.mergeV2(testCase)) {
            System.out.println(String.valueOf(is[0])+String.valueOf(is[1]));
        }
    }

    static class Solution{
        public int[][] merge(int[][] intervals){
            Arrays.sort(intervals,(v1,v2) -> v1[0]-v2[0]);

            int[][] res = new int[intervals.length][2];
            int idx = -1;
            for(int[] interval: intervals){
                if(idx==-1 || interval[0] > res[idx][1]){
                    res[++idx] = interval;
                }else{
                    res[idx][1] = Math.max(res[idx][1], interval[1]);
                }
            }

            return Arrays.copyOf(res, idx+1);
            
        }


        public int[][] mergeV2(int[][] intervals) {
            //将区间按起始位排序
            Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);

            int[][] merge = new int[intervals.length][2];
            
            int index = -1;
            for (int[] is : intervals) {
                //如果第一个区间的末端小于后面一个区间的起始端 则添加，否则mege 末端
                if (index==-1|| merge[index][1]<is[1]) {
                    merge[++index] = is;
                }else{
                    merge[index][1] = Math.max(merge[index][1], is[1]);
                }
                
            }

            System.out.println(index);
            //复制有效的区间并返回
            return Arrays.copyOf(merge, index+1);
            
        }

    }

}

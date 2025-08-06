class Solution {
    public static int zeroSumSubmat(int[][] matrix) {
        // code here
        int n=matrix.length;
        int m=matrix[0].length;
        int maxArea=0;
        // int sum=0;
        for(int colStart=0;colStart<m;colStart++){
            int[] sum=new int[m];
            for(int colEnd=colStart;colEnd<m;colEnd++){
                for(int row=0;row<n;row++){
                    sum[row]+=matrix[row][colEnd];
                }
                int length=colEnd-colStart+1;
                int maxLength=longestSubarrayWithZeroSum(sum);
                maxArea=Math.max(maxArea,length*maxLength);
            }
        }
        return maxArea;
    }
    public static int longestSubarrayWithZeroSum(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxLen=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
                maxLen=i+1;
            }
            if(map.containsKey(sum)){
                maxLen=Math.max(maxLen,i-map.get(sum));
            }
            map.put(sum,i);
        }
        return maxLen;
    }
}

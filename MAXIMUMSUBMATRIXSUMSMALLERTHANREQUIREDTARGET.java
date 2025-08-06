class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        int maxSum=0;
        for(int colStart=0;colStart<m;colStart++){
            int[] sum=new int[n];
            for(int colEnd=colStart;colEnd<m;colEnd++){
                for(int row=0;row<n;row++){
                    sum[row]+=matrix[row][colEnd];
                }
                int currSum=getMaxSubarraySumSmallerThanK(sum,k);
                maxSum=Math.max(maxSum,currSum);
            }
        }
        return maxSum;
    }
    public static int getMaxSubarraySumSmallerThanK(int[] arr,int k){
        int maxSum=0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
            }
            if(sum<=k){
                maxSum=Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }
}

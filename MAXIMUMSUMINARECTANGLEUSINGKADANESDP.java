Maximum rectangle i a matrix kadanes algorithm

krle isko sarthak bhai
class Solution {
    public int maxRectSum(int matrix[][]) {
        // code here
        int n=matrix.length;
        int m=matrix[0].length;
        int[] sum=new int[n];
        int ans=Integer.MIN_VALUE;
        for(int colStart=0;colStart<m;colStart++){
            Arrays.fill(sum,0);
            for(int colEnd=colStart;colEnd<m;colEnd++){
                for(int row=0;row<n;row++){
                    sum[row]+=matrix[row][colEnd];
                }
                int maxSum=kadanes(sum);
                ans=Math.max(ans,maxSum);
            }
        }
        return ans;
    }
    public static int kadanes(int[] arr){
    int currSum = arr[0];
    int maxSum = arr[0];
    for(int i = 1; i < arr.length; i++){
        currSum = Math.max(arr[i], currSum + arr[i]);
        maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
 }
};

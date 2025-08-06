class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int count=0;
        for(int colStart=0;colStart<m;colStart++){
            int[] sum=new int[n];
            for(int colEnd=colStart;colEnd<m;colEnd++){
                for(int row=0;row<n;row++){
                    sum[row]+=matrix[row][colEnd];
                }
                count+=countSubarrayWithTarget(sum,target);
            }
        }
        return count;
    }
    public static int countSubarrayWithTarget(int[] arr,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum-target)){
                count+=map.get(sum-target);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}

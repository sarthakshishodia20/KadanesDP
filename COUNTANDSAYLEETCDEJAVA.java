class Solution {
    public String countAndSay(int n) {
        String ans="1";
        while(n-->1){
            ans=say(ans);
        }
        return ans;
    }
    public static String say(String str){
        StringBuilder sb=new StringBuilder();
        int count=1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                count++;
            }
            else{
                sb.append(count);
                sb.append(str.charAt(i-1));
                count=1;
            }
        }
        sb.append(count).append(str.charAt(str.length()-1));
        return sb.toString();
    }
}

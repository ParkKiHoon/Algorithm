import java.util.*;
class Solution {
    public int[] solution(String s) {
        s=s.substring(2,s.length()-2);
        String[] split=s.split("},\\{");

        Arrays.sort(split,new Comparator<String>(){
           
            @Override
            public int compare(String s1, String s2){
                return s1.length()-s2.length();
            }
        });
        
        //System.out.println(Arrays.toString(split));
        int[] ans=new int[split.length];
        int[] arr=new int[100001];
        for(int i=0;i<ans.length;i++){
            String[] tmp = split[i].split(",");
            for(String ind_str : tmp){
                int ind=Integer.parseInt(ind_str);
                if(arr[ind]==0){
                    ans[i]=ind;
                    arr[ind]=1;
                    break;
                }
            }
        }
        return ans;
    }
}
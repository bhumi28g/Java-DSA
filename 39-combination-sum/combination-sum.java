class Solution {
    public void sum(int[] arr, int target, int start, List<Integer> temp,List<List<Integer>> ans){
        if(target==0){       
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<arr.length;i++){
            if(arr[i]<=target){
                temp.add(arr[i]);
                sum(arr,target-arr[i],i,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        sum(candidates,target,0,new ArrayList<>(),ans);
        return ans;
    }
}
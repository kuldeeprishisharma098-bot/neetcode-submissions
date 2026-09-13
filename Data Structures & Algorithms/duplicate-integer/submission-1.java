class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hm=new HashSet<>();
        for(int ele:nums){
        if(hm.contains(ele)){
            return true;
        }
            hm.add(ele);
        }
        return false;
    }
}
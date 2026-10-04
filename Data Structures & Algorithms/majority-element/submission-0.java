class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int ele:nums){
            hm.put(ele,hm.getOrDefault(ele,0)+1);
            if(hm.get(ele)>nums.length/2){
                return ele;
            }
        }
return -1;

    }
}
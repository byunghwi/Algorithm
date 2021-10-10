public class FindPeakElement2 {
    public void main(String[] args){
        int[] nums = new int[]{1,2,1,3,5,6,4};
        findPeakElement(nums);
    }

    public int findPeakElement(int[] nums) {

        int left = 1;
        int right = nums.length-2;

        if(nums.length==1) // 배열 요소가 1개일 경우
            return nums[0];
        if(nums[0] > nums[1]) // 첫번째 요소가 두번째요소보다 클 경우
            return nums[0];
        if(nums[nums.length-1] > nums[nums.length-2]) // 마지막 요소가 마지막 전 요소보다 클 경우
            return nums[nums.length-1];


        while(left <= right){
            int middle = (left+right)/2;
            if(nums[middle] > nums[middle+1] && nums[middle] > nums[middle-1])
                return nums[middle];

            if(nums[middle] < nums[middle-1])
                right--;
            else
                left++;
        }

        return -1;

    }
}

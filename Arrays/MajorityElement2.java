
public class MajorityElement2 {
    public int majorityElement(int[] nums) {
        int result = 0;
        int n = nums.length;
        int cnt1=0,cnt2=0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int min = (int)(n/3)+1;
        for(int i=0;i<n;i++)
        {
            if(cnt1 == 0 && nums[i] != ele2)
            {
                cnt1=1;
                ele1 = nums[i];
            }
            else if (cnt2 == 0 && nums[i] != ele1)
            {
                cnt2=1;
                ele2 = nums[i];
            }
            else if(ele1 == nums[i]) {
                cnt1++;
            }
            else if(ele2 == nums[i])
            {
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int i=0;i<n;i++)
        {
            if(ele1 == nums[i])  cnt1++;
            if (ele2 == nums[i]) cnt2++;
        }
        if(cnt1 >= min)
        {
          result = ele1;
        }
        if(cnt2 >= min)
        {
            result = ele2;
        }
        return result;
    }
    public static void main(String[] args) {
        MajorityElement2 m1 = new MajorityElement2();
        int arr[] = {2,1,1,3,1,4,5,6};
        int result = 0;
        result = m1.majorityElement(arr);
        System.out.println("Majority element (n/3) time is : "+result);
    }
}

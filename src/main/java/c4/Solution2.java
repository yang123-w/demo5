package c4;

public class Solution2 {

    public int [] merge(int[] nums1, int[] nums2) {

        int [] merge = new int[nums1.length+nums2.length];

        int p1 = 0;

        int p2 = 0;

        int p = 0;

        while (p1<nums1.length && p2<nums2.length){
            if(nums1[p1]<=nums2[p2]){
                merge[p] = nums1[p1];
                merge[p+1] = nums2[p2];
                p1++;
            }else{
                merge[p] = nums2[p2];
                merge[p+1] = nums1[p1];
                p2++;
            }
            p++;
        }

        if (p1 < nums1.length)
            System.arraycopy(nums1, p1, merge, p1 + p2, nums1.length + nums2.length - p1 - p2);
        if (p2 < nums2.length)
            System.arraycopy(nums2, p2, merge, p1 + p2, nums1.length + nums2.length - p1 - p2);

        return merge;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums1 =new int [] {1,2,4,5,9,13};
        int[] nums2 = new int [] {0,1,3,6,11};
        int[] merge = solution2.merge(nums1, nums2);
        for (int n:merge) {
            System.out.print(n+",");
        }
    }
}

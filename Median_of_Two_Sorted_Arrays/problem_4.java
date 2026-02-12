class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n+m];
        int k=0;
        for(int i=0;i<n;i++){
            merged[k++]=nums1[i];
        }
        for(int j=0;j<m;j++){
            merged[k++]=nums2[j];
        }
        Arrays.sort(merged);
        int l = merged.length;
        if(l%2==1){
            return (double)(merged[l/2]);
        }
        else{
            int left = l/2;
            int right = (l/2)-1;
            return (double)(merged[left]+merged[right])/2;
        }

    }
}

package as;

public class merge_88 {

	public static void main(String[] args) {
		int[] num1 ={1,2,3,0,0,0};
		int[] num2 ={2,5,6};
		merge(num1,3,num2,3);
		for (int i = 0; i < num1.length; i++) {
			System.out.print(num1[i]+" ");
		}
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
	     int i = m-1;
	     int j = n-1;
	     int index = m+n-1;
	     while(index>0){
	    	 if(j<0)
	    		 nums1[index--] = nums1[i--];
	    	 else if(i<0)
	    		 nums1[index--] = nums2[j--];
	    	 else if(nums1[i]<nums2[j])
	    		 nums1[index--]=nums2[j--];
	    	 else
	    		 nums1[index--]=nums1[i--];
	     }
	}
}

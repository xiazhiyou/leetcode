package as;

import java.util.ArrayList;
import java.util.List;

public class getAllNotInclude {

	public static void main(String[] args) {
		int[] b={1,2,3,5,3,6,8,1};
		int[] a={2,3,4};
		List<Integer> fun = fun(a,b);
		System.out.println(fun.toString());
	}

	public static List<Integer> fun(int[] a,int[] b){
		
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < b.length; i++) {
			int l=0;
			int r=a.length-1;
			boolean contain =false;
			while(l<=r){
				int mid=l+((r-l)>>1);
				if(a[mid]==b[i]){
					contain=true;
					break;
				}else if(a[mid]<b[i]){
					l=mid+1;
				}else{
					r=mid-1;
				}
			}
			
			if(!contain)
				res.add(b[i]);
		}
		return res;
	}
}

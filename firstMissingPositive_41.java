package as;

public class firstMissingPositive_41 {

	public static void main(String[] args) {
		int[] m = {3,4,-1,1};
		System.out.println(firstMissingPositive(m));
	}

	private static int firstMissingPositive(int[] m) {
		int l=0;
		int r=m.length;
		while(l<r){
			if(m[l]==l+1)
				l++;
			else if(m[l]<=l || m[l]>r || m[l] == m[m[l]-1])
				m[l]=m[--r];
			else
				swap(m,l,m[l]-1);
		}
		return l+1;
	}

	private static void swap(int[] m, int l, int i) {
		int tmp = m[l];
		m[l]=m[i];
		m[i]=tmp;
	}
}

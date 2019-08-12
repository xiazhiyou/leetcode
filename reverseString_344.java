package as;

public class reverseString_344 {
	public static void main(String[] args) {
		char[] s = {'a','b','c','d','e'};
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]+" ");
		}
		System.out.println();
		char[] s1 = reverseString(s);
		for (int i = 0; i < s1.length; i++) {
			System.out.print(s1[i]+" ");
		}
	}

	private static char[] reverseString(char[] s) {
		
		int m = 0;
        int n = s.length - 1;
        char temp = ' ';
        while(m < n){
            temp = s[m];
            s[m] = s[n];
            s[n] = temp;
            m++;
            n--;
        }
		return s;
	}
}

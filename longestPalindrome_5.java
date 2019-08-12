package as;

import java.util.Vector;

public class longestPalindrome_5 {
	public static void main(String[] args) {
		String s1="acvdvc";
		String s3 = longestPalindrome(s1);
		System.out.println(s3);
	}

	private static String longestPalindrome(String s1) {

		if(s1.length()<1)
			return "";
		if(s1.length()==1)
			return s1;
		
		if(s1.length()==2){
			char[] cs = s1.toCharArray();
			if(cs[0]==cs[1])
				return s1;
			else
				return String.valueOf(cs[0]);
		}
		char[] charArr = manacherString(s1);
		int[] prr = new int[charArr.length];
		
		int max = Integer.MIN_VALUE;
		int index=-1;
		int pr = -1;
		for (int i = 0; i < charArr.length; i++) {
			prr[i] = pr>i? Math.min(prr[2*index-i],pr-i):1;
			while(i+prr[i]<charArr.length && i-prr[i]>-1){
				if(charArr[i+prr[i]] == charArr[i-prr[i]])
					prr[i]++;
				else 
					break;
			}
			
			if(i+prr[i]>pr){
				pr=i+prr[i];
				index=i;
			}
			max=Math.max(max, prr[i]);
		
			/*if(pr==charArr.length){
				maxEnd = prr[i];
				break;
			} */
		}
		System.out.println(max-1);
		int c = 0;
		int maxe = prr[0];
		for (int i = 0; i < prr.length; i++) {
			if(prr[i]>maxe){
				maxe=prr[i];
				c=i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		char[] ds = s1.toCharArray();
		for (int i = (c-prr[c]+1)/2; i < (c-prr[c]+1)/2+max-1; i++) {
			sb.append(ds[i]);
		}
		return sb.toString();
		/*char[] res = new char[s1.length()-maxEnd+1];
		for (int i = 0; i < res.length; i++) {
			res[res.length-1-i]=charArr[2*i+1];
		}*/
	}

	private static char[] manacherString(String s1) {

		char[] arr = s1.toCharArray();
		char[] res = new char[arr.length*2+1];
		int index=0;
		for (int i = 0; i < res.length; i++) 
			res[i] = (i&1)==0? '#':arr[index++];
		
		return res;
	}
}



/*if(s.size()<2) return s;
int n = s.size();
int dp[n][n]={0};
dp[n-1][n-1] = 1;
int start=0,maxLen=1;
for(int i=n-2;i>=0;i--){
    dp[i][i] = 1;
    for(int j=n-1;j>=i;j--){
        if(j==i+1){
            dp[i][j] = s[i]==s[j];
        }
        if(j>i+1)
            dp[i][j] = (s[i] == s[j]) && (dp[i+1][j-1]);
        if(maxLen<j-i+1 && dp[i][j]){
            start = i;
            maxLen = j-i+1;
        }
    }
}
return s.substr(start,maxLen);*/












	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Scanner;
	import java.util.List;
	
	public class p1205_wrong {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			int numJokers = 0;
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
				if(arr[i]==0) numJokers++;
			}
			
			Arrays.sort(arr);
			List<Integer> list = new ArrayList<>(0);
			int n = 1;
			for(int i=numJokers;i<N-1;i++) {
				if(arr[i]==arr[i+1]) {
	
				} else if(arr[i]+1==arr[i+1]) { 
					n++;
				} else {
					list.add(n);
					list.add(arr[i+1]-arr[i]-1);
					n = 1;
				}
			}
			list.add(n);
			
			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(list.toArray()));
			
			int max = -1;
			int left = 0;
			
			//하나만 있는 경우
			if(list.size()==1) {
				System.out.println(list.get(0)+numJokers);
				return;
			}
			
			//초기값 세팅
			int start = 0;
			int possibleJokers = numJokers;
			int temp = list.get(0);
			if(list.get(1)<=possibleJokers) {
				temp+=list.get(1)+list.get(2);
				possibleJokers-=list.get(1);
			} else {
				temp = list.get(2);
				start = 2;
			}
			
			
			for(int i=2;i<list.size()-2;i+=2) {
				if(temp>max) {
					max = temp;
					left = possibleJokers;
				}
				if(list.get(i+1)<=possibleJokers) {
					temp+=list.get(i)+list.get(i+1);
					possibleJokers-=list.get(i+1);
				} else if (i!=start) {
					temp-=(list.get(start)+list.get(start+1));
					possibleJokers+=list.get(start+1);
					start+=2;
					if(possibleJokers!=numJokers) i+=2;
				} else {
					start+=2;
					temp = list.get(start);
				}
			}
			
			System.out.println((start==0)?max:max+left);
		}
	}
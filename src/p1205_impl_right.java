import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class p1205_impl_right {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		int numJokers = 0;
		int maxInput = -1;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] == 0)
				numJokers++;
			
			maxInput = Math.max(maxInput, arr[i]);
		}
		
		if(numJokers==N) {
			System.out.println(numJokers);
			return;
		}

		Arrays.sort(arr);
		List<Integer> list = new ArrayList<>(0);
		int n = 1;
		for (int i = numJokers; i < N - 1; i++) {
			if (arr[i] == arr[i + 1]) {

			} else if (arr[i] + 1 == arr[i + 1]) {
				n++;
			} else {
				list.add(n);
				list.add(arr[i + 1] - arr[i] - 1);
				n = 1;
			}
		}
		list.add(n);
		
		list.add(Integer.MAX_VALUE);

//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(list.toArray()));

		int answer = numJokers;
		
		// 왼쪽 오른쪽으로 본다
		// 왼쪽을 꽉 채울 수 있다 --> 이 경우였다면 이 전에 이미 여기로 넘어왔을거임.. 굳이 안봐도 된다. 그러니 오른쪽을 우선적으로 끝까지 가보고 왼쪽에
		// 넣을 수 있을 정도로 남으면 왼쪽을 채운다
		// 음.. 왼쪽을 꼭 봐야할까..? 우선 안보고 해보자
		for(int i=0;i<list.size();i+=2) {
			int temp = list.get(i);
			
			int leftJokers = numJokers;
			int tempIdx = i+1;
			//오른쪽으로 가능하면 계속 더하기
			while(tempIdx<list.size() && leftJokers!=0) {
				if(leftJokers>=list.get(tempIdx)) { // 다 채울 수 있다면
					leftJokers-=list.get(tempIdx);
					temp+=list.get(tempIdx);
					if(tempIdx+1<list.size()) temp+=list.get(tempIdx+1);
					tempIdx+=2;
				} else { //다 못채운다면, 가능한만큼 채우자
					temp+=leftJokers;
					leftJokers=0;
				}
			}
			
			answer = Math.max(answer, temp);
		}
		
		System.out.println(answer);
	}
}
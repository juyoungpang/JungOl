import java.util.Scanner;

public class p1037_impl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] mssg = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				mssg[i][j] = sc.nextInt();
			}
		}
		
		int pR = 0;
		int pC = 0;
		
		int cRow = -1;
		int cCol = -1;
		
		for(int i=0;i<N;i++) {
			int row = 0;
			int col = 0;
			for(int j=0;j<N;j++) {
				row+=mssg[i][j];
				col+=mssg[j][i];
			}
			
			if(row%2!=0) {
				if(cRow!=-1) {
					pR = 2;
					break;
				} else {
					cRow = i;
					pR = 1;
				}
			}
			
			if(col%2!=0) {
				if(cCol!=-1) {
					pC = 2;
					break;
				} else {
					cCol = i;
					pC = 1;
				}
			}
		}
		
		if(pR!=pC || pR==2 || pC==2) {
			System.out.println("Corrupt");
		} else if(pR==0 && pC == 0) {
			System.out.println("OK");
		} else {
			System.out.printf("Change bit (%d,%d)\n", cRow+1, cCol+1);
		}
		
	}
}
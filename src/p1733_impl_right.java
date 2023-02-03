import java.util.Scanner;

public class p1733_impl_right {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[19][19];
		
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int winner = 0;
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(map[i][j]!=0) {
					int stone = map[i][j];
					
					for(int k=1;k<5;k++) {
						if(j+k>=19) break;
						if(j-1>=0 && map[i][j-1]==stone) break;

						if(map[i][j+k]!=stone) {
							break;
						}
						if(k==4 && (j+k+1>=19 || map[i][j+k+1]!=stone)) {
							System.out.println(stone);
							System.out.println((i+1)+" "+(j+1));
							return;
						}
					}
					
					for(int k=1;k<5;k++) {
						if(i+k>=19) break;
						if(i-1>=0 && map[i-1][j]==stone) break;

						if(map[i+k][j]!=stone) {
							break;
						}
						if(k==4 && (i+k+1>=19 || map[i+k+1][j]!=stone)) {
							System.out.println(stone);
							System.out.println((i+1)+" "+(j+1));
							return;
						}
					}
					
					for(int k=1;k<5;k++) {
						if(i+k>=19 || j+k>=19) break;
						if(i-1>=0 && j-1>=0 && map[i-1][j-1]==stone) break;
							
						if(map[i+k][j+k]!=stone) {
							break;
						}
						if(k==4 && (i+k+1>=19 || j+k+1>=19 || map[i+k+1][j+k+1]!=stone)) {
							System.out.println(stone);
							System.out.println((i+1)+" "+(j+1));
							return;
						}
					}
					
					for(int k=1;k<5;k++) {
						if(i-k<0 || j+k>=19) break;
						if(i+1<19 && j-1>=0 && map[i+1][j-1]==stone) break;
						
						if(map[i-k][j+k]!=stone) {
							break;
						}
						if(k==4 && (i-(k+1)<0 || j+k+1>=19 || map[i-k-1][j+k+1]!=stone)) {
							System.out.println(stone);
							System.out.println((i+1)+" "+(j+1));
							return;
						}
					}
				}
			}
		}
		
		System.out.println(0);
	}
}
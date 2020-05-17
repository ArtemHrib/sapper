import java.util.Random;

public class Map {
	 int mass[][];
	public Map() {
			mass = new int[16][16];
			generateMapMass();
		}
	private void generateMapMass() {
		Random rand = new Random();
		int bombSize,mapSize;
		
			bombSize = 25;
			mapSize = 16;

			for(int i = 0;i<bombSize;i++) {
				int t1 = rand.nextInt(mapSize);
				int t2 = rand.nextInt(mapSize);
					if(mass[t1][t2]!=10) {
						mass[t1][t2]=10;
						for(int x1 = t1-1; x1 <= t1+1; x1++) {
							for(int x2 = t2-1; x2 <= t2+1; x2++) {
								if(x1>-1&&x2>-1&&x1<mapSize&&x2<mapSize&&mass[x1][x2]!=10&&mass[x1][x2]!=10) {
									mass[x1][x2]+=1;
								}
							}
						}
					}else {
						i--;
					}
			}
		
	}
 	public int[][] getMass(){
		return mass.clone();
	}
}

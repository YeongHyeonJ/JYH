package day6;

public class ArrayMultiDimensionEx2 {

	public static void main(String[] args) {
		int [][] mu = new int[10][10];
		for(int i = 2 ; i <= 9 ; i++ ) {
			for(int j = 1 ; j <= 9 ; j++ ) {
				mu[i][j] = i*j;
				System.out.println(i + " X " + j + " = " + mu[i][j]);
			}
		}

	}

}

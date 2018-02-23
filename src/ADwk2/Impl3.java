package ADwk2;

import static java.util.Arrays.asList;

import java.util.ArrayList;

public class Impl3 {

  public static void main(String[] args) {
	
	double[][] a = {{1.2, 1.3, 1.4},{0.1,0.2}};
	
	double[][] c = clone(a);
	
	
	for (int i=0; i<c.length; i++) {
	  for (int j=0; j<c[i].length; j++){
		System.out.println(c[i][j]);
	  }
	}

  }
  
  
  
  static double[][] clone(double[][] a) {
	double[][] b = new double[a.length][];
	
	for (int i=0; i<a.length; i++) {
	  double [] row = new double [a[i].length];
	  for (int j=0; j<a[i].length; j++){
		row[j] = a[i][j];
	  }
	  b[i] = row; 
	}
	return b;
}

  
}

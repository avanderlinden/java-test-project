package ADwk2;

public class Impl4 {
  
public static void main(String[] args) {
	System.out.println(multiply(12,12));
  } 
 
  static int multiply(int num1, int num2) {
	int result = 0;
	boolean negative_flag = false;
	
    if ((num1 < 0) && (num2 < 0)) {
      num1=-num1;
      num2=-num2;
    } else if((num1 < 0) && (num2 >= 0)) {
      num1=-num1;
      negative_flag = true;
    } else if((num2 < 0) && (num1 >= 0)) {
      num2=-num2;
      negative_flag = true;
    }
	
	for(int i=0; i<num2; i++) {
  		result += num1;
    }
    
	if(negative_flag) {
	  return -result;
	} else {
	  return result;
	}
    
  }

}
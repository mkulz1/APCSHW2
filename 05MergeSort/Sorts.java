public class Sorts{
   
    public static void sort(int[] array){
	mergesort(array,0,array.length-1);
    }
    public static void mergesort(int[] array, int l, int r){
	if(l < r) {
	    int c = (l + r) / 2; //splits array into 2

	    mergesort(array,l,c); //sorts left array
	    mergesort(array,c+1,r); //sorts right array
	    merge(array,l,c+1,r); //puts them back together
	}
    }
    public static void merge(int[] array, int lStart, int rStart, int rEnd){
	int lEnd = rStart - 1;

	int numE = rEnd - lStart + 1;
	int[] result = new int[numE];
	int resE = 0;

	while(lStart <= lEnd && rStart <= rEnd){
	    if(array[lStart] <= array[rStart]){
		result[resE++] = array[lStart++];
	    }else{
		result[resE++] = array[rStart++];
	    }
	}
	//copy over left
	while(lStart < lEnd){
	    result[resE++] = array[lStart++];
	}
	//copy over right
	while(rStart < rEnd){
	    result[resE++] = array[rStart++];
	}
	//copy back
	for(int i = numE - 1; i >= 0; i--,rEnd--){
	    array[rEnd] = result[i];
	}
    }
    

   
    
    public static void main(String[]args){
	
	int array[] = {7, 1, 8, 2, 0, 12, 10, 7, 5, 3};
	int tester[] = new int[1000];
      
	Sorts mergeSort = new Sorts();

	for (int i = 0 ; i < tester.length ; i++) { 
		tester[i] = (int) (Math.random () * 10); 
	    }
	
        mergeSort.sort(array);
	mergeSort.sort(tester);


    }


}

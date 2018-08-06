package algorithm;

public class HeapSort {
	
	public static void main(String[] args) {
		int[] A = {10,3,2,5,1,20};
		int len = A.length;
		for(int i = 0; i < len; i++) {
			System.out.print(A[i]+"\t");
		}
		System.out.println("\t");
		heapify(A);
		for(int i = 0; i < len; i++) {
			System.out.print(A[i]+"\t");
		}
	}
    /**
     * @param A: Given an integer array
     * @return: void
     */
	public static void siftup(int[] A, int k) {
        while (k != 0) {
            int father = (k - 1) / 2;
            if (A[k] > A[father]) {
                break;
            }
            int temp = A[k];
            A[k] = A[father];
            A[father] = temp;
            
            k = father;
        }
    }
    
	public static void heapify(int[] A) {
        for (int i = 0; i < A.length; i++) {
            siftup(A, i);
        }
    }
}
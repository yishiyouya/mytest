package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindLongist {
	public static void main(String[] args) {
		testHashMap();
	}
	
	public static void testHashMap() {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		map.put(0, 2);
		System.out.println(map);
	}
	
  public static List<List<Integer>> combinationSum() {
	  	int[] candidates= {1,2,3,5,4};
	  	int target=7;
    	Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        System.out.println(result);
        return result;
    }
    
    private static void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
    	if(target > 0){
    		for(int i = start; i < candidates.length && target >= candidates[i]; i++){
    			cur.add(candidates[i]);
    			getResult(result, cur, candidates, target - candidates[i], i);
    			cur.remove(cur.size() - 1);
    		}//for
    	}//if
    	else if(target == 0 ){
    		result.add(new ArrayList<Integer>(cur));
    	}//else if
    }
	    
	public static void testList() {
		List<Integer> list = new ArrayList<>();
		list.add(0, 1);
		list.add(0, 2);
		System.out.println(list);
	}
	
	public static void testPrimaryQueue() {
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		pQueue.offer(2);
		pQueue.offer(1);
		pQueue.offer(3);
		System.err.println(pQueue.remove());
		System.err.println(pQueue.remove());
		System.err.println(pQueue.remove());
	}
	
	public static int thirdMax() {
		int[] nums = {3,2,2,1};
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
 
	public static boolean containsDuplicate() {
		int[] nums = {3,3};
        boolean flag = false;
        boolean mflag = false;
        int count = 0;
        int dm = 0;
        if(nums.length < 2){
            return flag;
        }
        for(int num : nums){
            if(count == 0){
                dm = num;
                ++count;
            }else{
                if(dm == num){
                    ++count;
                    flag = (count % 2 == 0) ? false : true;
                }else{
                    --count;
                }
            }
        }
        return flag;
    }
	
	public static void rotate() {
		int[] nums = {1,2,3,4,5,6};
		int k = 3;
        int len = nums.length;
        if(len < k || k < 0 || len == 1){
            return;
        }
        int[] temp = new int[k+1];
        for(int i = 0;i < len;i++){
            if(i < k+1){
                temp[i] = nums[i];
            }else{
                nums[i-k-1] = nums[i];
            }
        }
        if(k+1 == len) {
        	for(int j=0; j < temp.length;j++){
                nums[temp.length - j - 1] = temp[j];
            }
        	return;
        }
        for(int j=0; j < temp.length;j++){
            nums[k+j-1] = temp[j];
        }
    }
	 
	 public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
            res.add(1);
            for(int j = i-1; j > 0; j--) {
                res.set(j, res.get(j-1) + res.get(j));
            }
        }
        return res;
    }
	 
	public static int searchInsert() {
		int[] nums = {1,3,4};
		int target = 2;
        int index = 0;
        int j = 0;
        int len = nums.length;
    	if(nums[0] > target)
    		index = 0;
    	if(nums[len-1] < target)
    		index = len;
        
        for(int i = 0; i < len - 1; i++){
            if(nums[i] <= target && nums[++i] >= target){
                if(nums[i] == target){
                    index = i;
                }else{
                    index = ++i;    
                }
            }
        }
        return index;
    }
	
	public static int removeElement() {
		int[] nums = {3,2,2,3};
		int val = 3;
	    int len = nums.length;
	    for (int i = 0 ; i< len; ++i){
	    	if(nums[i] == val){
                nums[i--] = nums[--len];
            }
	    }
	    System.out.println(nums.length);
	    return len;
	}
	
	 public int removeDuplicates(int[] nums) {
	        int fLen = 0;
	        int nLen = nums.length;
	        for(int i = 0;i < nLen - 1;i++){
	            if(nums[i] == nums[i+1]){
	                nLen--;
	            }
	        }
	        return fLen;
	    }

	//数字数组中连续和最大
	public static void subBigest() {
		int[] arr = {1,-3,10,-2,20,-3,9};
		int sum = 0;
		int max = 0;
		for(int i : arr) {
			if(sum <= 0) {
				sum = i;
			}else {
				sum += i;
			}
			if(sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
	}
	
	//数字中0连续最大:非0转统一标识，按标识分隔，遍历取最大
	public static void longistNum() {
        Scanner scan=new Scanner(System.in);
        String str = "";
        if(scan.hasNext()){
            str=scan.nextLine();
        }
		char[] chaArr = str.toCharArray();
        String res = "";
		int max = 0;
		for(int i = 0;i < chaArr.length; i++) {
			if('0' <= chaArr[i] && '9' >= chaArr[i]) {
				res += chaArr[i];
			}else {
				res += "1";
			}
			
		}
		for(String strL : res.split("1")) {
			if(max < strL.length()) {
				max = strL.length();
			}
		}
		for(String strL : res.split("1")) {
			if(max == strL.length()) {
				System.out.print(strL+",");
			}
		}
		System.out.println(max);
	}

}

package longUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stackOverSingle();
	}

	public static void stackOverSingle() {
		stackOverDouble();
	}
	
	public static void stackOverDouble() {
		stackOverSingle();
	}
	
	public static void heapOver() {
		List<Long> list = new ArrayList<>();
		for(long i = 0l; i < 20000000000l; i++) {
			list.add(i);
		}
	}
	
	public static void nullList() {
		final List<Object> c = new LinkedList();
		c.add(null);
		c.add(null);
		c.add(null);
		c.add(null);
		c.add(null);
		int size = c.size();
		size = size + (size >> 1);
		System.out.println(size);
	}
	
	public static void batchRemove() {
		final Object[] elementData = {1,2,3};
		final List<Object> c = new ArrayList<Object>();
		c.add(1);
		int size = elementData.length;
		int r = 0, w = 0;
        boolean modified = false;
        for (; r < size; r++)
            if (c.contains(elementData[r]) == false)
                elementData[w++] = elementData[r];
        
        if (r != size) {
            System.arraycopy(elementData, r,
                             elementData, w,
                             size - r);
            w += size - r;
        }
        if (w != size) {
            // clear to let GC do its work
            for (int i = w; i < size; i++)
                elementData[i] = null;
            size = w;
            modified = true;
        }
        
        
        for(Object obj : elementData) {
        	System.out.println((Integer)obj);
        }
	}
	
	public static void retaMoList() {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> res = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		res.add(2);
		res.add(3);
		list.retainAll(res);
		System.out.println(list);
	}
	
	public static void list2List() {
		Student stu = new Student("hh", 1);
		Student stu1 = new Student("hh", 2);
		List<Student> res = new ArrayList<Student>();
		List<Student> res1 = new ArrayList<Student>();
		List<List<Student>> ces = new ArrayList<List<Student>>();
		res.add(stu);
		res1.add(stu1);
		ces.add(res);
		ces.add(res1);
		System.out.println(ces);
	}
	
	public static void test2List(List<Integer> list) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(list.size()-1);
		list.add(4);
		res.add(list);
		System.out.println(res);
	}
	
	public static void testList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(list.size()-1);
		list.add(4);
		System.out.println(list);
	}
	
}

class Student{
	String name;
	int age;
	public Student() {
		
	}
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
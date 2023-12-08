package com.ruby.java.ch13;

interface Maximum<T extends Comparable<T>> {
	T max(); //T max() method ==> compareTo() method overriding
}

class NumUtil<T extends Comparable<T>> implements Maximum<T> {
	T[] value;

	NumUtil(T[] value) {
		this.value = value;
	}

	public T max() {
		T v = value[0];

		for (int i = 0; i < value.length; i++) {
			if (value[i].compareTo(v) > 0)
				v = value[i];
		}
		return v;
	}
}

public class GenInterfaceTest {
	public static void main(String[] args) {
		Integer[] inum = { 1, 2, 3, 4, 5 };
		Double[] dnum = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		String[] snum = { "1", "2", "3", "4", "5" };

		NumUtil<Integer> iutil = new NumUtil<>(inum);
		NumUtil<Double> dutil = new NumUtil<>(dnum);
		NumUtil<String> sutil = new NumUtil<>(snum);

		System.out.println("inum 최댓값 : " + iutil.max());
		System.out.println("dnum 최댓값 : " + dutil.max());
		System.out.println("snum 최댓값 : " + sutil.max());
	}
}

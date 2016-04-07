package ua.goit.roman;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

	private static class Category implements Comparable<Category> {
		private String name;

		private Category(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(Category o) {
			return name.compareTo(o.name);
		}

		@Override
		public String toString() {
			return "Category {" + name + "}";
		}
	}
	
	public static void main(String[] args) {
		Map<Category, String> map = new TreeMap<>(new Comparator<Category>() {

			@Override
			public int compare(Category o1, Category o2) {
				return 0;// -o1.name.compareTo(o2.name);
			}
		});
		map.put(new Category("Vasya"), "Pyatochkin");
		map.put(new Category("Oleg"), "Marchuk");

		System.out.println(map);

	}

}

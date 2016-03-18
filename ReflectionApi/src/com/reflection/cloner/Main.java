package com.reflection.cloner;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Table table = init();
		System.out.println("Prototype object:\t" + table);

		Table cloneTable = (Table) PrototypeCloner.clone(table);
		System.out.println("Clone object:\t\t" + cloneTable);
	}

	private static Table init() {
		Table table = new Table();
		table.setHeight(2.2);
		table.setWidth(3.4);
		table.setLegsNumber(new int[] {4,5,6,7,8});
		table.setMark('w');
		table.setPrice(100);
		table.setTest(9.9);
		table.str = "some text";
		table.naming = new ArrayList<String>();
		table.naming.add("one");
		table.naming.add("two");
		Chair chair = new Chair();
		chair.model = "0001";
		chair.mark = 'a';
		chair.price = 139;
		chair.setMaxWeight(150);
		table.chair = chair;
		return table;
	}
}

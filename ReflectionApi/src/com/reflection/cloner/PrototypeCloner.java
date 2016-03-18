package com.reflection.cloner;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class PrototypeCloner {

	public static Object clone(Object prototype) {
		Object clone = null;
		try {
			clone = prototype.getClass().newInstance();
			for (Class<?> obj = prototype.getClass(); !obj.equals(Object.class); obj = obj
					.getSuperclass()) {
				for (Field field : obj.getDeclaredFields()) {
					int modifiers = field.getModifiers();
					if (!Modifier.isFinal(modifiers)
							&& !Modifier.isStatic(modifiers)) {
						field.setAccessible(true);
						field.set(clone, field.get(prototype));
					}
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return clone;
	}
}

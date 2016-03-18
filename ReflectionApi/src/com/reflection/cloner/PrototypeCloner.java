package com.reflection.cloner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class PrototypeCloner {

	public static Object clone(Object prototype) {
		Object clone = null;
		try {
			Constructor<?> ctor = null;
			for (Constructor<?> constr : prototype.getClass().getDeclaredConstructors()) {
			    ctor = constr;
			    if (ctor.getGenericParameterTypes().length == 0)
				break;
			}
			ctor.setAccessible(true);
			clone = ctor.newInstance();
			
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clone;
	}
}

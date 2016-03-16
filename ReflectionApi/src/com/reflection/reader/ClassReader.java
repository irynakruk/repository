package com.reflection.reader;

import static java.lang.System.out;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassReader {

	public static void readClass(String className){
		try {
			Class<?> parsedClass = Class.forName(className);
			out.println(Modifier.toString(parsedClass.getModifiers()) + " class " + parsedClass.getName() + " {");
						
			for(Constructor<?> constr : parsedClass.getDeclaredConstructors()){
				out.println("\t" + constr.toGenericString());
			}
			out.println();
			for(Field field : parsedClass.getDeclaredFields()){
				out.println("\t" + field.toGenericString());
			}
			out.println();
			for(Method method : parsedClass.getDeclaredMethods()){
				out.println("\t" + method.toGenericString());
			}
			out.println();
			for(Class<?> intrface : parsedClass.getInterfaces()){
				out.println("\t" + intrface.toGenericString());
			}
			out.println("}");
			
		} catch (ClassNotFoundException e) {
			out.println("Class not found.");
		}
	}
}

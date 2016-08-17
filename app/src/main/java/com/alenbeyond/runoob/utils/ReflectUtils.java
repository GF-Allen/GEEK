package com.alenbeyond.runoob.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectUtils {
    private static Class<?> mType;
    private static Object   mValue;

    public static Object invoke(Object owner, String targetClass, String methodName,
            Class<?>[] parameterTypes, Object[] parameters) throws SecurityException,
            NoSuchMethodException, IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
        Class<?> ownerclass = getTargetclass(owner, targetClass);
        Method method = ownerclass.getDeclaredMethod(methodName, parameterTypes);
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        Object result = method.invoke(owner, parameters);
        return result;
    }

    public static void listObject(Object owner, String targetClass) {
        Class<?> ownerclass = getTargetclass(owner, targetClass);
        System.err.println(ownerclass + " field:");
        for (Field field : ownerclass.getDeclaredFields()) {
            System.err.println(field.getName());
        }
        System.err.println(ownerclass + " method:");
        for (Method method : ownerclass.getDeclaredMethods()) {
            System.err.println(method.getName());
        }
    }

    public static Object invoke(Object object, String function, String parameter)
            throws SecurityException, IllegalArgumentException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        System.out.println(function + "(" + (null == parameter ? "" : parameter) + ")");
        Class<?>[] types = null;
        Object[] values = null;

        // get parameter
        if (null == parameter) {
            types = new Class[] {};
            values = new Object[] {};
        } else {
            String[] parameters = parameter.split(",");
            types = new Class[parameters.length];
            values = new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                mType = null;
                mValue = null;
                getParameters(parameters[i]);
                types[i] = mType;
                values[i] = mValue;
            }
        }

        return invoke(object, null, function, types, values);
    }

    private static void getParameters(String parameterString) {
        String type = parameterString.substring(0, parameterString.indexOf(":"));
        String value = parameterString.substring(parameterString.indexOf(":") + 1,
                parameterString.length());

        if ("String".equalsIgnoreCase(type)) {
            mType = String.class;
            mValue = String.valueOf(value);
        } else if ("int".equalsIgnoreCase(type)) {
            mType = int.class;
            mValue = Integer.valueOf(value).intValue();
        } else if ("boolean".equalsIgnoreCase(type)) {
            mType = boolean.class;
            mValue = Boolean.valueOf(value).booleanValue();
        } else if ("float".equalsIgnoreCase(type)) {
            mType = float.class;
            mValue = Float.valueOf(value).floatValue();
        } else if ("double".equalsIgnoreCase(type)) {
            mType = double.class;
            mValue = Double.valueOf(value).doubleValue();
        } else if ("long".equalsIgnoreCase(type)) {
            mType = long.class;
            mValue = Long.valueOf(value).longValue();
        }
    }

    public static void setField(Object owner, String targetClass, String fieldName, Object value)
            throws SecurityException, NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Class<?> ownerclass = getTargetclass(owner, targetClass);
        Field field = ownerclass.getDeclaredField(fieldName);
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        field.set(owner, value);
    }

    public static Object getField(Object owner, String targetClass, String fieldName)
            throws SecurityException, NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Class<?> ownerclass = getTargetclass(owner, targetClass);
        Field field = ownerclass.getDeclaredField(fieldName);
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        Object property = field.get(owner);
        return property;
    }

    private static Class<?> getTargetclass(Object owner, String targetClass) {
        try {
            return null == targetClass ? owner.getClass() : Class.forName(targetClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String> getFieldNameByType(Object owner, String targetClass,
            Class<?> type) {
        ArrayList<String> names = new ArrayList<String>();
        Class<?> ownerclass = getTargetclass(owner, targetClass);
        for (Field field : ownerclass.getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            if (getClassName(field.getType()).equals(getClassName(type))) {
                names.add(field.getName());
            }
        }

        return names;
    }

    private static String getClassName(Class<?> type) {
        String fieldString = type.toString();
        if (fieldString.startsWith("class ")) {
            fieldString = fieldString.substring("class ".length());
        }
        return fieldString;
    }

    public static ArrayList<String> getFieldNameByValue(Object owner, String targetClass,
            Class<?> valueType, Object value) throws IllegalArgumentException,
            IllegalAccessException {
        ArrayList<String> names = new ArrayList<String>();
        Class<?> ownerclass = getTargetclass(owner, targetClass);
        for (Field field : ownerclass.getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            if (getClassName(field.getType()).equals(getClassName(valueType))
                    && field.get(owner).equals(value)) {
                names.add(field.getName());
            }
        }
        return names;
    }

    public static ArrayList<Class<?>> getInterfaces(Object owner, String[] interfaceStrings) {
        ArrayList<Class<?>> targetInterfaces = new ArrayList<Class<?>>();
        Class<?>[] interfaceClasses = owner.getClass().getInterfaces();
        for (Class<?> interfaceClass : interfaceClasses) {
            for (String interfaceName : interfaceStrings) {
                if (interfaceClass.getName().contains(interfaceName)) {
                    targetInterfaces.add(interfaceClass);
                }
            }
        }
        return targetInterfaces;
    }

}

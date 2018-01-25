/**
 * Weidai
 * Copyright (C), 2011 - 2018, 微贷网.
 */
package com.reus.tinyioc.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author reus
 * @version $Id: ClassUtil.java, v 0.1 2018-01-25 reus Exp $
 */
public class ClassUtil {

    /**
     * 获取指定包名下的所有类
     * @param packageName
     * @param isRecursive
     * @return
     */
    public static List<Class<?>> getClassList(String packageName, boolean isRecursive) {
        List<Class<?>> classList = new ArrayList<>();
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader()
                .getResources(packageName.replaceAll("\\.", "/"));
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    String protocol = url.getProtocol();
                    if (protocol.equals("file")) {
                        String packagePath = url.getPath();
                        addClass(classList, packagePath, packageName, isRecursive);
                    } else if (protocol.equals("jar")) {
                        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                        JarFile jarFile = jarURLConnection.getJarFile();
                        Enumeration<JarEntry> jarEntries = jarFile.entries();
                        while (jarEntries.hasMoreElements()) {
                            JarEntry jarEntry = jarEntries.nextElement();
                            String jarEntryName = jarEntry.getName();
                            if (jarEntryName.endsWith(".class")) {
                                String className = jarEntryName
                                    .substring(0, jarEntryName.lastIndexOf("."))
                                    .replaceAll("/", ".");
                                if (isRecursive || className
                                    .substring(0, className.lastIndexOf(".")).equals(packageName)) {
                                    classList.add(Class.forName(className));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classList;
    }

    /**
     * 获取指定包名下指定注解的所有类
     * @param packageName
     * @param annotationClass
     * @return
     */
    public static List<Class<?>> getClassListByAnnotation(String packageName,
                                                          Class<? extends Annotation> annotationClass) {
        List<Class<?>> classList = new ArrayList<>();
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader()
                .getResources(packageName.replaceAll("\\.", "/"));
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    String protocol = url.getProtocol();
                    if (protocol.equals("file")) {
                        String packagePath = url.getPath();
                        addClassByAnnotation(classList, packagePath, packageName, annotationClass);
                    } else if (protocol.equals("jar")) {
                        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                        JarFile jarFile = jarURLConnection.getJarFile();
                        Enumeration<JarEntry> jarEntries = jarFile.entries();
                        while (jarEntries.hasMoreElements()) {
                            JarEntry jarEntry = jarEntries.nextElement();
                            String jarEntryName = jarEntry.getName();
                            if (jarEntryName.endsWith(".class")) {
                                String className = jarEntryName
                                    .substring(0, jarEntryName.lastIndexOf("."))
                                    .replaceAll("/", ".");
                                Class<?> cls = Class.forName(className);
                                if (cls.isAnnotationPresent(annotationClass)) {
                                    classList.add(cls);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classList;
    }

    /**
     * 获取指定包名下指定父类的所有类
     * @param packageName
     * @param superClass
     * @return
     */
    public static List<Class<?>> getClassListBySuper(String packageName, Class<?> superClass) {
        List<Class<?>> classList = new ArrayList<>();
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader()
                .getResources(packageName.replaceAll("\\.", "/"));
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    String protocol = url.getProtocol();
                    if (protocol.equals("file")) {
                        String packagePath = url.getPath();
                        addClassBySuper(classList, packagePath, packageName, superClass);
                    } else if (protocol.equals("jar")) {
                        getJarFiles(url, superClass, classList);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classList;
    }

    /**
     * 获取指定包名下指定接口的所有实现类
     * @param packageName
     * @param interfaceClass
     * @return
     */
    public static List<Class<?>> getClassListByInterface(String packageName,
                                                         Class<?> interfaceClass) {
        List<Class<?>> classList = new ArrayList<>();
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader()
                .getResources(packageName.replaceAll("\\.", "/"));
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    String protocol = url.getProtocol();
                    if (protocol.equals("file")) {
                        String packagePath = url.getPath();
                        addClassByInterface(classList, packagePath, packageName, interfaceClass);
                    } else if (protocol.equals("jar")) {
                        getJarFiles(url, interfaceClass, classList);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classList;
    }

    /**
     * 获取jar压缩包中的class文件
     * @param url
     * @param interfaceClass
     * @param classList
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void getJarFiles(URL url, Class<?> interfaceClass,
                                    List<Class<?>> classList) throws IOException,
                                                              ClassNotFoundException {
        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
        JarFile jarFile = jarURLConnection.getJarFile();
        Enumeration<JarEntry> jarEntries = jarFile.entries();
        while (jarEntries.hasMoreElements()) {
            JarEntry jarEntry = jarEntries.nextElement();
            String jarEntryName = jarEntry.getName();
            if (jarEntryName.endsWith(".class")) {
                String className = jarEntryName.substring(0, jarEntryName.lastIndexOf("."))
                    .replaceAll("/", ".");
                Class<?> cls = Class.forName(className);
                if (interfaceClass.isAssignableFrom(cls) && !interfaceClass.equals(cls)) {
                    classList.add(cls);
                }
            }
        }
    }

    /**
     * 扫描路径下的所有文件，并添加到指定列表中
     * @param classList
     * @param packagePath
     * @param packageName
     * @param isRecursive
     */
    private static void addClass(List<Class<?>> classList, String packagePath, String packageName,
                                 boolean isRecursive) {
        try {
            File[] files = getClassFiles(packagePath);
            if (files != null) {
                for (File file : files) {
                    String fileName = file.getName();
                    if (file.isFile()) {
                        String className = getClassName(packageName, fileName);
                        classList.add(Class.forName(className));
                    } else {
                        if (isRecursive) {
                            String subPackagePath = getSubPackagePath(packagePath, fileName);
                            String subPackageName = getSubPackageName(packageName, fileName);
                            addClass(classList, subPackagePath, subPackageName, isRecursive);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取路径下的所有class文件
     * @param packagePath
     * @return
     */
    private static File[] getClassFiles(String packagePath) {
        return new File(packagePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });
    }

    /**
     * 获取类名
     * @param packageName
     * @param fileName
     * @return
     */
    private static String getClassName(String packageName, String fileName) {
        String className = fileName.substring(0, fileName.lastIndexOf("."));
        if (!packageName.isEmpty()) {
            className = packageName + "." + className;
        }
        return className;
    }

    /**
     * 获取子包路径
     * @param packagePath
     * @param filePath
     * @return
     */
    private static String getSubPackagePath(String packagePath, String filePath) {
        String subPackagePath = filePath;
        if (packagePath.isEmpty()) {
            subPackagePath = packagePath + "/" + subPackagePath;
        }
        return subPackagePath;
    }

    /**
     * 获取子包名
     * @param packageName
     * @param filePath
     * @return
     */
    private static String getSubPackageName(String packageName, String filePath) {
        String subPackageName = filePath;
        if (packageName.isEmpty()) {
            subPackageName = packageName + "." + subPackageName;
        }
        return subPackageName;
    }

    /**
     * 添加注解类名到指定列表中
     * @param classList
     * @param packagePath
     * @param packageName
     * @param annotationClass
     */
    private static void addClassByAnnotation(List<Class<?>> classList, String packagePath,
                                             String packageName,
                                             Class<? extends Annotation> annotationClass) {
        try {
            File[] files = getClassFiles(packagePath);
            if (files != null) {
                for (File file : files) {
                    String fileName = file.getName();
                    if (file.isFile()) {
                        String className = getClassName(packageName, fileName);
                        Class<?> cls = Class.forName(className);
                        if (cls.isAnnotationPresent(annotationClass)) {
                            classList.add(cls);
                        }
                    } else {
                        String subPackagePath = getSubPackagePath(packagePath, fileName);
                        String subPackageName = getSubPackageName(packageName, fileName);
                        addClassByAnnotation(classList, subPackagePath, subPackageName,
                            annotationClass);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  添加由给定类派生出的所有类
     * @param classList
     * @param packagePath
     * @param packageName
     * @param superClass
     */
    private static void addClassBySuper(List<Class<?>> classList, String packagePath,
                                        String packageName, Class<?> superClass) {
        try {
            File[] files = getClassFiles(packagePath);
            if (files != null) {
                for (File file : files) {
                    String fileName = file.getName();
                    if (file.isFile()) {
                        String className = getClassName(packageName, fileName);
                        Class<?> cls = Class.forName(className);
                        if (superClass.isAssignableFrom(cls) && !superClass.equals(cls)) {
                            classList.add(cls);
                        }
                    } else {
                        String subPackagePath = getSubPackagePath(packagePath, fileName);
                        String subPackageName = getSubPackageName(packageName, fileName);
                        addClassBySuper(classList, subPackagePath, subPackageName, superClass);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加所有接口继承类到指定列表中
     * @param classList
     * @param packagePath
     * @param packageName
     * @param interfaceClass
     */
    private static void addClassByInterface(List<Class<?>> classList, String packagePath,
                                            String packageName, Class<?> interfaceClass) {
        try {
            File[] files = getClassFiles(packagePath);
            if (files != null) {
                for (File file : files) {
                    String fileName = file.getName();
                    if (file.isFile()) {
                        String className = getClassName(packageName, fileName);
                        Class<?> cls = Class.forName(className);
                        if (interfaceClass.isAssignableFrom(cls) && !interfaceClass.equals(cls)) {
                            classList.add(cls);
                        }
                    } else {
                        String subPackagePath = getSubPackagePath(packagePath, fileName);
                        String subPackageName = getSubPackageName(packageName, fileName);
                        addClassByInterface(classList, subPackagePath, subPackageName,
                            interfaceClass);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
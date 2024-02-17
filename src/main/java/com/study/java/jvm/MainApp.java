package com.study.java.jvm;

/**
*  jvm % pwd
 * /Users/.../Workspace/java-study/src/main/java/com/study/java/jvm
 *
 *  jvm % ls
 * MainApp.java
 *
 *  jvm % javac MainApp.java        // javac command : 텍스트 파일로 작성된 java 파일을 bytecode로 컴파일한다. (return .class)
 *
 *  jvm % ls
 * MainApp.class   MainApp.java     // file list 를 확인해보면 MainApp.class file 생성 확인.
 *
 *  jvm % javap -c MainApp
 * Warning: File ./MainApp.class does not contain class MainApp
 * Compiled from "MainApp.java"
 * public class com.study.java.jvm.MainApp {
 *   public com.study.java.jvm.MainApp();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: ldc           #13                 // String JVM study start
 *        5: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        8: return
 * }
 *
 *  jvm % java MainApp.java 
 * JVM study start
 *
* */
public class MainApp {
    public static void main(String[] args) {
        System.out.println("JVM study start");
    }

}

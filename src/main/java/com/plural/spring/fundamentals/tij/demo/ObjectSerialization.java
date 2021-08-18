package com.plural.spring.fundamentals.tij.demo;

import com.plural.spring.fundamentals.tij.models.AppClass;
import com.plural.spring.fundamentals.tij.models.Student;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ObjectSerialization {

    private static final String hostname = "localhost";
    private static final int port = 3456;

    public static void main(String[] args) {
        String arg = args[0];
        if (arg.equalsIgnoreCase("server")) {
            runServer();
        } else runClient();
    }

    private static void serializeObjects() {
        try (FileOutputStream fo = new FileOutputStream("objects.out");
             ObjectOutputStream oo = new ObjectOutputStream(fo)) {
            List<Student> studentList = Arrays.asList(
                    new Student("Luis_Muriel", "admin@123"),
                    new Student("Sergio Ramos", "king@madrid"),
                    new Student("Thiago Silva", "big_man")
            );
            AppClass appClass = new AppClass("XI", "A");
            appClass.setStudentList(studentList);
            oo.writeObject(appClass);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try (FileInputStream fi = new FileInputStream("objects.out");
             ObjectInputStream oi = new ObjectInputStream(fi)) {
            Object appClass = oi.readObject();
            System.out.println(appClass.getClass());
            AppClass parentClass = (AppClass) appClass;
            System.out.println(parentClass);
            for (Student student : parentClass.getStudentList()) {
                System.out.println(student);
            }
        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
    }

    private static void runClient() {
        AppCommClient commClient = new AppCommClient();
        commClient.connectAndTalk(hostname, port);
    }

    private static void runServer() {
        AppCommServer server = new AppCommServer();
        server.listenAndTalk(port);
    }
}

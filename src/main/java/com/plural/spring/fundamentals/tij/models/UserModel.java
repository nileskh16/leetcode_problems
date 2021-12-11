package com.plural.spring.fundamentals.tij.models;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class UserModel implements Externalizable {

    private static final long serialVersionUID = 1024655095299611233L;

    private String username;
    private String password;
    private String email;
    private String address;

    public UserModel() {
        super();
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("User Details: Name -> %s, Password -> %s, Email -> %s, Address -> %s", username, password, email, address);
    }

    @Override
    public void readExternal(ObjectInput input) throws IOException {
        this.username = input.readUTF();
        this.email = input.readUTF();
        this.address = input.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput output) throws IOException {
        output.writeUTF(username);
        output.writeUTF(email);
        output.writeUTF(address);
    }
    
    public static class A {
        int x = 40;

        A() {
            System.out.println("Constructor A");
        }

        public void show() {
            System.out.println("In class A");
        }
    }

    public static class B extends A {
        int x = 60;

        @Override
        public void show() {
            System.out.println("In class B");
        }
    }

    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.x);
        a.show();
    }

    public static void test1() {
        String a = "pqr";
        test2(a);
        System.out.println(a);
    }

    public static void test2(String a) {
        a = "abc";
    }

    public static class AB {
        static {
            System.out.println("SIB");
        }

        {
            System.out.println("IIB");
        }

        AB() {
            System.out.println("Constructor");
        }
    }
}

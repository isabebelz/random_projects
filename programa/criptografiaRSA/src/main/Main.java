package main;

import crypto.RSAEncryptor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RSAEncryptor encryptor = new RSAEncryptor();


        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String textEncrypted = encryptor.encrypt(text);

        System.out.println(textEncrypted);

        System.out.println(encryptor.decrypt(textEncrypted));



    }
}
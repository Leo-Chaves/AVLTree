package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Tree avl = new Tree();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);

        System.out.println();
        System.out.println(avl.getRoot().getInfo());
        System.out.println();
        System.out.println(avl.getRoot().getLeft().getInfo());
        System.out.println();
        System.out.println(avl.getRoot().getLeft().getLeft().getInfo());

    }
}
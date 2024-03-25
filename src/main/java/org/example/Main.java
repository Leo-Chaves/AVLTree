package org.example;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>();

        tree.insert(10);

        System.out.println(tree.getRoot().getInfo());
        System.out.println();

        tree.insert(15);
        tree.insert(20);
        tree.insert(5);

        System.out.println(tree.getRoot().getInfo());
        System.out.println();


        tree.deletar(15);

        System.out.println(tree.getRoot().getInfo());
        System.out.println();

        tree.deletar(20);
        tree.insert(3);
        System.out.println(tree.getRoot().getInfo());
    }
}
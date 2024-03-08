package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<T extends Comparable <T>> {
    private Node<T> root;
    private boolean status;

    public Tree() {

    }

    private boolean isEmpty() {
        return root == null;
    }


    public void insert(T value) {
        if (this.isEmpty() == true) {
            this.root = new Node(value);
            this.status = true;
        } else {
            this.root = insertNode(this.root, value);
        }
    }

    private Node<T> insertNode(Node<T> r, T value) {
        if (r == null) {
            r = new Node<>(value);
        }else if (r.getInfo().compareTo(value) > 0) {
            r.setLeft(insertNode (r.getLeft(),value));
            if (this.status == true) {
                switch (r.getBalance()) {
                    case 1: r.setBalance(0);
                    this.status = false;
                    break;
                    case 0: r.setBalance(-1);
                    break;
                    case -1 : r = this.rotateRight(r);
                    break;
                }
            }
        }else{
            r.setRight(insertNode (r.getRight(),value));
            if (this.status == true) {
                switch (r.getBalance()) {
                    case -1: r.setBalance(0);
                        this.status = false;
                        break;
                    case 0: r.setBalance(-1);
                        break;
                    case 1 : r = this.rotateLeft(r);
                    break;
                }
            }
        }
        return r;
    }

    private Node<T> rotateLeft(Node<T> r) {
        Node<T> a = r.getRight();
        Node<T> b = a.getLeft();
        Node<T> c = r;

        if (a.getBalance() == -1) {
            // Caso de rotação dupla à direita
            Node<T> d = b.getRight();
            Node<T> e = b.getLeft();

            // Rotação à esquerda na subárvore Y
            b.setLeft(c);
            c.setRight(d);

            // Rotação à direita no nó X
            r.setRight(b);
            b.setLeft(a);

            // Atualização dos fatores de balanceamento
            c.setBalance(0);
            b.setBalance(0);
            a.setBalance(1);
        } else {
            // Caso de rotação simples à esquerda
            r.setRight(b);
            a.setLeft(c);

            // Atualização dos fatores de balanceamento
            c.setBalance(0);
            a.setBalance(0);
        }

        return a;
    }

    private Node<T> rotateRight(Node<T> r) {
        Node<T> a = r.getLeft();
        Node<T> b = a.getRight();
        Node<T> c = r;

        if (a.getBalance() == 1) {
            // Caso de rotação dupla à esquerda
            Node<T> d = b.getLeft();
            Node<T> e = b.getRight();

            // Rotação à direita na subárvore Y
            b.setRight(c);
            c.setLeft(d);

            // Rotação à esquerda no nó X
            r.setLeft(b);
            b.setRight(a);

            // Atualização dos fatores de balanceamento
            c.setBalance(0);
            b.setBalance(0);
            a.setBalance(-1);
        } else {
            // Caso de rotação simples à direita
            r.setLeft(b);
            a.setRight(c);

            // Atualização dos fatores de balanceamento
            c.setBalance(0);
            a.setBalance(0);
        }

        return a;
    }


    public Node<T> getRoot() {
        return root;
    }
}

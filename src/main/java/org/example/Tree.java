package org.example;

public class Tree<T extends Comparable <T>> {
    private Node<T> root;
    private boolean status;

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
        Node<T> a;
        Node<T> b;
        Node<T> c;

        return r;
    }

    private Node<T> rotateRight(Node<T> r) {
        Node<T> a;
        Node<T> b;
        Node<T> c;

        return r;
    }
}

package org.example;

public class Tree <T extends Comparable <T>> {
    private Node<T> root;
    private boolean status;

    public Tree() {

    }

    public Node<T> getRoot() {
        return root;
    }

    private boolean isEmpty() {
        return root == null;
    }


    public void insert(T value) {
        if (this.isEmpty() == true) {
            this.root = new Node<T>(value);
            this.status = true;
        } else {
            this.root = insertNode(this.root, value);
        }
    }

    private Node<T> insertNode(Node<T> r, T value) {
        if (r == null) {
            r = new Node<T>(value);
            this.status= true;
        }else if (r.getInfo().compareTo(value) > 0) {
            r.setLeft(insertNode(r.getLeft(),value));
            if (this.status == true) {
                switch (r.getBalance()) {
                    case 1: 
                        r.setBalance(0);
                        this.status = false;
                        break;
                    case 0: 
                        r.setBalance(-1);
                        break;
                    case -1 : 
                        r = this.rotateRight(r);
                        break;
                }
            }
        }else{
            r.setRight(insertNode(r.getRight(),value));
            if (this.status == true) {
                switch (r.getBalance()) {
                    case -1: 
                        r.setBalance(0);
                        this.status = false;
                        break;
                    case 0: 
                        r.setBalance(1);
                        break;
                    case 1 :
                         r = this.rotateLeft(r);
                        break;
                }
            }
        }
        return r;
    }

    private Node<T> rotateLeft(Node<T> a) {
        Node<T> b, c;
        b = a.getRight();
        if (b.getBalance() == 1) {  // rot. simples direita
            a.setRight(b.getLeft());
            b.setLeft(a);
            a.setBalance(0);
            a = b;
        }else {  // rotação dupla
                c = b.getLeft();
                b.setLeft(c.getRight());
                c.setRight(b);
                a.setRight(c.getLeft());
                c.setLeft(a);
                if (c.getBalance() == 1) {
                    a.setBalance(-1);
                } else {
                    a.setBalance(0);
                }if (c.getBalance() == -1) {
                    b.setBalance(1);
                } else {
                    b.setBalance(0);
                }
                a = c;
            }
            a.setBalance(0);
            this.status = false;
            return a;}

    private Node<T> rotateRight(Node<T> a) {
        Node<T> b, c;
        b = a.getLeft();
        if (b.getBalance() == -1) {  // rot. simples esquerda
            a.setLeft(b.getRight());
            b.setRight(a);
            a.setBalance(0);
            a = b;
        }else {   // rotação dupla
            c = b.getRight();
            b.setRight(c.getLeft());
            c.setLeft(b);
            a.setLeft(c.getRight());
            c.setRight(a);
            if (c.getBalance() == -1) {
                a.setBalance(1);
            } else {
                a.setBalance(0);
            }
            if (c.getBalance() == 1) {
                b.setBalance(-1);
            } else {
                b.setBalance(0);
            }
            a = c;
        }
        a.setBalance(0);
        ;this.status = false;
        return a;

    }

    public void deletar(T value) {
        this.root = remover(this.root, value);
    }

    public Node<T>  remover(Node<T>  node, T key) {
        Node<T> pai = node;

        if (node == null) {
            return node;
        } else if (key.compareTo(node.getInfo()) < 0) {
            pai=node.getLeft();
            node.setLeft(remover(node.getLeft(), key));
        } else if (key.compareTo(node.getInfo()) > 0) {
            pai=node.getRight();
            node.setRight(remover(node.getRight(), key));
        } else {
    
            if (node.getLeft() == null) {
                if(this.status = true){
                switch (pai.getBalance()) {
                    case 1:
                     pai.setBalance(0);
                        break;
                    case 0:
                     
                    break;
                    case -1:
                        
                        break;
                
                    default:
                        break;
                }
            }
                return node.getRight();

            } else if (node.getRight() == null) {
                return node.getLeft();

            }          

            Node<T> mostLeftChild = encontrarMenorMaiorValor(node.getLeft());
            Node<T> novoNode = new Node<T>(mostLeftChild.getInfo());
            novoNode.setRight(node.getRight());
            novoNode.setLeft(remover(node.getLeft(), mostLeftChild.getInfo()));
            return novoNode;
        }
    
        return node;
    }


    private Node<T> encontrarMenorMaiorValor(Node<T>  node) {
        Node<T>  atual = node;
    
        while (atual.getRight() != null) {
            atual = atual.getRight();
        }
    
        return atual;
    }
     
}


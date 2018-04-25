package bst.dictionary;

import static java.nio.file.Files.list;
import static java.rmi.Naming.list;

import java.util.Scanner;
import java.util.ArrayList;

import static java.util.Collections.list;

/**
 * @author ModernCombat
 */
     /* Class BSTNode */

class BSTNode {
    BSTNode left, right;
    words data;
//         public ArrayList<words> listi = new ArrayList();

    /* Constructor */
    public BSTNode() {

        left = null;
        right = null;
        data = null;

//             System.out.println(listi.size());
    }

    public BSTNode(words n) {
        left = null;
        right = null;
        data = n;
//             listi.add(data);
//             System.out.println(listi.size());
    }
         
         
         

         /* Function to set left node */

    public void setLeft(BSTNode n) {
        left = n;
    }

         /* Function to set right node */

    public void setRight(BSTNode n) {
        right = n;
    }

         /* Function to get left node */

    public BSTNode getLeft() {
        return left;
    }

         /* Function to get right node */

    public BSTNode getRight() {
        return right;
    }

         /* Function to set data to node */

    public void setData(words d) {
        data = d;
    }

         /* Function to get data from node */

    public words getData() {
        return data;
    }
}

     /* Class BST */

class BST {
    private BSTNode root;
     
         /* Constructor */

    public BST() {
        root = null;
    }

         /* Function to check if tree is empty */

    public boolean isEmpty() {
        return root == null;
    }

         /* Functions to insert data */

    public void insert(words data) {
        root = insert(root, data);
    }

         /* Function to insert data recursively */

    private BSTNode insert(BSTNode node, words data) {
        if (node == null) {
            node = new BSTNode(data);
        } else {
            if (data.geten().compareTo(node.getData().geten()) > 0)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;

    }

         /* Functions to delete data */

    public void delete(words k) {
        if (isEmpty())
            System.out.println("Tree Empty");

        else {
            words found = search(k);
            if (found == null)
                System.out.println("Sorry " + k.toString() + " is not present");
            else {
                root = delete(root, k);
                System.out.println(k.toString() + " deleted from the tree");
            }
        }
    }

    private BSTNode delete(BSTNode root, words k)

    {
        BSTNode p, p2, n;
        if (root.getData().compareTo(k)==0)
        {
            BSTNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null) {
                p = rt;
                return p;
            } else if (rt == null) {
                p = lt;
                return p;
            } else {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k.compareTo(root.getData()) > 0) {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        } else {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }

         /* Functions to search for an element */

    public words search(words val) {
        return search(root, val);
    }

         /* Function to search for an element recursively */

    private words search(BSTNode r, words val) {
        words found = null;
        while ((r != null) && found == null) {
            words rval = r.getData();
            if (val.geten().compareTo(rval.geten()) < 0)
                r = r.getRight();
            else if (val.geten().compareTo(rval.geten()) > 0)
                r = r.getLeft();
            else {
                found = rval;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

         /* Function for inorder traversal */

    public void inorder() {
        inorder(root);
    }

    private void inorder(BSTNode r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData().geten() + "  ");
            inorder(r.getRight());
        }
    }

         /* Function for preorder traversal */

    public void preorder() {
        preorder(root);
    }

    private void preorder(BSTNode r) {
        if (r != null) {
            System.out.print(r.getData().geten() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

         /* Function for postorder traversal */

    public void postorder() {
        postorder(root);
    }

    private void postorder(BSTNode r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData().geten() + " ");
        }
    }
}

     

     /* Class BSTDictionary */

public class BSTDictionary {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            /* Creating object of BST */

        BST bst = new BST();
            /*  Perform tree operations  */

        do {
            System.out.println("\nWhat you want to do?\n");
            System.out.println("1. Insert ");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Show Post order ");
            System.out.println("5. Show Pre order");
            System.out.println("6. Show In order");
            String choice = scan.next();
            switch (choice) {
                case "1": {
                    System.out.println("Enter word to insert : ");
                    String input = scan.next();
                    System.out.println("Enter translate : ");
                    String fainput = scan.next();
                    bst.insert(new words(input, fainput));
                    System.out.println();
                    break;
                }
                case "2": {
                    System.out.println("Enter word to search");
                    String input = scan.next();
                    System.out.println("Enter translate : ");
                    String fainput = scan.next();
                    words result = bst.search(new words(input, fainput));
                    if (result==null) System.out.println("Search result : notFound" );
                    else
                    System.out.println("Search result : " + result);
                    break;
                }
                case "3": {
                    System.out.println("Enter word to delete");
                    String input = scan.next();
                    System.out.println("Enter translate");
                    String fainput = scan.next();
                    bst.delete(new words(input, fainput));
                    break;
                }
                case "4":
                    System.out.print("\nPost order : ");
                    bst.postorder();
                    break;
                case "5":
                    System.out.print("\nPre order : ");
                    bst.preorder();
                    break;
                case "6":
                    System.out.print("\nIn order : ");
                    bst.inorder();
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }

        } while (true);
    }
}
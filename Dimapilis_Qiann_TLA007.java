package com.mycompany.dimapilis_qiann_tla007;

import java.util.*;

public class Dimapilis_Qiann_TLA007 {
    // This class holds the student information
    static class Student {
        String name;
        int allowance;

        public Student(String name, int allowance) {
            this.name = name;
            this.allowance = allowance;
        }
    }

    // This node represents each entry in the Binary Search Tree
    static class TreeNode {
        Student student;
        TreeNode left, right;

        public TreeNode(Student student) {
            this.student = student;
            this.left = null;
            this.right = null;
        }
    }

    // Binary Search Tree class for managing students based on their allowances
    static class BinaryTree {
        private TreeNode root;

        // Insert a new student into the BST
        public void insert(Student student) {
            root = insertRecursively(root, student);
        }

        // Helper method for insertion
        private TreeNode insertRecursively(TreeNode current, Student student) {
            if (current == null) {
                return new TreeNode(student);
            }
            if (student.allowance < current.student.allowance) {
                current.left = insertRecursively(current.left, student);
            } else {
                current.right = insertRecursively(current.right, student);
            }
            return current;
        }

        // Print the students sorted by allowance from highest to lowest
        public void printFromHighestToLowest() {
            if (root == null) {
                System.out.println("No student allowances to display.");
            } else {
                System.out.println("\nStudents and their allowances (Highest to Lowest):");
                reverseInOrderTraversal(root);
                System.out.println();
            }
        }

        // Helper method for reverse in-order traversal (right-root-left)
        private void reverseInOrderTraversal(TreeNode node) {
            if (node != null) {
                reverseInOrderTraversal(node.right);
                System.out.println("- " + node.student.name + ": ₱" + node.student.allowance);
                reverseInOrderTraversal(node.left);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bst = new BinaryTree();

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add student allowance");
            System.out.println("2. Remove allowance (not available right now)");
            System.out.println("3. Show all student allowances (highest to lowest)");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the allowance amount: ₱");
                    int allowance = scanner.nextInt();
                    scanner.nextLine();

                    bst.insert(new Student(name, allowance));
                    System.out.println("Allowance successfully added for " + name + ".");
                    break;

                case 2:
                    System.out.println("Oops! The remove allowance feature is not available yet.");
                    break;

                case 3:
                    bst.printFromHighestToLowest();
                    break;

                case 4:
                    System.out.println("Thanks for using the allowance manager. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("That’s not a valid choice. Please try again.");
                    break;
            }
        }
    }
}

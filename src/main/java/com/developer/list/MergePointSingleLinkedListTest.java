package com.developer.list;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergePointSingleLinkedListTest {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.setProperty("OUTPUT_PATH","F:\\projects\\new\\datastructures-algorithms\\src\\test\\java\\com\\developer\\test.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            int index = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            SingleLinkedList<Integer> llist1=new SingleLinkedList<>();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.addLast(llist1Item);
            }

            SingleLinkedList<Integer> llist2 = new  SingleLinkedList<>();

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.addLast(llist2Item);
            }

            SingleLinkedList.Node<Integer> ptr1 = llist1.getHead();
            SingleLinkedList.Node<Integer>  ptr2 = llist2.getHead();

            for (int i = 0; i < llist1Count; i++) {
                if (i < index) {
                    ptr1 = ptr1.getNext();
                }
            }

            for (int i = 0; i < llist2Count; i++) {
                if (i != llist2Count-1) {
                    ptr2 = ptr2.getNext();
                }
            }

            ptr2.setNext(ptr1);
            int result = new SingleLinkedList<Integer>().findMergeNode(llist1.getHead(), llist2.getHead());

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

package com.pepal.hashmapHeap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class HashMapNode<K, V> {
    K key;
    V value;

    HashMapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class PEP0491_ImplementHashMap {
    static LinkedList<HashMapNode<String, Integer>>[] hashMap;

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 2;

    static final double INCREASE_LOAD_FACTOR = 2;

    static final double DECREASE_LOAD_FACTOR = 0.75;

    static int totalElements;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        hashMap = new LinkedList[DEFAULT_INITIAL_CAPACITY];
        for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
            hashMap[i] = new LinkedList<HashMapNode<String, Integer>>();
        }

        while (true) {
            System.out.print("press 0:exit  1:get  2:put  3:remove  4:size  5:keySet  6:display  -> ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("enter key: ");
                    String str = input.nextLine();
                    int value = getValueFromHashMap(str);
                    if(value == -1) {
                        System.out.println("key is empty");
                    }else{
                        System.out.println(str+" value is : " + value);
                    }
                    break;
                case 2:
                    System.out.print("enter key: ");
                    String str1 = input.nextLine();
                    System.out.print("enter value: ");
                    int value1 = Integer.parseInt(input.nextLine());
                    addElementHM(str1, value1);
                    break;
                case 3:
                    System.out.print("enter key: ");
                    removeElementHM(input.nextLine());
                    break;
                case 4:
                    System.out.println("Size of the hash map: "+ getSizeOfHashMap());
                    break;
                case 5:
                    System.out.print("enter key: ");
                    System.out.println("Key set is : "+ findKeySetHM(input.nextLine()));
                    break;
                case 6:
                    diplayHM();
                    break;
                default:
                    System.out.println("please enter correct choice");

            }
        }
    }

    private static void diplayHM() {
        for(int i=0; i<hashMap.length; i++){
            LinkedList<HashMapNode<String, Integer>> linkedLIST = hashMap[i];
            System.out.print("index "+(i)+" -> ");
            for(HashMapNode<String, Integer> hashMapNode : linkedLIST) {
                System.out.print(" "+hashMapNode.key+":"+hashMapNode.value+" ");
            }
            System.out.println();
        }
    }

    private static List<String> findKeySetHM(String str1) {
        int code = str1.hashCode();
        int index = code % hashMap.length;
        LinkedList<HashMapNode<String, Integer>> linkedLIST = hashMap[index];
        int present = 0;
        List<String> keySet = new LinkedList<>();
        for(HashMapNode<String, Integer> hashMapNode : linkedLIST) {
            if(hashMapNode.key.equals(str1)) {
                linkedLIST.remove(hashMapNode);
                present = 1;
            }
            keySet.add(hashMapNode.key);
        }
        if(present == 0) {
            System.out.println("Element is not present in the hashmap");
            return Collections.emptyList();
        }
        return keySet;
    }

    private static void removeElementHM(String str1) {
        int code = str1.hashCode();
        int index = code % hashMap.length;
        LinkedList<HashMapNode<String, Integer>> linkedLIST = hashMap[index];
        int present = 0;
        for(HashMapNode<String, Integer> hashMapNode : linkedLIST) {
            if(hashMapNode.key.equals(str1)) {
                linkedLIST.remove(hashMapNode);
                present = 1;
                totalElements--;
                double lambda = totalElements / (double)hashMap.length;
                if(lambda < DECREASE_LOAD_FACTOR){
                    shrinkReHashing();
                }
                System.out.println("Element is removed from the hashmap");
                break;
            }
        }
        if(present == 0) {
            System.out.println("Element is not present in the hashmap");
        }
    }

    private static void shrinkReHashing() {
        LinkedList<HashMapNode<String, Integer>>[] hashMap1 = new LinkedList[(hashMap.length)/2];
        for (int i = 0; i < hashMap1.length; i++) {
            hashMap1[i] = new LinkedList<HashMapNode<String, Integer>>();
        }
        for(int i=0; i<hashMap.length; i++){
            LinkedList<HashMapNode<String, Integer>> linkedLIST = hashMap[i];
            for(HashMapNode<String, Integer> hashMapNode : linkedLIST) {
                int code = hashMapNode.key.hashCode();
                int index = code % hashMap1.length;
                LinkedList<HashMapNode<String, Integer>> linkedListNew = hashMap1[index];
                HashMapNode<String, Integer> element = new HashMapNode<>(hashMapNode.key, hashMapNode.value);
                linkedListNew.add(element);

            }
        }

        hashMap =  hashMap1;
        hashMap1 = null;
    }

    private static void addElementHM(String str1, int value1) {
        int code = str1.hashCode();
        int index = code % hashMap.length;
        LinkedList<HashMapNode<String, Integer>> linkedLIST = hashMap[index];
        int present = 0;
        for(HashMapNode<String, Integer> hashMapNode : linkedLIST) {
            if(hashMapNode.key.equals(str1)) {
                hashMapNode.value = value1;
                present = 1;
                break;
            }
        }
        if(present == 0) {
            HashMapNode<String, Integer> element = new HashMapNode<>(str1, value1);
            linkedLIST.add(element);
            totalElements++;
            double lambda = totalElements / (double)hashMap.length;
            if(lambda > INCREASE_LOAD_FACTOR){
                growReHashing();
            }
        }
    }

    private static void growReHashing() {
        LinkedList<HashMapNode<String, Integer>>[] hashMap1 = new LinkedList[2 * (hashMap.length)];
        for (int i = 0; i < hashMap1.length; i++) {
            hashMap1[i] = new LinkedList<HashMapNode<String, Integer>>();
        }
        for(int i=0; i<hashMap.length; i++){
            LinkedList<HashMapNode<String, Integer>> linkedLIST = hashMap[i];
            for(HashMapNode<String, Integer> hashMapNode : linkedLIST) {
                int code = hashMapNode.key.hashCode();
                int index = code % hashMap1.length;
                LinkedList<HashMapNode<String, Integer>> linkedListNew = hashMap1[index];
                HashMapNode<String, Integer> element = new HashMapNode<>(hashMapNode.key, hashMapNode.value);
                linkedListNew.add(element);

            }
        }

        hashMap =  hashMap1;
        hashMap1 = null;
    }

    private static int getSizeOfHashMap() {
        return totalElements;
    }

    private static int getValueFromHashMap(String str) {
        int code = str.hashCode();
        int index = code % hashMap.length;
        LinkedList<HashMapNode<String, Integer>> linkedLIST = hashMap[index];
        for(HashMapNode<String, Integer> hashMapNode : linkedLIST) {
            if(hashMapNode.key.equals(str)) {
                return (int)hashMapNode.value;
            }
        }
        return -1;
    }

}

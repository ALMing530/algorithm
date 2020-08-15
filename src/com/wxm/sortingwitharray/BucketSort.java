package com.wxm.sortingwitharray;

import com.wxm.commons.Commons;

public class BucketSort {
    public static void main(String[] args) {
        int[] mock = Commons.mockArray();
        Commons.printf(mock);
        System.out.println();
        sort(mock);
        Commons.printf(mock);
    }
    public static void sort(int[] arr){
        int len = arr.length;
        int bucketCount = 5;
        int max = Commons.max(arr);
        int min = Commons.min(arr);
        int fragment = (max-min)/(bucketCount-1);
        Bucket[] buckets = Bucket.buckets(bucketCount);
        for(int temp:arr){
            buckets[temp/fragment].sortedInsert(temp);
        }
        int pos = 0;
        for(int i=0;i<bucketCount;i++){
            int bucketLength = buckets[i].getLength();
            System.arraycopy(buckets[i].toArray(),0,arr,pos,bucketLength);
            pos+=bucketLength;
        }
    }

}
//自排序链表，用做桶排序的一个桶
class Bucket {
    private Node head;
    private int length=0;
    private static class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }
    public boolean hasNext(){
        return head!=null;
    }
    public int next(){
        if(head==null){
            throw new RuntimeException("invalid access");
        }
        int value = head.value;
        head = head.next;
        return value;
    }
    public int[] toArray(){
        int[] arr = new int[length];
        int i = 0;
        while (hasNext()){
            arr[i++] = next();
        }
        return arr;
    }
    public static Bucket[] buckets(int count){
        Bucket[] buckets = new Bucket[count];
        for(int i=0;i<count;i++){
            buckets[i] = new Bucket();
        }
        return buckets;
    }

    public int getLength() {
        return length;
    }

    public void sortedInsert(int value) {
        Node node = new Node(value);
        if(this.head ==null){
            this.head = node;
            length++;
            return;
        }
        Node current = this.head;
        Node preNode = null;
        while (current!=null&&node.value > current.value) {
            preNode = current;
            current = current.next;
        }
        if (preNode == null) {
            node.next = this.head;
            this.head = node;
        } else {
            node.next = current;
            preNode.next = node;
        }
        length++;
    }

}
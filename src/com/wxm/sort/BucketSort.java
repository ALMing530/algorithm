package com.wxm.sort;

import com.wxm.commons.Commons;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        int[] mock = Commons.mockArray();
        Commons.printf(mock);
        System.out.println();
        sort2(mock);
        Commons.printf(mock);
    }

    public static void sort(int[] arr) {
        int bucketCount = 5;
        int max = Commons.max(arr);
        int min = Commons.min(arr);
        int fragment = (max - min) / (bucketCount - 1);
        OrderBucket[] orderBuckets = OrderBucket.buckets(bucketCount);
        for (int item : arr) {
            orderBuckets[item / fragment].insert(item);
        }
        int pos = 0;
        for (int i = 0; i < bucketCount; i++) {
            int bucketLength = orderBuckets[i].getLength();
            System.arraycopy(orderBuckets[i].toArray(), 0, arr, pos, bucketLength);
            pos += bucketLength;
        }
    }
    public static void sort2(int[] arr){
        int bucketCount = 5;
        int max = Commons.max(arr);
        int min = Commons.min(arr);
        int fragment = (max-min)/(bucketCount-1);
        ArrayList<Integer>[] buckets = Commons.emptyArrayLists(5);

        for (int item : arr) {
            buckets[item/fragment].add(item);
        }
        int pos=0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            int[] conv = bucket.stream().mapToInt(Integer::valueOf).toArray();
            System.arraycopy(conv,0,arr,pos,conv.length);
            pos+=conv.length;
        }
    }
}

//自排序链表，用做桶排序的一个桶
class OrderBucket {
    private Node head;
    private int length = 0;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean hasNext() {
        return head != null;
    }

    public int next() {
        if (head == null) {
            throw new RuntimeException("invalid access");
        }
        int value = head.value;
        head = head.next;
        return value;
    }

    public int[] toArray() {
        int[] arr = new int[length];
        int i = 0;
        while (hasNext()) {
            arr[i++] = next();
        }
        return arr;
    }

    public static OrderBucket[] buckets(int count) {
        OrderBucket[] orderBuckets = new OrderBucket[count];
        for (int i = 0; i < count; i++) {
            orderBuckets[i] = new OrderBucket();
        }
        return orderBuckets;
    }

    public int getLength() {
        return length;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (this.head == null) {
            this.head = node;
            length++;
            return;
        }
        Node current = this.head;
        Node pre = null;
        while (current != null && node.value > current.value) {
            pre = current;
            current = current.next;
        }
        if (pre != null) {
            pre.next = node;
        } else {
            this.head = node;
        }
        node.next = current;
        length++;
    }

}
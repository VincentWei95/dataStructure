package com.example.heap;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * ǰk����ƵԪ�أ�
 *
 * ����һ���ǿյ��������飬�������г���Ƶ��ǰ k �ߵ�Ԫ��
 *
 * ����: nums = [1,1,1,2,2,3], k = 2
 * ���: [1,2]
 *
 * ����: nums = [1], k = 1
 * ���: [1]
 *
 * ˵����
 * ����Լ�������� k ���Ǻ���ģ��� 1 <= k <= �����в���ͬ��Ԫ�صĸ�����
 * ����㷨��ʱ�临�Ӷȱ������� O(n log n) , n ������Ĵ�С��
 */
public class TopKFrequency {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new TopKFrequency()).topKFrequent(nums, k));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        // java��PriorityQueueʵ��
        java.util.PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
        for (int key : map.keySet()) {
            if (pq.size() < k)
                pq.add(new Freq(key, map.get(key)));
            else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty())
            res.add(pq.remove().e);
        return res;
    }

    private class Freq{
        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
    }

    private class FreqComparator implements Comparator<Freq> {

        @Override
        public int compare(Freq a, Freq b){
            return a.freq - b.freq;
        }
    }

//    public List<Integer> topKFrequent(int[] nums, int k) {
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        for(int num: nums){
//            if(map.containsKey(num))
//                map.put(num, map.get(num) + 1);
//            else
//                map.put(num, 1);
//        }
//
//        // ����ʵ�ֵ�PriorityQueue
//        PriorityQueue<Freq> pq = new PriorityQueue<>();
//        for(int key: map.keySet()){
//            if(pq.getSize() < k)
//                pq.enqueue(new Freq(key, map.get(key)));
//            else if(map.get(key) > pq.getFront().freq){
//                pq.dequeue();
//                pq.enqueue(new Freq(key, map.get(key)));
//            }
//        }
//
//        LinkedList<Integer> res = new LinkedList<>();
//        while(!pq.isEmpty())
//            res.add(pq.dequeue().e);
//        return res;
//    }

//    private class Freq implements Comparable<Freq>{
//        public int e, freq;
//
//        public Freq(int e, int freq){
//            this.e = e;
//            this.freq = freq;
//        }
//
//        @Override
//        public int compareTo(Freq another){
//            if(this.freq < another.freq)
//                return 1;
//            else if(this.freq > another.freq)
//                return -1;
//            else
//                return 0;
//        }
//    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums)
            System.out.print(num + " ");
        System.out.println();
    }
}

package com.vanjor.leetcode.t128;

import java.util.HashMap;

/**
 *  medium
 *  problem: word-search https://leetcode.com/problems/word-search/
 *  time: taking 4+ hours for 2 coding bug, array index&value mistake, iteration infinite loop
 *  performance: O(n) time, O(n) space , >97% Java
 *  method: dic & recursive
 */
public class Solution implements SolutionInterface {
    public static class LinNode {
        private int value;
        private LinNode prev;
        private LinNode next;

        public LinNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public LinNode getPrev() {
            return this.prev;
        }

        public LinNode getNext() {
            return this.next;
        }

        public void setPrev(LinNode node) {
            this.prev = node;
        }

        public void setNext(LinNode node) {
            this.next = node;
        }
    }

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, LinNode> map = new HashMap<>(nums.length * 2);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            } else {
                LinNode node = new LinNode(nums[i]);
                map.put(node.getValue(), node);
                if (map.containsKey(node.getValue() - 1)) {
                    LinNode preNode = map.get(node.getValue() - 1);
                    preNode.setNext(node);
                    node.setPrev(preNode);
                }
                if (map.containsKey(node.getValue() + 1)) {
                    LinNode nextNode = map.get(node.getValue() + 1);
                    nextNode.setPrev(node);
                    node.setNext(nextNode);
                }
            }
        }
        LinNode it;
        int max = 0;
        for (LinNode entry : map.values()) {
            if (entry.getPrev() != null) {
                continue;
            }
            int count = 1;
            it = entry;
            while ((it = it.getNext()) != null) {
                count++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}

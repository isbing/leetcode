package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;
import com.isbing.leetcode.bean.ListNode;

/**
 * Created by songbing
 * Created time 2019/5/18 上午11:21
 */
public abstract class LeetCode141 extends LeetCoding{

    // 判断是否有环 就是最后一个节点的next是否指向 曾经遍历过的节点
    // 思路一：用set 存储每一个遍历到的节点。  时间空间都是 O(N)

    // 思路二：用快慢指针 快指针每次走两步 慢指针每次走一步
    // 没有环的话 大家就走完了，只要都还能走的情况下。就说明是有环的。
    // 在环里，快指针一定会追赶上慢指针。只要能追击相遇，就说明有环 空间为0(1) 时间0(N)

    /**
     * 这个题目说的是，给你一个单链表，你要判断它是否会形成环，
     * 也就是链表的最后一个节点指向了前面一个已经存在的节点。
     */
    @Override
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;//fast.next.next 肯定要判断空
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}

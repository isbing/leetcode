package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.ListNode;

/**
 * Created by songbing
 * Created time 2020/3/7 下午11:54
 */
public class LeetCode206 {

    // 迭代  1-2-3-4-5
    public ListNode reverseList_1(ListNode head) {
        // 定义两个指针，current与它的前指针
        ListNode current = head, pre = null;
        while (current != null){
            ListNode next = current.next;
            current.next = pre;// current指向前指针 即可
            // 更新current与pre指针
            pre = current;
            current = next;
        }
        return pre;
    }

    // 采用递归。思路还是这样，用当前指针，前驱指针
    public ListNode reverseList_2(ListNode head) {
        return reverseList_2_di(null,head);
    }

    private ListNode reverseList_2_di(ListNode pre, ListNode current) {
        if(current == null) return pre;
        // 保存next指针
        ListNode next = current.next;
        current.next = pre;
        return reverseList_2_di(current,next);
    }

}

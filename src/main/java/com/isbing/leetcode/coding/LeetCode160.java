//package com.isbing.leetcode.coding;
//
//import com.isbing.leetcode.LeetCoding;
//import com.isbing.leetcode.bean.ListNode;
//
///**
// * Created by songbing
// * Created time 2019/5/20 下午11:51
// */
//public abstract class LeetCode160 extends LeetCoding{
//
//    // 思路一：对空间复杂度没有要求，就可以将两个链表分别入两个栈，两个栈分别出栈 比较
//    // 空间复杂度 o(m+n)
//
//    // 思路二：将两个链表都循环一下 得到长度。链表1的长度为4 链表2的长度为5
//    // 5-4=1，所以第二个链表先走移位，然后两个链表同时移动，看有没有相等的。。
//    // Time: O(m+n), Space: O(1)
//
//
//    /**
////     * 这个题目说的是，给你两个单链表，你要找到它们相交的第一个节点。
//     * 如果两个链表没有相交，则返回空指针。假设链表无环，并且你不能改变它的原始结构。
//     * 另外要求算法是线性时间复杂度，空间复杂度要求是 O(1)。
//     比如说，两条链表分别是：
//     A:     1 -> 2
//                    \
//                     6 -> 7 -> null
//                    /
//     B: 3 -> 4 -> 5
//     你要返回的是 6 这个节点。
//     */
//    @Override
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        int lenA = 0,lenB = 0;
//        ListNode p = headA;
//        ListNode q = headB;
//        ListNode pp = headA;
//        ListNode qq = headB;
//        while (p != null){
//            lenA++;
//            p = p.next;
//        }
//        while (q != null){
//            lenB++;
//            q = q.next;
//        }
//        if(lenA < lenB){
//            for(int i=0; i<lenB-lenA; i++){
//                qq = qq.next;
//            }
//        }else{
//            for(int i=0; i<lenA-lenB; i++){
//                pp = pp.next;
//            }
//        }
//        while (pp != null && qq != null){
//            if(pp == qq){
//                return pp;
//            }else{
//                pp = pp.next;
//                qq = qq.next;
//            }
//        }
//        return null;
//    }
//}

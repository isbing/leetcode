package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.ListNode;
import com.isbing.leetcode.bean.TreeNode;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Stack;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode206Test {

	public ListNode reverseList(ListNode head) {
		// 输入: 1->2->3->4->5->NULL
		if(head == null) return null;
		ListNode current = head;
		ListNode pre = null;
		while (current != null){
			ListNode next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		// next还有最后一个null 舍弃
		return pre;
	}

}

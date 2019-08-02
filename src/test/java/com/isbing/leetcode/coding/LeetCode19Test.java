package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode19Test {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode temp = new ListNode(0);
		temp.next = head;

		// 定义两个指针 指向头节点
		ListNode p = temp;
		ListNode q = temp;
		// q 先走n步
		for(int i=1; i<=n; i++){
			q = q.next;
		}
		// 只要q.next != null 就一起走
		while (q.next != null){
			p = p.next;
			q = q.next;
		}
		// 移除指针
		p.next = p.next.next;
		return temp.next;
	}
}

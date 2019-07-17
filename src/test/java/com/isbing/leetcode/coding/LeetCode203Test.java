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
public class LeetCode203Test {

	public ListNode removeElements(ListNode head, int val) {
		// 定义一个头结点 不然没有头结点 很不好操作
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode p = pre;

		while (head != null){
			if(head.val == val){
				head = head.next;
				pre.next = head;
			}else{
				// 不等 两指针都向后移动一下
				head = head.next;
				pre = pre.next;
			}
		}
		return p.next;
	}

}

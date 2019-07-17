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
public class LeetCode2Test {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// -1作为头结点
		ListNode result = new ListNode(-1);
		// 尾插法
		ListNode tail = result;
		// 进位标识
		int flag = 0;
		while (l1 != null || l2 != null || flag != 0){
			int num = flag; //需要加上 进位
			if(l1 != null){
				num += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				num += l2.val;
				l2 = l2.next;
			}
			flag = num / 10;
			if(num >= 10){
				num = num % 10;
			}
			ListNode node = new ListNode(num);
			tail.next = node;
			tail = node;
		}
		return result.next;
	}

}

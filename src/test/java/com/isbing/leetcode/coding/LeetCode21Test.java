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
public class LeetCode21Test {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode myNode = new ListNode(-1);
		ListNode p = myNode;
		while (l1 != null && l2 != null){
			if(l1.val <= l2.val){
				ListNode temp = l1.next;
				// 断链
				l1.next = null;
				p.next = l1;
				p = l1;
				l1 = temp;
			}else{
				ListNode temp = l2.next;
				// 断链
				l2.next = null;
				p.next = l2;
				p = l2;
				l2 = temp;
			}
		}
		if (l1 != null){
			p.next = l1;
		}
		if (l2 != null){
			p.next = l2;
		}
		return myNode.next;
	}
}

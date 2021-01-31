package com.sangsang.letcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

//@SpringBootTest
class LetcodeApplicationTests {

	@Test
	void contextLoads() {
		BitSet bitSet = new BitSet();
		for (int i = 0; i <10 ; i++) {
			bitSet.set((int) (Math.random() * 10));
		}
		System.out.println(bitSet);
	}

}

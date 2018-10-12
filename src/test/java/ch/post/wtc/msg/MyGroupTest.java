package ch.post.wtc.msg;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyGroupTest {

	@Test
	public void testMyMessage() {
		MyGroup o = new MyGroup();
		assertEquals("Result","My message\n",o.getMessage());
	}
}

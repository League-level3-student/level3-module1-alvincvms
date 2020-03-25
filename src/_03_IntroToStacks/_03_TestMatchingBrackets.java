package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		boolean bool = true;
		Stack<Character> c = new Stack<Character>();
		for(int i = 0; i < b.length(); i++) {
			c.push(b.charAt(i));
		}
		for(int i = 0; i < c.size(); i++) {
			if(c.get(i).equals('{')) {
				if(i == (c.size()-1)) {
					bool = false;
					break;
				}
				else if(!c.get(i+1).equals('}')) {
					bool = false;
					break;
				}
			}
			if(c.get(i).equals('}')) {
				if(i == 0) {
					bool = false;
					break;
				}
				else if(!c.get(i-1).equals('{')) {
					bool = false;
					break;
				}
			}
		}
		
		return bool;
	}

}
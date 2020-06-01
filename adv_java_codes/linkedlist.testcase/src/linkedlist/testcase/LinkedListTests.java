package linkedlist.testcase;

//import all static methods from Assert class
//this way all static method of the calss can be invoked without using Class reference
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.collections.LinkedList;

public class LinkedListTests {

	@Test
	public void new_listIsEmpty() {
		LinkedList<Integer> list = new LinkedList<>();
		assertEquals(0, list.size());
	}

	@Test
	public void toString_returnsListWithEmptyParenthesis() {
		LinkedList<Integer> list = new LinkedList<Integer>();

		assertEquals("LinkedList()", list.toString());
	}

	@Test
	public void add_canAddToAnEmptyList() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		assertEquals(0, list.size());
		list.add(10);
		assertEquals(1, list.size());
		// System.out.println(list.toString());
	}

	@Test
	public void add_addingToANonEmptyListAddsItemAtTheEnd() {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);

		assertEquals(2, list.size());

		// System.out.println(list.toString());

	}

	@Test
	public void add_addedItemsAreShownInToString() {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);

		assertEquals("LinkedList(	10	20	)", list.toString());

	}

	@Test
	public void get_0GetsTheFirstItem() {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);

		int value = list.get(0);

		assertEquals(10, value);
	}

	@Ignore
	@Test
	public void get_PosReturnsItemsFromZeroBasedIndex() {

	}

	@Test
	public void get_throwsIndexExceptionForInvalidIndex() {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);

		try {
			list.get(5);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@Ignore
	@Test
	public void get_NegativeIndexIsACirclularIndex() {
		// -1 is last item
		// -2 is second last item
		// -3 is third last item
		// size() is first item

		// you will have to modify LinkedList to implement this feature
	}

	@Ignore
	@Test
	public void set_setDoesntAddNewItem() {

	}

	@Ignore
	@Test
	public void set_replacesCurrentItem() {

	}

	@Test
	public void set_failsForInvalidIndex() {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);

		try {
			list.set(8, 10);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void remove_removesTheItemFromValidIndex() {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);

		try {
			System.out.println(list.toString());
			list.remove(4);
			System.out.println(list.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void remove_usesCircularIndex() {

	}

	@Test
	public void get_removeReturnsTheRemovedItem() {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);

		int value = -1;

		try {
			value = list.remove(3);
			assertEquals(10, value);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}

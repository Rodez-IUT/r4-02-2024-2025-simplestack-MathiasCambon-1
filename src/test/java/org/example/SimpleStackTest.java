package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class   SimpleStackTest {

    private Stack stack;
    private Item item;
    private Item item2;

    @BeforeEach
    @DisplayName("Creation of a stack and two items")
    public void setUp() {
        stack = new SimpleStack();

    }

    @Test
    @DisplayName("Test the state of a newly created slack")
    public void testCreateEmptyStack() { // Test case

        // Then… (oracle)
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals( 0, stack.getSize(), "A new stack has no element");
    }

    @Test
    @DisplayName("Test pushing a single item to an empty stack")
    public void testPushSingleItem() throws EmptyStackException {

        // When the item is pushed onto the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(), "The stack must contain 1 item");
        assertSame(item, stack.peek(), "The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test pushing a second item to a non-empty stack")
    public void testPushSecondItem() throws EmptyStackException {

        // When the second item is pushed onto the stack
        stack.push(item2);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(2, stack.getSize(), "The stack must contain 2 items");
        assertSame(item2, stack.peek(), "The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack()  {

        // When we "pop" the stack, should throws an EmptyStackException.
        //assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPeekOnEmptyStack()  {

        // When we "pop" the stack, should throws an EmptyStackException.
        //assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::peek, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test the pop of the item")
    public void testPop() throws EmptyStackException {


        stack.push(item2);

        // When we pop the stack
        Item poppedItem = stack.pop();

        // Then...
        assertSame(item2, poppedItem, "The popped item should be the top item");
        assertEquals(1, stack.getSize(), "The stack should contain 1 item after popping");
    }


}

package com.plural.spring.fundamentals.utils;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class PriorityList {

    private static final int INITIAL_CAPACITY = 11;

    private int size = 0;
    private int[] heap;
    private int capacity = INITIAL_CAPACITY;

    public PriorityList() {
        this.heap = new int[capacity];
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private int leftChildValue(int index) {
        return heap[getLeftChildIndex(index)];
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private int rightChildValue(int index) {
        return heap[getRightChildIndex(index)];
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int parentValue(int index) {
        return heap[getParentIndex(index)];
    }

    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity = capacity * 2;
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        int element = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = element;
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parentValue(index) > heap[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallestIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChildValue(index) < leftChildValue(index)) {
                smallestIndex = getRightChildIndex(index);
            }
            if (heap[index] < heap[smallestIndex]) {
                break;
            } else {
                swap(index, smallestIndex);
            }
            index = smallestIndex;
        }
    }

    public void add(int value) {
        ensureCapacity();
        heap[size] = value;
        size++;
        heapifyUp();
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int value = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return value;
    }

    public void printHeap() {
        for(int i : heap) {
            System.out.println(i);
        }
    }
}

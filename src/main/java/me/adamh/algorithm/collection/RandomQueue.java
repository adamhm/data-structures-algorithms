package me.adamh.algorithm.collection;

import java.util.*;
import java.util.stream.Collectors;

public class RandomQueue<E> implements Iterable<E> {
    
    private static final int INITIAL_CAPACITY = 10;
    private static final Random RANDOM = new Random();
    private E[] elements;
    private int capacity;
    private int size;
    
    @SuppressWarnings("unchecked")
    public RandomQueue(int capacity) {
        elements = (E[]) new Object[capacity];
        this.capacity = capacity;
    }
    
    public RandomQueue() {
        this(INITIAL_CAPACITY);
    }
    
    @Override
    public Iterator<E> iterator() {
        List<E> shuffledElements = Arrays
            .asList(Arrays.copyOfRange(elements, 0, size));
        Collections.shuffle(shuffledElements);
        
        return shuffledElements.iterator();
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void enqueue(E element) {
        if (size + 1 > capacity) {
            grow();
        }
        
        elements[size++] = element;
    }
    
    public E dequeue() {
        int randomIndex = RANDOM.nextInt(size);
        E value = elements[randomIndex];
        elements[randomIndex] = elements[--size];
        elements[size] = null;
        
        return value;
    }
    
    public E sample() {
        int randomIndex = RANDOM.nextInt(size);
        
        return elements[randomIndex];
    }
    
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        
        for (int i = 0; i < size; i++) {
            joiner.add(elements[i].toString());
        }
        
        return joiner.toString();
    }
    
    private void grow() {
        capacity += capacity / 2;
        elements = Arrays.copyOf(elements, capacity);
    }
    
}

package se.collections.iterator;

/**
 * 自定义迭代器
 *
 */
public interface MyIterator<T> {

    boolean hasNext();

    void next();

    T currentValue();

}

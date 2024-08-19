package online.bigzhouzhou.design_patterns.behavioral.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * ReverseArrayCollection类<br/>
 * date: 2024/8/19 22:19<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class ReverseArrayCollection<T> implements Iterable<T> {
    private T[] array;

    public ReverseArrayCollection(T... objs) {
        this.array = Arrays.copyOfRange(objs, 0, objs.length);
    }
    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator();
    }

    class ReverseIterator implements Iterator<T> {
        int index;

        public ReverseIterator() {
            this.index = ReverseArrayCollection.this.array.length;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return array[index];
        }
    }
}

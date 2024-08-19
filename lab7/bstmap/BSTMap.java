package bstmap;

import edu.princeton.cs.algs4.BST;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class BSTNode<K, V> {
        K key;
        V value;
        BSTNode<K, V> parent;
        BSTNode<K, V> leftChild;
        BSTNode<K, V> rightChild;

        public BSTNode(K k, V v, BSTNode<K, V> p, BSTNode<K, V> l, BSTNode<K, V> r) {
            key = k;
            value = v;
            parent = p;
            leftChild = l;
            rightChild = r;
        }
    }

    private BSTNode<K, V> root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        BSTNode<K, V> current = root;
        while (current != null && !key.equals(current.key)) {
            if (key.compareTo(current.key) < 0) {
                current = current.leftChild;
            } else if (key.compareTo(current.key) > 0) {
                current = current.rightChild;
            }
        }
        return current != null;
    }

    @Override
    public V get(K key) {

        BSTNode<K, V> current = root;
        while (current != null && !key.equals(current.key)) {
            if (key.compareTo(current.key) < 0) {
                current = current.leftChild;
            } else if (key.compareTo(current.key) > 0) {
                current = current.rightChild;
            }
        }
        if (current == null) {
            return null;
        } else {
            return current.value;
        }

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void put(K key, V value) {
        if (containsKey(key)) {
            return;
        }
        if (root == null) {
            root = new BSTNode<>(key, value, null, null, null);
            size += 1;
        } else {
            BSTNode<K, V> current = root;
            while (true) {
                if (key.compareTo(current.key) < 0) {
                    if (current.leftChild == null) {
                        current.leftChild = new BSTNode<>(key, value, current, null, null);
                        size += 1;
                        break;
                    }
                    current = current.leftChild;
                } else if (key.compareTo(current.key) > 0) {
                    if (current.rightChild == null) {
                        current.rightChild = new BSTNode<>(key, value, current, null, null);
                        size += 1;
                        break;
                    }
                    current = current.rightChild;
                }
            }
        }
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    public void printInOrder() {
    }
}

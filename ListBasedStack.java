/*
 * Author: Amittai Aviram - aviram@bc.edu
 */

public class ListBasedStack<T> implements Stack<T> {

  private List<T> data;

  public ListBasedStack() {
    data = new SinglyLinkedList<>();
  }

  @Override
  public int size() {
    return data.size();
  }

  @Override
  public boolean isEmpty() {
    return data.isEmpty();
  }

  @Override
  public T top() {
    return data.first();
  }

  @Override
  public T pop() {
    return data.removeFirst();
  }

  @Override
  public void push(T datum) {
    data.addFirst(datum);
  }

  public void print() {
    ((SinglyLinkedList<T>) data).print();
  }

  @Override
  public void clear() {
    data.clear();
  }
}

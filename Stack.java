/*
 * Author: Amittai Aviram - aviram@bc.edu
 */
public interface Stack<T> {
  public int size();
  public boolean isEmpty();
  public T top();
  public T pop();
  public void push(T item);
  public void clear();
}

package ch.epfl.sweng.dp3.ex3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntegerBox implements Iterable<Integer>{
  private int[] box;

  public IntegerBox(int... numbers) {
    int amount = numbers.length;
    box = new int[amount];

    for (int i = 0; i < amount; ++i) {
      box[i] = numbers[i];
    }
  }

  public void add(int number) {
    int[] newBox = new int[box.length + 1];

    for (int i = 0; i < box.length; ++i) {
      newBox[i] = box[i];
    }
    newBox[box.length] = number;
    box = newBox;
  }

  public int[] getIntegers() {
    return box;
  }

  public Iterator iterator(){
    return new Iterator<Integer>(){
      private int current = 0;
      private int length = box.length;

      @Override
      public boolean hasNext(){
        return current < length;
      }

      @Override
      public Integer next(){
        if(hasNext()){
          return box[current++];
        }
        else{
          throw new NoSuchElementException();
        }
      }

    };
  }
}

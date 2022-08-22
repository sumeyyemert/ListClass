import java.util.Arrays;
public class MyList <T>{
    private T[] list, newList;
 
public MyList(){
    this.list = (T[]) new Object[10];
}

public MyList(int capacity){
  this.list = (T[]) new Object[capacity];
}

public void add(T value){
    if(list[list.length - 1] != null){
        this.newList = (T[]) new Object[2*list.length];
        // System.out.println("Uzunluk 2 katına çıktı.");
        for(int i = 0; i < list.length; i++){
            newList[i] = list[i];
        }
        list = newList;
    }

    boolean isContinue = true;
        // System.out.println("While çalıştı");
        for (int i = 0; i < list.length && isContinue == true; i++) {
            if (list[i] == null) {
                list[i] = value;
                isContinue = false;
            }
        }
    }

public int size() {
    int count = 0;
    for (int i = 0; i < list.length; i++) {
        if (list[i] != null) {
            count++;
        }
    }
    return count;
}

public int getCapacity(){
    return list.length;
}


public T get(int index){
    return list[index];
}

public T remove(int index) {
    if (index >= list.length || index < 0) {
        return null;
    } else {
        for (int i = index; i < list.length - 1; i++)
            list[index] = list[index + 1];
        return list[index];
    }
}

public T set(int index, T data) {
    if (index >= list.length || index < 0) {
        return null;
    } else {
        list[index] = data;
        return list[index];
    }
}

public T[] toArray(){
    T[] array = (T[]) new Object[list.length];
    for(int i = 0; i < list.length; i++){
        array[i] = list[i];
    }
    return array;
}

    public String toString() {
    int count = 0;
    for( T e : list){
        if( e != null){
            count ++;
        }
    }
        System.out.print("[");

        for (int a = 0; a<count; a++) {
            System.out.print(list[a]);
            if(a != count-1) {
                System.out.print(",");
            }
        }
        return "]";
    }

public int indexOf(T data){
         for(int i = 0; i< list.length ; i++) {
             if (list[i] == data) {
                 return i;
             }
         }
    return -1;
}

public int lastIndexOf(T data) {
    int index = 0;
    for(int i = 0; i < list.length ; i++) {
        if (list[i] == data && i > index) {
            index = i;
        }
    }
    return index;
}

public boolean isEmpty(){
    for(T e : list)
        if(e != null) {
            return false;
        }
    return true;
}

public void clear(){
    for(int i = 0; i < list.length; i++){
        list[i] = null;
    }
}

public MyList<T>  subList(int start,int finish){
    MyList<T> partOfList = new MyList<>();
    for(int i = start; i<=finish; i++){
        partOfList.add(this.list[i]);
    }
    return partOfList;
    }

public boolean contains(T data){
    for(T e : list){
        if( e == data){
            return true;
        }
    }
    return false;
}

}
/*
    int count = 1;
    for(int i = 0; i < list.length && list[i] != null; i++){
        count++;
    }
    T[] printList = (T[])new Object[count];
    for(int i = 0; i < printList.length; i++)
         printList[i] = list[i];

 */
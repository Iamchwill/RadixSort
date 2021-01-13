public class MyLinkedList{
  private int size;
  private Node start,end;
  public MyLinkedList(){
    size = 0;
    start = null;
    end = null;
  }

  public int size(){
    return size;
  }

  public boolean add(String value){
    if(start == null) {
      Node set = new Node(value);
      start = set;
      end = set;
    }
    else{
      Node add = new Node(value);
      end.setNext(add);
      add.setPrev(end);
      end = add;
    }
    size++;
    return true;
  }

  public void add(int index, String value){
    if(index > size || index < 0) throw new IndexOutOfBoundsException();
    if(index == size){
      this.add(value);
      size--;
    }
    else if(index == 0){
      if(end == null){}
      Node add = new Node(value);
      add.setNext(start);
      start.setPrev(add);
      if(end == null) end = start;
      start = add;
    }
    else{
      Node add = new Node(value);
      Node previous = start;
      for(int i = 0; i < index - 1; i++){
        previous = previous.getNext();
      }
      Node next = previous.getNext();
      add.setPrev(previous);
      add.setNext(next);
      previous.setNext(add);
      next.setPrev(add);
    }
    size++;
  }
  public String get(int index){
    if(index >= size || index < 0) throw new IndexOutOfBoundsException();
    Node value = start;
    for(int i = 0; i < index; i++){
      value = value.getNext();
    }
    return value.getValue();
  }

  public String set(int index, String value){
    if(index >= size || index < 0) throw new IndexOutOfBoundsException();
    Node search = start;
    for(int i = 0; i < index; i++){
      search = search.getNext();
    }
    String out = search.getValue();
    search.setValue(value);
    return out;
  }

  public String toString(){
    Node current = start;
    String out = "";
    out += "[";
    while(current != null){
      out += current.getValue();
      if(current.getNext() != null) out += ", ";
      current = current.getNext();
    }
    out += "]";
    return out;
  }

  public String toStringReversed(){
    Node current = end;
    String out = "";
    out += "[";
    while(current != null){
      out += current.getValue();
      if(current.getPrev() != null) out += ", ";
      current = current.getPrev();
    }
    out += "]";
    return out;
  }

  public String remove(int index){
    if(index >= size || index < 0) throw new IndexOutOfBoundsException();
    Node value = start;
    if(size == 1){
      start = null;
      end = null;
    }
    else if(index == 0){
      start = value.getNext();
      if(start != null) start.setPrev(null);
    }
    else if(index == size - 1){
      value = end;
      end = value.getPrev();
      end.setNext(null);
    }
    else{
    for(int i = 0; i < index; i++){
      value = value.getNext();
    }
    Node previous = value.getPrev();
    Node next = value.getNext();
    previous.setNext(next);
    next.setPrev(previous);
  }
    size--;
    return value.getValue();
  }

  public void extend(MyLinkedList other){
    if(start == null){
      start = other.start;
      end = other.end;
    }
    else if(other.start == null);
    else{
      Node link = other.start;
      end.setNext(link);
      link.setPrev(end);
      end = other.end;
    }
    size += other.size();
    other.clear();
  }

  private void clear(){
    start = null;
    end = null;
    size = 0;
  }

  public void printEnd(){
    System.out.println(end.getValue());
  }

  public void printStart(){
    System.out.println(start.getValue());
  }
}

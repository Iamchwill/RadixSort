public class Radix{
  public static int nth(int n, int col){
    int out = (n % (int)(10 * Math.pow(10, col))) / (int)Math.pow(10, col);
    return out;
  }

  public static int length(int n){
    int out = (int)(Math.log10(Math.abs(n)) + 1);
    return out;
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
    for(int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int longest = 1;
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for(int i = 0; i < 10; i++){
      buckets[i] = new SortableLinkedList();
    }
    int length = data.size();
    for(int i = 0; i < longest; i++){
      for(int loop = 0; loop < length; loop++){
        int sort = data.remove(0);
        buckets[nth(sort, i)].add(sort);
        if(i == 0){
          if(length(sort) > longest) longest = length(sort);
        }
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList negative = new SortableLinkedList();
    SortableLinkedList positive = new SortableLinkedList();
    int length = data.size();
    for(int i = 0; i < length; i++){
      int sep = data.remove(0);
      if(sep < 0) negative.add(-sep);
      else positive.add(sep);
    }
    radixSortSimple(positive);
    radixSortSimple(negative);
    SortableLinkedList out = new SortableLinkedList();
    for(int i = negative.size() - 1; i >= 0; i--){
      data.add(-negative.get(i));
    }
    data.extend(positive);
  }
  
}

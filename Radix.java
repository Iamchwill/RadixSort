public class Radix{
  public static int nth(int n, int col){
    int out = (n % (int)(10 * Math.pow(10, col))) / (int)Math.pow(10, col);
    return out;
  }

  public static int length(int n){
    int out = (int)(Math.log10(n) + 1);
    return out;
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
    for(int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){

  }

  public static void radixSort(SortableLinkedList data){

  }
}

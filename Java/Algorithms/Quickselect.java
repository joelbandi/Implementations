public class Quickselect {
  public static int quickselect (int[] array,int k) {
    if (array.length == 0 || k > array.length) {
      throw new RuntimeException("Illegal Arguments");
    }else {
      return select(array,0,array.length-1,k);
    }
  }
  
  public static int select(int[] array,int left,int right,int k) {
    
    int pIndex = partition(array,left,right);
    if (pIndex == k-1) return array[pIndex];
    if (pIndex <= k-1) return select(array,pIndex+1,right,k);
    return select(array,left,pIndex-1,k);
  }
  

  public static int partition(int[] array, int left, int right) {
    
    int pIndex = left;
    int pivot = array[right];

    for(int i = left; i < right-1; i++) {

      if (array[i] <= pivot) {
        swap(array,i,pIndex);
        pIndex++;
      }

    }
    swap(array,right,pIndex);
    return pIndex;
  }

  public static void swap(int[] array, int i, int j) {
    int tmp = array[j];
    array[j] = array[i];
    array[i] = tmp;
  }

  public static void main(String[] args) {

    System.out.println(quickselect(new int[]{1,2,3,6,5,4,7,8},3));
    
  }

}
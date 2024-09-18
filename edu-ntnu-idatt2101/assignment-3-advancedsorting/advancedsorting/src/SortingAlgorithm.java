public class SortingAlgorithm {

  public static int runInsertionSort = 100;
  private static void change(int[] t, int v, int h) {
    int temp = t[v];
    t[v] = t[h];
    t[h] = temp;
  }

  private static int median3Sort(int[] t, int v, int h) {
    int m = (v + h) / 2;
    if (t[v] > t[m]) {
      change(t, v, m);
    }
    if (t[m] > t[h]) {
      change(t, m, h);
      if (t[v] > t[m]) {
        change(t, v, m);
      }
    }
    return m;
  }

  private static int split(int[] t, int v, int h) {
    int iv, ih;
    int m = median3Sort(t, v, h);
    int dv = t[m];
    change(t, m, h - 1);
    for (iv = v, ih = h - 1; ; ) {
      while (t[++iv] < dv) ;
      while (t[--ih] > dv) ;
      if (iv >= ih) {
        break;
      }
      change(t, iv, ih);
    }
    change(t, iv, h - 1);
    return iv;
  }

  public static void quickSort(int[] t, int v, int h) {
    if (h - v > 2) {
      int delepos = split(t, v, h);
      quickSort(t, v, delepos - 1);
      quickSort(t, delepos + 1, h);
    } else {
      median3Sort(t, v, h);
    }
  }

  public static void quickSortWithHelp(int[] t, int v, int h) {
    if (h - v > runInsertionSort) {
      int delepos = split(t, v, h);
      quickSortWithHelp(t, v, delepos - 1);
      quickSortWithHelp(t, delepos + 1, h);
    } else {
      //System.out.println("H - V = " + (h - v));
      insertionSorting(t, v, h);
    }
  }

  public static void insertionSorting(int[] t, int v, int h) {
    for (int j = v; j < h + 1; ++j) {
      int change = t[j];
      int i = j - 1;
      while (i >= v && t[i] > change) {
        t[i + 1] = t[i];
        --i;
      }
      t[i + 1] = change;
    }
  }
}

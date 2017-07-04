public class Levelorder {
  public void printLevels(Tree t) {
    int d = depth(t);
    for (int i = 1; i <= depth; i++) {
      printLevelGiven(t, i);
    }
  }

  private void printLevelGiven(Tree t, int depth) {

    if(t == null) return;
    if(depth == 1) {
      System.out.println(t.value);
    }else {
      printLevelGiven(t.left, depth-1);
      printLevelGiven(t.right, depth-1);
    }

    System.out.println('\n');
  }

  private int depth(Tree t) {

    if (t == null) return 0;
    return 1 + depth(t.right) + depth(t.left);

  }

}
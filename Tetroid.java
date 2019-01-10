public class Tetroid{
  public static void main(String[] args) {
    ArrayList room0 = new ArrayList();
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 30; j++) {
        room0.add(j);
        room0.add(i);
      }
    }
    for (int i = 0; i < 16; i++) {
      for (int j = 0; j < 2; j++) {
        room0.add(j);
        room0.add(i);
      }
    }
    for (int i = 18; i < 20; i++) {
      for (int j = 0; j < 30; j++) {
        room0.add(j);
        room0.add(i);
      }
    }
    Room0 = new Room(0, room0, )
  }
}

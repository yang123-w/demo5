package c2;

public class Singleton {
    static volatile  Singleton instance;

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Singleton.i = i;
    }

    static int i =11;
    static Singleton getInstance(){
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}

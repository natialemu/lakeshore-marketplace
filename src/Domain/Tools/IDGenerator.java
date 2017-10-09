package Domain.Tools;

public class IDGenerator {
    private static int id = 0;

    public static int getId(){
        id += 1;
        return id;
    }

}

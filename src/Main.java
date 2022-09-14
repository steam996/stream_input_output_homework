import java.io.File;

public class Main {
    public static void main(String[] args) {

        File dir1 = new File("./SomeDir");
        if(dir1.mkdir()){
            System.out.println("Make dir");
        }

    }
}
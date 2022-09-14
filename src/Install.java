import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Install {
    static String path = "F://Games/";
    static String [] dirList = {"src", "res", "savegames", "temp"};
    static String [] srcDirList = {"main", "test"};
    static String [] resDirList = {"drawables", "vectors", "icons"};
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        for (String dirName: dirList) {
            Date date = new Date();
            File dir1 = new File(path + dirName);
            switch (dirName){
                case "src":
                    if (dir1.mkdir()){
                        stringBuilder.append(date + "  Папка " + dirName + " была создана \n");
                        for (String srcDirName: srcDirList){
                            String fullPath = path + dirName + "/" + srcDirName;
                            File srcDir = new File(fullPath);
                            switch (srcDirName){
                                case "main":
                                    if (srcDir.mkdir()){
                                        File main = new File(fullPath, "Main.java");
                                        File utils = new File(fullPath, "Utils.java");
                                        try {
                                            main.createNewFile();
                                            utils.createNewFile();
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                    break;
                                case "test":
                                    srcDir.mkdir();
                                    break;
                            }
                        }
                    } else {
                        stringBuilder.append(date + "  Папка " + dirName + " не была создана \n");
                    }
                    break;
                case "res":
                    if (dir1.mkdir()){
                        stringBuilder.append(date + "  Папка " + dirName + " была создана \n");
                        for (String resDirName: resDirList){
                            String fullPath = path + dirName + "/" + resDirName;
                            File resDir = new File(fullPath);
                            resDir.mkdir();
                        }
                    } else {
                        stringBuilder.append(date + "  Папка " + dirName + " не была создана \n");
                    }
                    break;
                case "savegames":
                    if (dir1.mkdir()){
                        stringBuilder.append(date + "  Папка " + dirName + " была создана \n");
                    } else {
                        stringBuilder.append(date + "  Папка " + dirName + " не была создана \n");
                    }
                    break;
                case "temp":
                    if (dir1.mkdir()){
                        File tempFile = new File(path + dirName, "temp.txt");
                        try {
                            tempFile.createNewFile();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        stringBuilder.append(date + "  Папка " + dirName + " была создана \n");
                    } else {
                        stringBuilder.append(date + "  Папка " + dirName + " не была создана \n");
                    }
                    break;


            }
            System.out.println(stringBuilder);
        }



    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Install {
    static String path = "/home/user/Games/";
    static String[] dirList = {"src", "res", "savegames", "temp"};
    static String[] srcDirList = {"main", "test"};
    static String[] resDirList = {"drawables", "vectors", "icons"};
    static Date date = new Date();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        for (String dirName : dirList) {
            createDir(path + dirName);
        }

        for (String dirName : srcDirList) {
            createDir(path + "src/" + dirName);
        }
        createFile(path + "src/main", "Main.java");
        createFile(path + "src/main", "Utils.java");
        for (String dirName : resDirList) {
            createDir(path + "res/" + dirName);
        }
        createFile(path + "temp", "temp.txt");
        stringBuilder.append("====================================== \n");
        writeLog(path + "temp/temp.txt");
    }

    static void createDir(String dirName) {
        File dir = new File(dirName);
        if (dir.mkdir()) {
            stringBuilder.append(date + "  Папка " + dirName + " была создана \n");
        } else {
            stringBuilder.append(date + "  Папка " + dirName + " не была создана \n");
        }
    }

    static void createFile(String path, String fileName) {
        File file = new File(path, fileName);
        try {
            if (file.createNewFile()) {
                stringBuilder.append(date + "  Файл " + fileName + " был создан в папке \n");
            } else {
                stringBuilder.append(date + "  Файл " + fileName + " не был создан в папке \n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void writeLog (String fileName){
        try(FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(String.valueOf(stringBuilder));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

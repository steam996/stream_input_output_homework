import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SaveAndPack {

    public static void main(String[] args) {
        GameProgress[] gameProgresses = {new GameProgress(85, 15, 15, 532.12),
                new GameProgress(43, 12, 19, 742.1),
                new GameProgress(67, 21, 21, 934.78)};
        String[] saveNames = new String[gameProgresses.length];
        for (int i = 0; i < gameProgresses.length; i++) {
            String saveName = "/home/user/Games/savegames/savegame" + i;
            saveGame(saveName, gameProgresses[i]);
            saveNames[i] = saveName;
        }
        zipFiles("/home/user/Games/savegames/savegames.zip", saveNames);


    }

    static void saveGame(String saveName, GameProgress progress) {
        try (FileOutputStream fos = new FileOutputStream(saveName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(progress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void zipFiles(String zipPath, String[] fileList) {

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipPath))) {
            for (String item : fileList) {
                zout.putNextEntry(new ZipEntry(new File(item).getName()));
                try (FileInputStream fis = new FileInputStream(item)) {
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();
                }
                new File(item).delete();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

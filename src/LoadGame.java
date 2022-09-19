import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class LoadGame {
    public static void main(String[] args) {
        openZip("/home/user/Games/savegames/savegames.zip", "/home/user/Games/savegames");
        System.out.println(openProgress("/home/user/Games/savegames/savegame1").toString());
    }
    static void openZip(String zipPath, String unzipPath){
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(zipPath))) {
            ZipEntry entry;
            String name;
            while ((entry = zis.getNextEntry())!= null){
                name = entry.getName();
                FileOutputStream fout = new FileOutputStream(unzipPath+"/"+name);
                for (int c = zis.read(); c != -1; c = zis.read()) {
                    fout.write(c);
                }
                fout.flush();
                zis.closeEntry();
                fout.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static GameProgress openProgress(String loadPath){
        GameProgress gameProgress;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadPath))){
            gameProgress = (GameProgress) ois.readObject();
            return gameProgress;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

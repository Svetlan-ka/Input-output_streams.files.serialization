import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    // ЗАДАНИЕ 2
    public static void saveGame(String pathnameFile, GameProgress gameProgress) {
        try (FileOutputStream save = new FileOutputStream(pathnameFile);
             ObjectOutputStream saveGame = new ObjectOutputStream(save)) {
            saveGame.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String nameZip, List<String> pathFiles) {
        File saveGamesDir = new File("D:/Java/homework_java-core/Games/savegames");
        File zipSaveFile = new File(saveGamesDir, nameZip);

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipSaveFile))) {

            for (File file : saveGamesDir.listFiles()) {
                if (!(file.getName().contains(".zip"))) {
                    pathFiles.add(file.getName());
                    file.deleteOnExit();
                }
            }

            for (String file : pathFiles) {
                ZipEntry entry = new ZipEntry(file);
                zos.putNextEntry(entry);
                zos.closeEntry();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // ЗАДАНИЕ 3

    public static void openZip(String nameZip, String pathnameFolder) {
        File zipDir = new File(pathnameFolder);
        File zipFile = new File(zipDir, nameZip);

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                FileOutputStream fos = new FileOutputStream(new File(pathnameFolder, "new" + entry.getName()));
                for (int c = zis.read(); c != -1; c = zis.read()) {
                    fos.write(c);
                }
                fos.flush();
                zis.closeEntry();
                fos.close();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static GameProgress openProgress(String pathnameFileSaveGame) {
        GameProgress gameProgress = null;

        try (FileInputStream fis = new FileInputStream(pathnameFileSaveGame);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return gameProgress;
    }
}
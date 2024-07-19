import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        // ЗАДАНИЕ 2
        GameProgress game_1 = new GameProgress(40, 23, 4, 35);
        GameProgress game_2 = new GameProgress(8, 56, 6, 149);
        GameProgress game_3 = new GameProgress(98, 100, 2, 7);

        GameProgress.saveGame("D:/Java/homework_java-core/Games/savegames/save1.dat", game_1);
        GameProgress.saveGame("D:/Java/homework_java-core/Games/savegames/save2.dat", game_2);
        GameProgress.saveGame("D:/Java/homework_java-core/Games/savegames/save3.dat", game_3);
        GameProgress.zipFiles("zipFilesGame.zip", new ArrayList<String>());

        // ЗАДАНИЕ 3
        GameProgress.openZip("zipFilesGame.zip",
                "D:/Java/homework_java-core/Games/savegames");

        System.out.println(GameProgress.openProgress("D:/Java/homework_java-core/Games/savegames/save2.dat"));

    }
}
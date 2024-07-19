import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder log = new StringBuilder();

        File src = new File("D:/Java/homework_java-core/Games/src");
        createDir(src, log);

        File res = new File("D:/Java/homework_java-core/Games/res");
        createDir(res, log);

        File savegames = new File("D:/Java/homework_java-core/Games/savegames");
        createDir(savegames, log);

        File temp = new File("D:/Java/homework_java-core/Games/temp");
        createDir(temp, log);

        File main = new File("D:/Java/homework_java-core/Games/src/main");
        createDir(main, log);

        File test = new File("D:/Java/homework_java-core/Games/src/test");
        createDir(test, log);

        File main_java = new File(main, "Main.java");
        createFile(main_java, log);

        File utils_java = new File(main, "Utils.java");
        createFile(utils_java, log);

        File drawables = new File("D:/Java/homework_java-core/Games/res/drawables");
        createDir(drawables, log);

        File vectors = new File("D:/Java/homework_java-core/Games/res/vectors");
        createDir(vectors, log);

        File icons = new File("D:/Java/homework_java-core/Games/res/icons");
        createDir(icons, log);

        File temp_txt = new File(temp, "temp.txt");
        createFile(temp_txt, log);

        try (FileWriter writer = new FileWriter(temp_txt)) {
            writer.write(String.valueOf(log));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createDir(File name, StringBuilder log) {
        if (name.mkdir()) {
            log.append("Каталог " + name + " успешно создан\n");
        } else {
            log.append("Ошибка при создании каталога " + name + "\n");
        }
    }

    public static void createFile(File name, StringBuilder log) throws IOException {
        try {
            if (name.createNewFile()) {
                log.append("Файл " + name + " успешно создан\n");
            } else {
                log.append("Ошибка при создании файла " + name + "\n");
            }
        } catch (IOException ex) {
            log.append(ex.getMessage());
        }
    }


}
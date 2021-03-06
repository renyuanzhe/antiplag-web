package cn.mooyyu.antiplagweb.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Objects;

@Component
public class CleanStaticFolder implements ApplicationRunner {
    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public void run(ApplicationArguments args) {
        final String folder = "static-file-folder/";
        final File root = new File(folder);
        if (!root.exists()) root.mkdir();
        File resource = new File(root, "resource");
        if (resource.exists()) deleteDir(resource);
        else resource.mkdir();
        File result = new File(root, "result");
        if (result.exists()) deleteDir(result);
        else result.mkdir();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void deleteDir(File root) {
        for (File dir : Objects.requireNonNull(root.listFiles())) {
            if (dir.isDirectory()) for (File file : Objects.requireNonNull(dir.listFiles())) {
                file.delete();
            }
            dir.delete();
        }
    }
}

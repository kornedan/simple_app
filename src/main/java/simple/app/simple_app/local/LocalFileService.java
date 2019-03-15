package simple.app.simple_app.local;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

@Component
public class LocalFileService {


    public static final Logger LOGGER = Logger.getLogger(LocalFile.class.getName());

    private LocalFileController localFileController;

    public LocalFileService(LocalFileController localFileController) {
        this.localFileController = localFileController;
    }

    public void addFile(MultipartFile file) throws IOException {
        Path path = Paths.get(localFileController.uploads + file.getOriginalFilename());
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
    }

    public void deleteFile(String file) {
        File file1ToDelete = new File(localFileController.uploads + file);
        if (file1ToDelete.exists())
            file1ToDelete.delete();
    }
}

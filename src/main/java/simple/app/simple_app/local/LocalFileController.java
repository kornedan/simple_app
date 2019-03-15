package simple.app.simple_app.local;

import org.springframework.core.io.Resource;

import org.springframework.core.io.UrlResource;

import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.servlet.ServletContext;

import java.io.File;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Path;

import java.nio.file.Paths;

import java.nio.file.StandardCopyOption;

import java.util.List;

import java.util.logging.Logger;

import java.util.stream.Collectors;

@Component
@RestController
@CrossOrigin
@RequestMapping("/api")
public class LocalFileController {

    public static final Logger LOGGER = Logger.getLogger(LocalFile.class.getName());

    ServletContext servletContext;
    String uploads;

    public LocalFileController(ServletContext servletContext) {
        this.servletContext = servletContext;
        createDirectory();
    }

    private void createDirectory() {
        uploads = servletContext.getRealPath("/uploads/");
        Path path = Paths.get(uploads);
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        LOGGER.info(uploads);
    }


    @GetMapping("/files")
    public List<LocalFile> getFiles() throws IOException {
        return Files.walk(Paths.get(uploads)).map(f -> {
            String fileDonloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/files/download/")
                    .path(f.getFileName().toString())
                    .toUriString();

            String fileDeleteUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/files/delete/")
                    .path(f.getFileName().toString())
                    .toUriString();

            return new LocalFile(
                    f.getFileName().toString(),
                    fileDonloadUri,
                    fileDeleteUri);
        }).collect(Collectors.toList());
    }

    @GetMapping("/files/download/{file}")
    public ResponseEntity<?> getFile(@PathVariable String file) throws IOException {
        Path path = Paths.get(uploads + file);

        Resource resource = new UrlResource(path.toUri());
        File targetFile = new File(uploads + file);
        String contentType = Files.probeContentType(path);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                /*  .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + targetFile.getName()
                  +"\"")*/
                .contentLength(targetFile.length())
                .body(resource);
    }


}

package Services_Repositories.File;

import Models.FileInfo;
import Services_Repositories.Interface.Repositories.CoachRepository;
import Services_Repositories.Interface.Repositories.CoursRepository;
import Services_Repositories.Interface.Service.FileService;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class FileServiceImpl implements FileService {
    private CoursRepository coursRepository;
    private CoachRepository coachRepository;

    public FileServiceImpl(CoursRepository coursRepository ,CoachRepository coachRepository ) {
       this.coursRepository = coursRepository;
       this.coachRepository = coachRepository;
    }

    @Override
    public void saveFileCoach(InputStream file, String originalFileName, String contentType, Long size) {
        FileInfo fileInfo = FileInfo.builder()
                .originalFileName(originalFileName)
                .storageFileName(UUID.randomUUID().toString())
                .type(contentType)
                .size(size)
                .build();
        try {
            Files.copy(file, Paths.get(
                    "/Users/danilmartemianov/IdeaProjects/SiteCourses/src/main/webapp/files/coaches/"
                    + fileInfo.getStorageFileName() + "." + fileInfo.getType().split("/")[1]));
            coachRepository.saveFileCoach(fileInfo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveFileCourses(InputStream file, String originalFileName, String contentType, Long size) {
        FileInfo fileInfo = FileInfo.builder()
                .originalFileName(originalFileName)
                .storageFileName(UUID.randomUUID().toString())
                .type(contentType)
                .size(size)
                .build();
        try {

            Files.copy(file, Paths.get(
                    "/Users/danilmartemianov/IdeaProjects/SiteCourses/src/main/webapp/files/courses/" +
                    fileInfo.getStorageFileName() + "." + fileInfo.getType().split("/")[1]));
            coursRepository.saveFileCourses(fileInfo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

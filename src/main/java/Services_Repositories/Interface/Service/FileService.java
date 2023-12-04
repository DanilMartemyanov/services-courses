package Services_Repositories.Interface.Service;

import java.io.InputStream;

public interface FileService {

    void saveFileCourses(InputStream file, String originalFileName, String contentType, Long size );
    void saveFileCoach(InputStream file, String originalFileName, String contentType, Long size );

}

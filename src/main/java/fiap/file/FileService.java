package fiap.file;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public interface FileService {

		String uploadFile(MultipartFile file);
}

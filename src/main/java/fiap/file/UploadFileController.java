package fiap.file;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/api/file")
public class UploadFileController {
	
	@Autowired
	private AWSS3Service awsS3Service;
	
	@PostMapping(path = "/api/file")
	public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file,
														@RequestBody FileEntity fileEntity) {
		String publicURL = awsS3Service.uploadFile(file);
		Map<String, String> response = new HashMap<>();
		response.put("publicURL", publicURL);
		return new ResponseEntity<Map<String, String>>(response, HttpStatus.CREATED);
	}
}
//to do 
//procurar metodo pra converter a string jwt em objeto jwt e
//a partir do objeto jwt dando get de subject pesquisar o owner.
//associar o doc ao owner.
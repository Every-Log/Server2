package tteokbokki.everylog.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {
    // 파일 경로
    @Value("${file.dir}/")
    private String fileDirPath;

    // 확장자 추출
    private String extractExt(String originalFilename) {
        int idx = originalFilename.lastIndexOf(".");
        String ext = originalFilename.substring(idx);
        return ext;
    }

    // 저장할 파일 이름 구성
    // 파일의 이름은 겹칠 수 있기에 파일의 이름이 겹치지 않게 UUID를 통해 설정
    // 확장자를 추출하는 메소드를 통해 확장자를 추출하여 UUID 뒤에 붙여 출력하는 것을 구현
    private String createStoreFilename(String originalFilename) {
        String uuid = UUID.randomUUID().toString();
        String ext = extractExt(originalFilename);
        String storeFilename = uuid + ext;

        return storeFilename;
    }

    //파일을 실제로 저장하기 위해 경로를 구성하는 부분
    public String createPath(String storeFilename) {
        String viaPath = "images/";
        return fileDirPath+viaPath+storeFilename;
    }

    // 파일을 실제로 저장하는 부분
    public Image storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename();
        String storeFilename = createStoreFilename(originalFilename);
        multipartFile.transferTo(new File(createPath(storeFilename)));

        return Image.builder()
                .originFileName(originalFilename)
                .storePath(storeFilename)
                .build();

    }

    public List<Image> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<Image> imageList = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                imageList.add(storeFile(multipartFile));
            }
        }

        return imageList;
    }
}


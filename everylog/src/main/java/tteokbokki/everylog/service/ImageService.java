package tteokbokki.everylog.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tteokbokki.everylog.domain.FileStore;
import tteokbokki.everylog.domain.Image;
import tteokbokki.everylog.repository.ImageRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final FileStore fileStore;

    public List<Image> saveImages(List<MultipartFile> multipartFileList) throws IOException {
        List<Image> imageFiles = fileStore.storeFiles(multipartFileList);

        return imageFiles;
    }

    public List<Image> findImages() {
        List<Image> images = imageRepository.findAll();
        return images;
    }
}

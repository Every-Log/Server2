package tteokbokki.everylog.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.domain.Image;
import tteokbokki.everylog.dto.ImageDto;
import tteokbokki.everylog.repository.ImageRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImageService {
        private final ImageRepository imageRepository;

        /**
         * 이미지 개별 조회
         */
        @Transactional(readOnly = true)
        public ImageDto findByFileId(Long id){

            Image entity = imageRepository.findById(id).orElseThrow(()
                    -> new IllegalArgumentException("해당 파일이 존재하지 않습니다."));

            ImageDto imageDto = ImageDto.builder()
                    .origFileName(entity.getOrigFileName())
                    .filePath(entity.getFilePath())
                    .fileSize(entity.getFileSize())
                    .build();

            return imageDto;
        }

        /**
         * 이미지 전체 조회
         */
//        @Transactional(readOnly = true)
//        public List<PhotoResponseDto> findAllByBoard(Long boardId){
//
//            List<Image> photoList = ImageRepository.findAllByPostId(boardId);
//
//            return photoList.stream()
//                    .map(PhotoResponseDto::new)
//                    .collect(Collectors.toList());
//        }
}

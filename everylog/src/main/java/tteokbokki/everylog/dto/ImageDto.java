package tteokbokki.everylog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tteokbokki.everylog.domain.Image;

@Getter
@NoArgsConstructor
public class ImageDto {

    private String origFileName;
    private String filePath;
    private Long fileSize;

    @Builder
    public ImageDto(String origFileName, String filePath, Long fileSize) {
        this.origFileName= origFileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }
}

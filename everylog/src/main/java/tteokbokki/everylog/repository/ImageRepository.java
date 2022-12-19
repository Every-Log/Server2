package tteokbokki.everylog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tteokbokki.everylog.domain.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}

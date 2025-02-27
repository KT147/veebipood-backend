package ee.kevin.veebipood_backend.repository;

import ee.kevin.veebipood_backend.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

// faili nimi pole oluline. see kellele me seda repository teeme on määratud
// JPARepository <KLASS, PRIMAARVÕTI>
public interface PictureRepository extends JpaRepository<Picture, Long> {
}

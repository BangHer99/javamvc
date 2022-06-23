package santri.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import santri.entity.NamaSantri;

public interface SantriRepo extends CrudRepository<NamaSantri, Long> {
    List<NamaSantri> findByNamaContains(String keyword);
}

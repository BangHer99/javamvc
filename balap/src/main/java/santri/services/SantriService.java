package santri.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import santri.entity.NamaSantri;
import santri.repository.SantriRepo;

@Service
@Transactional
public class SantriService {

    @Autowired
    private SantriRepo santriRepo;

    public Iterable<NamaSantri> findAll() {
        return santriRepo.findAll();
    }

    public void addSantri(NamaSantri namaSantri) {
        santriRepo.save(namaSantri);
    }

    public void deleteById(Long id) {
        santriRepo.deleteById(id);
    }

    public Optional<NamaSantri> findById(long id) {
        return santriRepo.findById(id);

    }

    public void updateSantri(NamaSantri namaSantri) {
        santriRepo.save(namaSantri);
    }

    public List<NamaSantri> findByName(String keyword) {
        return santriRepo.findByNamaContains(keyword);
    }
}

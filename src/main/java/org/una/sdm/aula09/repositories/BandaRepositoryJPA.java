package org.una.sdm.aula09.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.sdm.aula09.domain.Banda;

@Repository
public interface BandaRepositoryJPA extends JpaRepository<Banda, Long> {


}

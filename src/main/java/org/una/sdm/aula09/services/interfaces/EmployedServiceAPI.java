package org.una.sdm.aula09.services.interfaces;

import org.una.sdm.aula09.domain.Employed;
import org.una.sdm.aula09.domain.User;

import java.util.List;

public interface EmployedServiceAPI {

    public Employed get(Long id);

    public List<Employed> findAll();

    public Employed create(Employed employed);

    public void update(Employed employed);

    public void remove(Long id);
}

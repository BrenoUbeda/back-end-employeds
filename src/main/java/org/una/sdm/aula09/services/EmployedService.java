package org.una.sdm.aula09.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.sdm.aula09.domain.Employed;
import org.una.sdm.aula09.domain.User;
import org.una.sdm.aula09.exceptions.UserNotFoundException;
import org.una.sdm.aula09.repositories.EmployedRepositoryJPA;
import org.una.sdm.aula09.repositories.UserRepositoryJPA;
import org.una.sdm.aula09.services.interfaces.EmployedServiceAPI;
import org.una.sdm.aula09.services.interfaces.UserServiceAPI;

import java.util.List;

@Service
public class EmployedService implements EmployedServiceAPI {

    @Autowired
    private EmployedRepositoryJPA repositoryJPA;

    @Transactional(readOnly = true)
    public Employed get(Long id){

        try {
            Employed employed = repositoryJPA.findById(id).get();
            return employed;
        } catch (Exception ex) {
            throw new UserNotFoundException(String.format("Não existe um funcionário com esse id: %s ", id));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employed> findAll() {

        return repositoryJPA.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Employed create(Employed Employed) {
        if(Employed.getName() == null) {
            throw new RuntimeException("Nome é obrigatório!");
        }
        return repositoryJPA.save(Employed);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Employed Employed) {
        repositoryJPA.save(Employed);
    }

    @Override
    @Transactional(readOnly = false)
    public void remove(Long id) {
        repositoryJPA.deleteById(id);
    }

}

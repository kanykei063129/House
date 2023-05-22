package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.exception.MyException;
import peaksoft.repository.AgencyRepository;

import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class AgencyRepositoryImpl implements AgencyRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Autowired
    public AgencyRepositoryImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public void saveAgency(Agency agency) {
    entityManager.persist(agency);
    }

    @Override
    public List<Agency> getAllAgency() {
        return entityManager.createQuery("select a from Agency a",Agency.class).getResultList();
    }

    @Override
    public Agency getAgencyById(Long id) {
        try {
            boolean is = false;
            for (Agency a:getAllAgency()) {
                if (Objects.equals(a.getId(),id)){
                    is = true;
                }
            }
            if (is){
                return entityManager.createQuery("select a from Agency a where a.id=id",Agency.class).setParameter("id",id).getSingleResult();
            }else {
                throw new MyException(id + " not found");
            }
        }catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateAgencyById(Long id, Agency agency) {
        try {
            boolean is = false;
            for (Agency a : getAllAgency()) {
                if (Objects.equals(a.getId(), agency)) {
                    is = true;
                }
            }
            if (is) {
                Agency agency1 = entityManager.find(Agency.class, id);
                agency1.setName(agency.getName());
                agency1.setCountry(agency.getCountry());
                agency1.setPhoneNumber(agency.getPhoneNumber());
                agency1.setEmail(agency.getEmail());
                agency1.setImageLink(agency.getImageLink());
                entityManager.merge(agency1);
            } else {
                throw new MyException(id + " not found");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void deleteById(long id) {
    try {
        boolean is = false;
        for (Agency a:getAllAgency()) {
            if (Objects.equals(a.getId(),id)){
                is = true;
            }
            if (is){
                entityManager.createQuery("select a from Agency a where a.id=:id",Agency.class).getSingleResult();
            }else {
                throw  new MyException(id + " not found");
            }
        }
    }catch (MyException e){
        System.out.println(e.getMessage());
    }
    }
}

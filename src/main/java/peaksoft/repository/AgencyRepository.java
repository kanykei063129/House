package peaksoft.repository;

import peaksoft.entity.Agency;

import java.util.List;

public interface AgencyRepository {
    void saveAgency(Agency agency);
    List<Agency> getAllAgency();
    Agency getAgencyById(Long id);
    void updateAgencyById(Long id,Agency agency);
    void deleteById(long id);
}

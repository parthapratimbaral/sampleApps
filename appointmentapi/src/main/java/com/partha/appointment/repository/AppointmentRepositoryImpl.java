package com.partha.appointment.repository;

import com.partha.appointment.entities.Appointment;
import com.partha.appointment.utility.UtilityConstant;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * User: Partha Pratim Baral
 * Topic :
 * Date: 5/18/2023
 */
public class AppointmentRepositoryImpl implements AppointmentRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public <S extends Appointment> S save(S entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public List<Appointment> findAll() {
        Query q = (Query) em.createNamedQuery(UtilityConstant.SELECT_ALL_APPOINTMENTS, Appointment.class);
        List<Appointment> drList = ((Query) q).getResultList();
        return drList;
    }

    @SuppressWarnings("unchecked")
    public List<Appointment> find(String queryName, String queryParam, Object queryValue, String operands) {

        Query q = null;
        List<Appointment> drList = null;
        if (queryParam.equals("appointmentId")) {
            q = (Query) em.createNamedQuery(queryName, Appointment.class);
            ((Query) q).setParameter(queryParam, Integer.parseInt(queryValue.toString()));
            drList = ((Query) q).getResultList();
        }
        if (queryParam.equals("doctorName")) {
            q = (Query) em.createNamedQuery(queryName, Appointment.class);
            ((Query) q).setParameter(queryParam, "%"+queryValue+ "%");
            drList = ((Query) q).getResultList();
        }
        if (queryParam.equals("status")) {
            q = (Query) em.createNamedQuery(queryName, Appointment.class);
            ((Query) q).setParameter(queryParam, "%" + queryValue + "%");
            drList = ((Query) q).getResultList();
        }if (queryParam.equals("sortedby")) {
            q = (Query) em.createQuery("SELECT a FROM Appointment a ORDER BY "+queryValue+"");
            drList = ((Query) q).getResultList();
        }
        return drList;
    }

    @Override
    public List<Appointment> findByUserSearchAndSorted(String type, List<String> queryParam, List<Object> queryValue) {
        List<Appointment> drList = null;
        if(type.equals("sortedby")) {
            String USER_NAME = queryParam.get(0);
            String SORT_BY = queryParam.get(1);
            String USER_NAME_VALUE = queryValue.get(0).toString();
            String SORT_BY_VALUE = queryValue.get(1).toString();

            String QueryString = "";
            if (SORT_BY_VALUE.equals("PATIENT_NAME"))
                QueryString = "SELECT a FROM Appointment a where a.doctorName LIKE :doctorName ORDER BY a.patientName";
            if (SORT_BY_VALUE.equals("APPOINTMENT_DATE"))
                QueryString = "SELECT a FROM Appointment a where a.doctorName LIKE :doctorName ORDER BY a.appointmentDate";
            if (SORT_BY_VALUE.equals("APPOINTMENT_STATUS"))
                QueryString = "SELECT a FROM Appointment a where a.doctorName LIKE :doctorName ORDER BY a.status";

            Query q = null;
            q = (Query) em.createQuery(QueryString);
            ((Query) q).setParameter("doctorName", "%" + USER_NAME_VALUE + "%");
            drList = ((Query) q).getResultList();
            //return drList;
        }
        else if(type.equals("searchby")){
            String USER_NAME = queryParam.get(0);
            String SEARCH_BY = queryParam.get(1);
            String SEARCH_STRING = queryParam.get(2);
            String USER_NAME_VALUE = queryValue.get(0).toString();
            String SEARCH_BY_VALUE = queryValue.get(1).toString();
            String SEARCH_STRING_VALUE = queryValue.get(2).toString();

            String QueryString = "";
            if (SEARCH_BY_VALUE.equals("PATIENT"))
                QueryString = "SELECT a FROM Appointment a where a.doctorName LIKE :doctorName AND a.patientName LIKE :patientName";
           /* if (SEARCH_BY_VALUE.equals("APPOINTMENT_DATE"))
                QueryString = "SELECT a FROM Appointment a where a.doctorName LIKE :doctorName ORDER BY a.appointmentDate";
            if (SEARCH_BY_VALUE.equals("APPOINTMENT_STATUS"))
                QueryString = "SELECT a FROM Appointment a where a.doctorName LIKE :doctorName ORDER BY a.status";*/

            Query q = null;
            q = (Query) em.createQuery(QueryString);
            ((Query) q).setParameter("doctorName", "%" + USER_NAME_VALUE + "%");
            ((Query) q).setParameter("patientName", "%" + SEARCH_STRING_VALUE + "%");
            drList = ((Query) q).getResultList();
        }
        return drList;
    }

    @Override
    public void deleteById(String queryName, String queryParam, Object queryValue, String operands) {
        List<Appointment> drList = null;
        Query q = (Query) em.createNamedQuery(queryName, Appointment.class);
        ((Query) q).setParameter(queryParam, "%" + queryValue + "%");
        drList = ((Query) q).getResultList();
    }

    @Override
    public Optional<Appointment> findById(Integer appointmentId) {
        Appointment appointment = (Appointment) em.find(Appointment.class, appointmentId);
        return Optional.ofNullable(appointment);
    }

    @Override
    public void delete(Appointment entity) {
        em.remove(entity);
    }

    @Override
    public <S extends Appointment> S saveAndFlush(S entity){
        em.persist(entity);
        em.flush();
        return entity;
    }

    @Override
    public List<Appointment> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Appointment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Appointment> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Appointment> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Appointment> List<S> saveAll(Iterable<S> entities) {
        return null;
    }



    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }



    @Override
    public <S extends Appointment> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Appointment> entities) {
        AppointmentRepository.super.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Appointment> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Appointment getOne(Integer integer) {
        return null;
    }

    @Override
    public Appointment getById(Integer integer) {
        return null;
    }

    @Override
    public Appointment getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Appointment> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Appointment> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Appointment> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Appointment> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Appointment> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Appointment> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Appointment, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}

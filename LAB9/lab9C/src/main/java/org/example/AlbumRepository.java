package org.example;

import org.example.Album;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class AlbumRepository {
    private EntityManagerFactory emf;

    public AlbumRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(Album album) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            em.persist(album);
            //et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    public Album findById(Long id) throws EntityNotFoundException {
        EntityManager em = emf.createEntityManager();
        Album album = em.find(Album.class, id);
        if (album == null) throw new EntityNotFoundException("Album with id " + id + " not found.");
        em.close();
        return album;
    }

    @SuppressWarnings("unchecked")
    public List<Album> findByName(String namePattern) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Album.findByName");
        query.setParameter("namePattern", "%" + namePattern + "%");
        List<Album> albums = query.getResultList();
        em.close();
        return albums;
    }
}

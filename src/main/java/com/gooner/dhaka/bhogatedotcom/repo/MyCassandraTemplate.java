package com.gooner.dhaka.bhogatedotcom.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyCassandraTemplate {


        @Autowired
        private CassandraOperations cassandraTemplate;

        /**
         * MyCassandraTemplate Default constructor
         */
        public MyCassandraTemplate() {
            System.out.println("MyCassandraTemplate()");
        }

        public <T> void create(T entity) {
            cassandraTemplate.insert(entity);
        }

        public <T> void updateVideo(T video, Class<T> claz){
            cassandraTemplate.update(video);
        }

        public <T> List<T> findAll(Class<T> claz) {
            return cassandraTemplate.select("SELECT * FROM videos;",claz);
        }

        public <T> T findById(Object id, Class<T> claz) {
            return cassandraTemplate.selectOneById(id,claz);
        }

        public <T> boolean checkIfExistsById(Object id, Class<T> claz){
            return cassandraTemplate.exists(id,claz);
        }

        public <T> boolean deleteVideoById(Object id, Class<T> claz){
            return cassandraTemplate.deleteById(id, claz);
        }

        public <T> void deleteVideo(T video){
            cassandraTemplate.delete(video);
        }

}

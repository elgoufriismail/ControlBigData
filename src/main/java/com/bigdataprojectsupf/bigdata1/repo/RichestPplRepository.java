package com.bigdataprojectsupf.bigdata1.repo;

import java.util.UUID;

import org.springframework.data.cassandra.repository.MapIdCassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.bigdataprojectsupf.bigdata1.entity.RichestPpl;

public interface RichestPplRepository extends MapIdCassandraRepository<RichestPpl>{

    @Query("delete from richestppl where id = ?0")
    void deleteById(UUID id);

    @Query("select * from richestppl where id = ?0")
    RichestPpl findById(UUID id);
}

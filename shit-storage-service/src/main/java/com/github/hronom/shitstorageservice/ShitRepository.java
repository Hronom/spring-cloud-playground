package com.github.hronom.shitstorageservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ShitRepository extends JpaRepository<Shit, Long> {
    @RestResource(path = "by-source")
    Collection<String> findBySource(@Param("s") String s);
}

package com.sscvocab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sscvocab.model.Fillblank;
@Repository
public interface FillblankRepo extends JpaRepository<Fillblank, Integer> {

}

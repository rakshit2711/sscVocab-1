package com.sscvocab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sscvocab.model.Collectnoun;
@Repository
public interface CollectnounRepo extends JpaRepository<Collectnoun, Integer> {

}

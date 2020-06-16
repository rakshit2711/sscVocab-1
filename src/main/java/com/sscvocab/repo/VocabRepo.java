package com.sscvocab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sscvocab.model.Vocab;
@Repository
public interface VocabRepo extends JpaRepository<Vocab, Integer> {


}

package com.iquery.repository;

import com.iquery.model.Bug;
import com.iquery.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("bugRepository")
public interface BugRepository extends CrudRepository<Bug, Long> {
    Bug findByAssignee(User assignee);
}
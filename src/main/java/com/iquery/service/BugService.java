package com.iquery.service;

import com.iquery.model.Bug;
import com.iquery.model.User;
import com.iquery.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("bugService")
public class BugService {

    private BugRepository bugRepository;

    @Autowired
    public BugService(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    public Bug findByAssignee(User assignee) {
        return bugRepository.findByAssignee(assignee);
    }

    public void saveBug(Bug bug) {
        bugRepository.save(bug);
    }
}

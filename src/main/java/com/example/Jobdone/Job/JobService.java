package com.example.Jobdone.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void create(Job job);

    Job getJobById(long id);

    boolean deleteJobById(long id);

    boolean updatedJob(long id, Job updatedJob);
}

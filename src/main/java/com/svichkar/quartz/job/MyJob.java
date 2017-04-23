package com.svichkar.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by svichkar on 4/22/17.
 */
public class MyJob implements Job
{
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException
  {
    System.err.println("Hello World!  MyJob is executing.");
  }
}

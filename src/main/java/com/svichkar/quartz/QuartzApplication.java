package com.svichkar.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import com.svichkar.quartz.job.MyJob;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by svichkar on 4/22/17.
 */
public class QuartzApplication
{
  public static void main(String... strings) throws Exception
  {
    new Thread(new Runnable()
    {
      public void run()
      {

        Scheduler scheduler = null;
        try
        {
          scheduler = StdSchedulerFactory.getDefaultScheduler();
          scheduler.start();
        }
        catch (SchedulerException e)
        {
          e.printStackTrace();
        }

        JobDetail job = newJob(MyJob.class)
            .withIdentity("job1", "group1")
            .build();

        Trigger trigger = newTrigger()
            .withIdentity("trigger1", "group1")
            .startNow()
            .withSchedule(simpleSchedule()
                .withIntervalInSeconds(40)
                .repeatForever())
            .build();

        try
        {
          scheduler.scheduleJob(job, trigger);
        }
        catch (SchedulerException e)
        {
          e.printStackTrace();
        }
      }
    }).run();

  }
}

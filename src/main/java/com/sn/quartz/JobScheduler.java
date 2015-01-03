package com.sn.quartz;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sn.entity.Post;
import com.sn.service.PostService;

@Component("jobScheduler")
public class JobScheduler  {
	@Autowired
	PostService postService;
	
	Logger LOGGER = Logger.getLogger(JobScheduler.class);
	
	public void schedule(Post post){

		LOGGER.info("Init Scheduler.....");
		Scheduler scheduler = null;
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
				JobDataMap jobDataMap = new JobDataMap();
				jobDataMap.put("post",post);

				JobDetail job = new JobDetail();
				job.setName("job-"+post.getId());
				job.setJobClass(ScheduledPostExecutor.class);
				job.setGroup("scheduledPosts");
				job.setJobDataMap(jobDataMap);

				//configure the scheduler time
				SimpleTrigger trigger = new SimpleTrigger();
				trigger.setName("trigger-"+post.getId());
				trigger.setRepeatCount(1);
				trigger.setRepeatInterval(5000);
				trigger.setStartTime(post.getScheduledDate().getTime());
				scheduler.scheduleJob(job, trigger);	
				scheduler.start();
//				LOGGER.info("Scheduling Job with details : Job Name - "+jobConfig.getJobName()+" Cron Expression - "+jobConfig.getCronExpression());
		} catch (SchedulerException e) {
			LOGGER.error("Error while scheduling..."+e);
		}
	}
	
	public void init(){
		LOGGER.info("Init Scheduler.....");
		Scheduler scheduler = null;
//		PostService postService = new PostServiceImpl();
		List<Post> scheduledPosts = postService.getScheduledPosts();
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
			for(Post post : scheduledPosts){
				JobDataMap jobDataMap = new JobDataMap();
				jobDataMap.put("post",post);

				JobDetail job = new JobDetail();
				job.setName("job-"+post.getId());
				job.setJobClass(ScheduledPostExecutor.class);
				job.setGroup("scheduledPosts");
				job.setJobDataMap(jobDataMap);

				//configure the scheduler time
				SimpleTrigger trigger = new SimpleTrigger();
				trigger.setName("trigger-"+post.getId());
				trigger.setRepeatCount(1);
				trigger.setRepeatInterval(5000);
				trigger.setStartTime(post.getScheduledDate().getTime());
				scheduler.scheduleJob(job, trigger);	
				scheduler.start();
			}
		} catch (SchedulerException e) {
			LOGGER.error("Error while scheduling..."+e);
		}
	}
	
	public static void main(String args[]){
		JobScheduler jobScheduler = new JobScheduler();
		jobScheduler.init();
	}
}
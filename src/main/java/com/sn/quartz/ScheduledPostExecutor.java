package com.sn.quartz;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;

import com.sn.entity.Post;
import com.sn.service.PostService;
import com.sn.service.impl.PostServiceImpl;

public class ScheduledPostExecutor implements Job{
//	@Autowired
	PostService postService = new PostServiceImpl();

	Logger LOGGER = Logger.getLogger(ScheduledPostExecutor.class);

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		JobDataMap jobdata = context.getJobDetail().getJobDataMap();
		LOGGER.info("Executing Job "+context.getJobDetail().getName());
		Post post = (Post) jobdata.get("post");
		postService.submitScheduledPost(jobdata.get("post"));
		try {
			context.getScheduler().deleteJob("job-"+post.getId(), "scheduledPosts");
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}

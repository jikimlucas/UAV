package org.qcri.micromappers.uav.batch.scheduler;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UAVScheduler {
	private static Logger logger = Logger.getLogger(UAVScheduler.class);

	@Autowired
	private JobLauncher launcher;

	@Autowired
	private Job job;
	
	private JobExecution execution;
	
	public void run(){
		try {
			logger.info("\n\nSchedular started at " + new Date()+"\n\n");
			execution = launcher.run(job, new JobParameters());
			logger.info("Execution status: " + execution.getStatus());
		} catch (JobExecutionAlreadyRunningException e1) {
			logger.error("JobExecutionAlreadyRunningException: " + e1);
		} catch (JobRestartException e2) {
			logger.error("JobRestartException: " + e2);
		} catch (JobInstanceAlreadyCompleteException e3) {
			logger.error("JobInstanceAlreadyCompleteException: " + e3);
		} catch (JobParametersInvalidException e4) {
			logger.error("JobParametersInvalidException: " + e4);
		}

	}
}

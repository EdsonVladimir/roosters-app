package util.common;

import javax.enterprise.context.Dependent;


@Dependent
public class BatchUtil   {
	
	/*
	public String getStatus(Long executionId){
		String result = null;
		try {
			result = BatchRuntime.getJobOperator().getJobExecution(executionId).getBatchStatus().toString();
			System.out.println("Batch Satus: " + result);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}
	
	
	public Long startJob(String jobName, Properties properties){
		Long result = null;
		try {
			result = BatchRuntime.getJobOperator().start(jobName, properties);
			System.out.println("Starting Batch with id: " + result);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public Long restart(Long executionId, Properties properties){
		System.out.println("ReStarting Batch with id: " + executionId);
		return BatchRuntime.getJobOperator().restart(executionId, properties);	
	}
	
	
	public void stop(Long executionId){
		System.out.println("Stoping Batch with id: " + executionId);
		BatchRuntime.getJobOperator().stop(executionId);	
	}
	*/
	

}

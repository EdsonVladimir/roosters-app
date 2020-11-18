package util.constant;


/* StackDriver LogLevel
DEFAULT		  (0) The log entry has no assigned severity level.
DEBUG		(100) Debug or trace information.
INFO		(200) Routine information, such as ongoing status or performance.
NOTICE		(300) Normal but significant events, such as start up, shut down, or a configuration change.
WARNING		(400) Warning events might cause problems.
ERROR		(500) Error events are likely to cause problems.
CRITICAL	(600) Critical events cause more severe problems or outages.
ALERT		(700) A person must take an action immediately.
EMERGENCY	(800) One or more systems are unusable.
*/	

/* Log4J LogLevel
OFF			  (0) - 
FATAL		(100) - 
ERROR		(200) - 
WARN		(300) - 
INFO		(400) -  
DEBUG		(500) - 
TRACE		(600) - 
ALL			(Integer.MAX_VALUE) - 
*/

/* Loggin LogLevel
OFF			(Integer.MAX_VALUE) - OFF is a special level that can be used to turn off logging.
SEVERE		(1000) - SEVERE is a message level indicating a serious failure.
WARNING		(900) - WARNING is a message level indicating a potential problem.
INFO		(800) - INFO is a message level for informational messages.
CONFIG		(700) - CONFIG is a message level for static configuration messages.
FINE		(500) - FINE is a message level providing tracing information.
FINER		(400) - FINER indicates a fairly detailed tracing message.
FINEST		(300) - FINEST indicates a highly detailed tracing message.
ALL			(Integer.MIN_VALUE) - ALL indicates that all messages should be logged.
*/


public enum SystemLogLevel {
	DEFAULT, DEBUG, INFO, NOTICE, WARNING, ERROR, CRITICAL, ALERT, EMERGENCY
}


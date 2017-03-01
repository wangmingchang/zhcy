package com.wmc.common;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogUtil {
	private static final Level INFO;
	private static final Level DEBUG;
	private static final Level WARN;
	private static final Level ERROR;
	private static final Level ALARM;
	public static Logger logger = Logger.getLogger("com");

	static {
		INFO = Level.INFO;
		DEBUG = Level.DEBUG;
		WARN = Level.WARN;
		ERROR = Level.ERROR;
		ALARM = Level.FATAL;
	}
	public LogUtil() {}

	private static void printLog(String logMessage, Level errorLevel,
			Throwable e) {
		try {
			StringBuffer sbLog = new StringBuffer();
			sbLog.append("\u3010\u7EBF\u7A0B\u7F16\u53F7\uFF1A");
			sbLog.append(Thread.currentThread().getName());
			sbLog.append("\u3011");
			if (errorLevel == null || errorLevel == INFO) {
				errorLevel = INFO;
				sbLog.append("\u3010\u4FE1\u606F\u3011");
			} else if (errorLevel == DEBUG)
				sbLog.append("\u3010\u8C03\u8BD5\u3011");
			else if (errorLevel == WARN)
				sbLog.append("\u3010\u8B66\u544A\u3011");
			else if (errorLevel == ERROR)
				sbLog.append("\u3010\u9519\u8BEF\u3011");
			else if (errorLevel == ALARM)
				sbLog.append("\u3010\u4E25\u91CD\u9519\u8BEF\u3011");
			sbLog.append(logMessage);
			logMessage.indexOf("org.hibernate.ObjectNotFoundException");
			logger.log(errorLevel, sbLog.toString(), e);
		} catch (Exception ex) {
			logger.error((new StringBuilder(
					"\u8BB0\u5F55\u65E5\u5FD7\u65F6\u53D1\u751F\u4EE5\u4E0B\u9519\u8BEF\uFF1A"))
					.append(ex.getMessage()).toString());
		}
	}

	public static void error(Object object) {
		error(object, null);
	}

	public static void error(Object object, Throwable t) {
		if (object != null)
			printLog(object.toString(), ERROR, t);
		else
			printLog("null", ERROR, t);
	}

	public static void debug(Object object) {
		debug(object.toString(), null);
	}

	public static void debug(Object object, Throwable t) {
		if (object != null)
			printLog(object.toString(), DEBUG, t);
		else
			printLog("null", DEBUG, t);
	}

	public static void info(Object object) {
		info(object, null);
	}

	public static void info(Object object, Throwable t) {
		if (object != null)
			printLog(object.toString(), INFO, t);
		else
			printLog("null", INFO, t);
	}

	public static void warn(Object object) {
		warn(object, null);
	}

	public static void warn(Object object, Throwable t) {
		if (object != null)
			printLog(object.toString(), WARN, t);
		else
			printLog("null", WARN, t);
	}

	public static void alerm(Object object) {
		alerm(object, null);
	}

	public static void alerm(Object object, Throwable t) {
		if (object != null)
			printLog(object.toString(), ALARM, t);
		else
			printLog("null", ALARM, t);
	}

	public static boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	public static boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	public static boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	public static String stackTraceToString(Exception e) {
		StringBuffer buffOut = new StringBuffer();
		buffOut.append("\n").append(e.getMessage()).append("\n");
		StackTraceElement trace[] = e.getStackTrace();
		for (int i = 0; i < trace.length; i++)
			buffOut.append("\tat ").append(trace[i]).append("\n");

		Throwable ourCause = e.getCause();
		if (ourCause != null)
			logStackTraceAsCause(trace, ourCause, buffOut);
		return buffOut.toString();
	}

	private static void logStackTraceAsCause(StackTraceElement causedTrace[],
			Throwable e, StringBuffer buffOut) {
		StackTraceElement trace[] = e.getStackTrace();
		buffOut.append("\nCaused by: ").append(e.getMessage()).append("\n");
		int m = trace.length - 1;
		for (int n = causedTrace.length - 1; m >= 0 && n >= 0
				&& trace[m].equals(causedTrace[n]); n--)
			m--;

		int framesInCommon = trace.length - 1 - m;
		for (int i = 0; i <= m; i++)
			buffOut.append("\tat ").append(trace[i]).append("\n");

		if (framesInCommon != 0)
			buffOut.append("\t... ").append(framesInCommon).append(" more \n");
		Throwable ourCause = e.getCause();
		if (ourCause != null)
			logStackTraceAsCause(trace, ourCause, buffOut);
	}


}

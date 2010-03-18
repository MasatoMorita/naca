/*
 * JLib - Publicitas Java library v1.2.0.
 *
 * Copyright (c) 2005, 2006, 2007, 2008, 2009 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/*
 * JLib - Publicitas Java library.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package jlib.log;

import jlib.misc.StringUtil;

/*
 * Created on 12 mai 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author PJD
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PatternLayoutConsole extends LogPatternLayout
{
	public PatternLayoutConsole(String csFormat)
	{
		super();
		m_csFormat = csFormat;
	}
	
	String getMessage(LogParams logParams)
	{
		return logParams.getMessage();
	}
	
	String format(LogParams logParams, int n)
	{
		String cs = m_csFormat;
		if(m_csFormat.indexOf("%SourceFile") >= 0)
		{
			StackTraceElement stackElem = logParams.m_caller;
			if(stackElem != null)
			{
				String csFile = stackElem.getFileName();
				if(csFile != null)
					csFile = csFile + "(" + stackElem.getLineNumber() + ")";
				cs = StringUtil.replace(cs, "%SourceFile", csFile, true);
			}
			else
				cs = StringUtil.replace(cs, "%SourceFile", "[Unknown SourceFile] ", true);
		}
		cs = StringUtil.replace(cs, "%Message", logParams.toStringNoEvent(), true);
		cs = StringUtil.replace(cs, "%ThreadName", logParams.getThreadName(), true);
		cs = StringUtil.replace(cs, "%ThreadId", logParams.getThreadId(), true);
		cs = StringUtil.replace(cs, "%StartTime", logParams.getStartTime(), true);
		cs = StringUtil.replace(cs, "%Timestamp", logParams.getDisplayTimestamp(), true);
		cs = StringUtil.replace(cs, "%CR", "\n", true);
		cs = StringUtil.replace(cs, "%LF", "\r", true);
		return cs;
	}
	
	int getNbLoop(LogParams logParams)
	{
		return 1;
	}
	
	private String m_csFormat = null;
}

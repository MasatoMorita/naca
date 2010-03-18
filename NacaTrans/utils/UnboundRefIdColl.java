/*
 * NacaTrans - Naca Transcoder v1.2.0.
 *
 * Copyright (c) 2008-2009 Publicitas SA.
 * Licensed under GPL (GPL-LICENSE.txt) license.
 */
/*
 * NacaRTTests - Naca Tests for NacaRT support.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under GPL (GPL-LICENSE.txt) license.
 */
/**
 * 
 */
package utils;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author Pierre-Jean Ditscheid, Consultas SA
 * @version $Id$
 */
public class UnboundRefIdColl
{
	UnboundRefIdColl()
	{
	}
	
	UnboundRefId find(String csName)
	{
		return m_hash.get(csName);
	}
	
	void add(int nLine, String csName, String csFile)
	{
		UnboundRefId ref = new UnboundRefId(nLine, csFile); 
		m_hash.put(csName, ref);
	}
	
	Enumeration<String> getKeys()
	{
		return m_hash.keys();
	}
	
	UnboundRefId getVal(String csName)
	{
		return m_hash.get(csName);
	}
	
	Hashtable<String, UnboundRefId> m_hash = new Hashtable<String, UnboundRefId>(); 
}

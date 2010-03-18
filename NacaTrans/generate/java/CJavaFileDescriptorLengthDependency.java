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
package generate.java;

import generate.CBaseLanguageExporter;
import semantic.CEntityFileDescriptorLengthDependency;
import utils.CObjectCatalog;

/**
 * @author S. Charton
 * @version $Id$
 */
public class CJavaFileDescriptorLengthDependency extends CEntityFileDescriptorLengthDependency
{

	/**
	 * @param name
	 * @param cat
	 * @param out
	 */
	public CJavaFileDescriptorLengthDependency(String name, CObjectCatalog cat, CBaseLanguageExporter out)
	{
		super(name, cat, out);
	}

	/**
	 * @see semantic.CBaseLanguageEntity#DoExport()
	 */
	@Override
	protected void DoExport()
	{
		WriteWord("FileDescriptorDepending " + FormatIdentifier(GetName()) + " = declare.fileDescriptorDepending(") ;
		WriteWord(m_FileDescriptor.ExportReference(getLine()) + ", ");
		WriteWord(m_LenghtDep.ExportReference(getLine()) + ") ;") ;
		WriteEOL() ;
	}

}

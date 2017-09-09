package org.qcri.micromappers.uav.configurator;

import org.qcri.micromappers.uav.exception.ConfigurationPropertyFileException;
import org.qcri.micromappers.uav.exception.ConfigurationPropertyNotRecognizedException;
import org.qcri.micromappers.uav.exception.ConfigurationPropertyNotSetException;
import org.qcri.micromappers.uav.exception.DirectoryNotWritableException;

public interface Configurator {

	public void initProperties(String configLoadFileName,
							   ConfigurationProperty[] configurationProperties)
			throws ConfigurationPropertyNotSetException,
			ConfigurationPropertyNotRecognizedException,
			ConfigurationPropertyFileException;

	public String getProperty(ConfigurationProperty property);
	public String getProperty(String propertyName);
	public void setProperty(String property, String newValue);
	public void directoryIsWritable(String propertyName) throws DirectoryNotWritableException;
}

package org.qcri.micromappers.uav.configurator;

import org.qcri.micromappers.uav.exception.ConfigurationPropertyFileException;
import org.qcri.micromappers.uav.exception.ConfigurationPropertyNotRecognizedException;
import org.qcri.micromappers.uav.exception.ConfigurationPropertyNotSetException;

public class MicromappersConfigurator extends BaseConfigurator {
	
	public static final String configLoadFileName = "config.properties";

	private static final MicromappersConfigurator instance = new MicromappersConfigurator();

	private MicromappersConfigurator() {
		this.initProperties(MicromappersConfigurator.configLoadFileName, MicromappersConfigurationProperty.values());
		this.directoryIsWritable(MicromappersConfigurationProperty.FEED_PATH.getName());
	}

	public static MicromappersConfigurator getInstance()
			throws ConfigurationPropertyNotSetException,
			ConfigurationPropertyNotRecognizedException,
			ConfigurationPropertyFileException {
		return instance;
	}

}

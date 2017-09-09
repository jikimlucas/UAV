package org.qcri.micromappers.uav.configurator;

/**
 * @author Kushal
 * 
 *         Enum containing all the property keys required by the Micromappers.
 *
 */

public enum MicromappersConfigurationProperty implements ConfigurationProperty {
	SERVER_NAME("SERVER_NAME"),
	FEED_PATH("FEED_PATH"),
	TRAINING_DATA_PATH("TRAINING_DATA_PATH"),
	WORD_VECTORS_PATH("WORD_VECTORS_PATH"),
	MULTI_LAYER_NETWORK("MULTI_LAYER_NETWORK"),
	MAX_SENTIMENT_ANALYSIS_PROCESS("MAX_SENTIMENT_ANALYSIS_PROCESS"),
	TRAINING_DATA_URL("TRAINING_DATA_URL");
	private final String configurationProperty;

	private MicromappersConfigurationProperty(String property) {
		configurationProperty = property;
	}

	@Override
	public String getName() {
		return this.configurationProperty;
	}

}

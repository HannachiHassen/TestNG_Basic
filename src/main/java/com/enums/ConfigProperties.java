package com.enums;

/**
 * Enums to restrict the values used on Property files. Without using enums there can be null pointer exceptions happening
 * because of typos.
 * <p>
 * Whenever a new value is added to property file, corresponding enum should be created here.
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 * @see com.tmb.utils.PropertyUtlis
 */
public enum ConfigProperties {
	URL,
	OVERRIDEREPORTS,
	PASSEDSTEPSSCREENSHOTS,
	FAILEDSTEPSSCREENSHOTS,
	SKIPPEDSTEPSSCREENSHOTS,
	RETRYFAILEDTESTS,
	RUNMODE,
	SELENIUMGRIDURL,
	SENDRESULTTOELK, 
	ELASTICURL,
	BROWSER;
}

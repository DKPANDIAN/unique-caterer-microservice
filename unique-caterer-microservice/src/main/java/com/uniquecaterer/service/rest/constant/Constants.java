package com.uniquecaterer.service.rest.constant;

public final class Constants {
	
	public Constants() {
		throw new IllegalAccessError("Constants :: Unreachable class to get instance");
	}

	
	public static final String API_COMMON_ENDPOINT_PREFIX="/api/vi";
	public static final String API_SAVE_CATERER_ENDPOINT="/caterers/save";
	public static final String API_FIND_CATERER_ENDPOINT_BY_ID="/caterers/resources/{id}";
	public static final String API_FIND_CATERER_ENDPOINT_BY_NAME="/caterers/resources/name/{name}";
	public static final String API_FINDBYCITYNAME_CATERER_ENDPOINT="/caterers/findByCityName";
	public static final String API_FINDBYCITYNAME_CATERER_ENDPOINT_PAGENATION="/caterers/pages/{cityName}";
	
	
	public static final String EVENT_TYPE_NEW="NEW";
	public static final String EVENT_TYPE_UPDATE="UPDATE";
	
}

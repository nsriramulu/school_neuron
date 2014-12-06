/*
 * 
 */
package com.sn.utils;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.sn.constants.ResponseStatus;

/**
 * The Class JSONUtils.
 */
@Component
public class JSONUtils {
	
	/**
	 * Gets the string json response.
	 *
	 * @param status the status
	 * @param message the message
	 * @return the string json response
	 */
	public static String getSuccessJSONResponse(String message) {
		JSONObject jsonObject = new JSONObject();
			jsonObject.put(ResponseStatus.STATUS.getCode(), ResponseStatus.SUCCESS.getCode());
			jsonObject.put(ResponseStatus.TITLE.getCode(), ResponseStatus.SUCCESS.getCode());
			jsonObject.put(ResponseStatus.MESSAGE.getCode(), message);
		return jsonObject.toString();
	}
	
	/**
	 * Gets the error json rresponse.
	 *
	 * @param localizedMessage the localized message
	 * @return the error json rresponse
	 */
	public static String getErrorJSONRresponse(String localizedMessage) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(ResponseStatus.TITLE.getCode(), ResponseStatus.ERROR.getCode());
		jsonObject.put(ResponseStatus.STATUS.getCode(), ResponseStatus.FAILURE.getCode());
		jsonObject.put(ResponseStatus.MESSAGE.getCode(), localizedMessage);
		return jsonObject.toString();
	}

	/**
	 * Gets the empty error json rresponse.
	 *
	 * @param messages the messages
	 * @return the empty error json rresponse
	 */
	public static String getEmptyErrorJSONRresponse() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(ResponseStatus.TITLE.getCode(), ResponseStatus.ERROR.getCode());
		jsonObject.put(ResponseStatus.STATUS.getCode(), ResponseStatus.FAILURE.getCode());
		jsonObject.put(ResponseStatus.MESSAGE.getCode(), "");
		return jsonObject.toString();
	}

	/**
	 * Parses the json by key.
	 *
	 * @param responseJSON the response json
	 * @param key the key
	 * @return the string
	 */
	public static String parseJSONByKey(String responseJSON, String key) {
		String jsonValue = "";
		JSONObject jsonObject = new JSONObject(responseJSON);
		jsonValue = jsonObject.getString(key);
		return jsonValue;
	}
	
	/**
	 * Gets the single field error json.
	 *
	 * @param message the message
	 * @return the single field error json
	 */
	public static String getSingleFieldErrorJSON(String message) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(ResponseStatus.STATUS.getCode(), ResponseStatus.FAILURE.getCode());
		jsonObject.put(ResponseStatus.MESSAGE.getCode(), message);
		return jsonObject.toString();
	}
	
	/**
	 * Gets the multi field error json.
	 *
	 * @param responseJSON the response json
	 * @param delimiter the delimiter
	 * @param messages the messages
	 * @return the multi field error json
	 */
	public static String getMultiFieldErrorJSON(String responseJSON,String delimiter, MessageSource messages) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(ResponseStatus.STATUS.getCode(), ResponseStatus.FAILURE.getCode());
		String message = parseJSONByKey(responseJSON, ResponseStatus.MESSAGE.getCode());
		JSONArray jsonArray = new JSONArray(message.split(delimiter));
		JSONArray changeJsonArray = new JSONArray();
		String messageCode="";
		for(int i=0;i<jsonArray.length();i++){
			messageCode = getValue(jsonArray.get(i));
			if(StringUtils.isNotBlank(messageCode)){
				JSONObject temp = new JSONObject(responseJSON);
				if(temp.has("values")){
					JSONArray values = temp.getJSONArray("values");
					String msg = messages.getMessage(messageCode, null, LocaleContextHolder.getLocale());
					for (int j = 0; j < values.length(); j++) {
						msg = StringUtils.replace(msg, "{"+j+"}", getValue(values.get(j)));
					}
					changeJsonArray.put(msg);
				}
				else{
					changeJsonArray.put(messages.getMessage(messageCode, null, LocaleContextHolder.getLocale()));
				}
			}
		}
		jsonObject.put(ResponseStatus.MESSAGE.getCode(), changeJsonArray);
		return jsonObject.toString();
	}
	
	/**
	 * Gets the value.
	 *
	 * @param jsonObj the json obj
	 * @return the value
	 */
	private static String getValue(Object jsonObj) {
		String value="";
		if(jsonObj instanceof String){
			value = (String) jsonObj;
		}
		else if(jsonObj instanceof Integer){
			value = jsonObj+"";
		}
		return value;
	}


	/**
	 * Checks if is json data.
	 *
	 * @param data the data
	 * @return true, if is json data
	 */
	public static boolean isJsonData(String data){
		boolean isJson = true;
		try{
			JSONObject jsonObject = new JSONObject(StringUtils.replace(data, "&quot;", "\""));
		}
		catch(Exception e){
			isJson = false;
		}
		return isJson;
	}
	
	/**
	 * Checks if is json array.
	 *
	 * @param data the data
	 * @return true, if is json array
	 */
	public static boolean isJsonArray(String data){
		boolean isJson = true;
		try{
			JSONArray jsonArray = new JSONArray(StringUtils.replace(data, "&quot;", "\""));
		}
		catch(Exception e){
			isJson = false;
		}
		return isJson;
	}
}

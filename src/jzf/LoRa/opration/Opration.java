package jzf.LoRa.opration;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
public class Opration {
	static String tempJson="{\"applicationID\":\"1\",\"applicationName\":\"smoke\",\"deviceName\":\"1\",\"devEUI\":\"d896e0ff00000240\",\"rxInfo\":[{\"gatewayID\":\"ba555a0000000000\",\"name\":\"GW1\",\"rssi\":-106,\"loRaSNR\":8.8,\"location\":{\"latitude\":29.894684339999987,\"longitude\":121.81268338999996,\"altitude\":0}}],\"txInfo\":{\"frequency\":472300000,\"dr\":5},\"adr\":true,\"fCnt\":1,\"fPort\":10,\"data\":\"MDEyMzQ1Njc4OQ==\"}";
	String loRaUrl="https://66.42.65.86:8080/api/internal/login";
	public static void main(String[] args) {
        JsonParser parse =new JsonParser();
		 try {//、
	            JsonObject json=(JsonObject)parse.parse(tempJson);
	            String rxInfo=json.get("rxInfo").toString();
	            rxInfo=rxInfo.replaceAll("\\[", "");
	            rxInfo=rxInfo.replaceAll("\\]", "");
	            String location=rxInfo.substring(rxInfo.indexOf("location")+11,rxInfo.indexOf("}"));
	            String longi=location.substring(location.indexOf("longi")+11,location.indexOf("longi")+26);
	            String lati=location.substring(location.indexOf("lati")+10,location.indexOf("lati")+26);
	            String alti=location.substring(location.indexOf("alti")+10);
	            System.out.println(location+"\r\n"+"经度"+longi+"\r\n"+"纬度"+lati+"\r\n"+"海拔"+alti);
	            
	        } catch (JsonIOException e) {
	            e.printStackTrace();
	        } catch (JsonSyntaxException e) {
	            e.printStackTrace();
	        }
	}

}
/*
 * {"applicationID":"1",
 * "applicationName":"smoke",
 * "deviceName":"1",
 * "devEUI":"d896e0ff00000240",
 * "rxInfo":[{"gatewayID":"ba555a0000000000","name":"GW1","rssi":-106,"loRaSNR":8.8,
 * 		"location":{"latitude":29.894684339999987,"longitude":121.81268338999996,"altitude":0}}],
 * "txInfo":{"frequency":472300000,"dr":5},
 * "adr":true,"fCnt":1,"fPort":10,"data":"MDEyMzQ1Njc4OQ=="}
 * 
 * */
 
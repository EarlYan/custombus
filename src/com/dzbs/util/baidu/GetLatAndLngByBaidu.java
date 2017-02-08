package com.dzbs.util.baidu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dzbs.util.http.HttpsRequest;

/**
 * 获取经纬度通过
 */
public class GetLatAndLngByBaidu {

	/**
	 * @param addr
	 * 根据地址查询经纬度信息
	 * @return
	 * @throws IOException
	 */
	public static String[] getCoordinate(String addr) {
		String address = "";
        String lat = "";
        String lng = "";
        try {  
            address = java.net.URLEncoder.encode(addr,"UTF-8");  
            String url = String.format("http://api.map.baidu.com/geocoder/v2/?"
                    +"ak=sYY91vHWc5btABI2DOM7gEfm&output=json&address=%s",address);
	    	Map<String,String> queries= new HashMap<String,String>();
	    	String response = HttpsRequest.httpRequest(url,queries);
	    	JSONObject object = JSONObject.parseObject(response);
	    	JSONObject result = ((JSONObject) object.get("result")).getJSONObject("location");
	    	lng = result.getString("lng");
	    	lat = result.getString("lat");
	    	return new String[]{lng,lat};
        } catch (Exception e1) {  
            e1.printStackTrace();  
        } 
        return null;
	}
	
	/**
	 * 根据经纬度查询地址
	 * @param lat
	 * @param lng
	 * @return
	 */
	public static String getAddressByLatAndLng(float lng, float lat){
		String result = null;
		try{
			String tmp = lat + "," + lng;
			String url = "http://api.map.baidu.com/geocoder/v2/?location=" + tmp + "&output=json&pois=1&ak=sYY91vHWc5btABI2DOM7gEfm";
	    	Map<String,String> queries= new HashMap<String,String>();
	    	String response = HttpsRequest.httpRequest(url,queries);
	    	JSONObject object = JSONObject.parseObject(response);
	    	result = ((JSONObject) object.get("result")).getString("formatted_address");
	    	System.out.println(result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
	
	/**
	 * 从GPS坐标体系转换到百度坐标体系
	 * @param lat
	 * @param lng
	 * @return
	 */
	public static float[] changeGPSToBaidu(float lng, float lat){
        float lat1 = 0;
        float lng1 = 0;
		try{
			String tmp = lng + "," + lat;
			String url = "http://api.map.baidu.com/geoconv/v1/?coords=" + tmp + "&from=1&to=5&ak=sYY91vHWc5btABI2DOM7gEfm";
	    	Map<String,String> queries= new HashMap<String,String>();
	    	String response = HttpsRequest.httpRequest(url,queries);
	    	JSONObject object = JSONObject.parseObject(response);
	    	JSONArray array = (JSONArray) object.get("result");
	    	lng1 = Float.valueOf(((JSONObject)array.get(0)).get("x").toString());
	    	lat1 = Float.valueOf(((JSONObject)array.get(0)).get("y").toString());
	    	return new float[]{lng1,lat1};
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
    //地球平均半径  
    private static final double EARTH_RADIUS = 6378137;  
    //把经纬度转为度（°）  
    private static double rad(double d){  
       return d * Math.PI / 180.0;  
    }
    
    /**  
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米  
     * @param lng1  
     * @param lat1  
     * @param lng2  
     * @param lat2  
     * @return  
     */  
    public static double getDistance(double lng1, double lat1, double lng2, double lat2){  
       double radLat1 = rad(lat1);  
       double radLat2 = rad(lat2);  
       double a = radLat1 - radLat2;  
       double b = rad(lng1) - rad(lng2);  
       double s = 2 * Math.asin(  
            Math.sqrt(  
                Math.pow(Math.sin(a/2),2)   
                + Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)  
            )  
        );  
       s = s * EARTH_RADIUS;  
       s = Math.round(s * 10000) / 10000;  
       return s;  
    }  

	public static void main(String[] args){
//		String[] strs = GetLatAndLngByBaidu.getCoordinate("上海市上海银行");
//		System.out.println(strs[0] + ":" + strs[1]);
//		getAddressByLatAndLng("31.1121898", "121.3457041");
//		getAddressByLatAndLng("31.187327990222", "121.59467280397");
//		float[] aa = changeGPSToBaidu(121.58412183f,31.18351133f);
//		System.out.println("---------");
//		float[] bb = changeGPSToBaidu(121.584f,31.1834f);
//		System.out.println(getAddressByLatAndLng(aa[0],aa[1]));
//		System.out.println("---------");
//		System.out.println(getAddressByLatAndLng(bb[0],bb[1]));
	}

}

package com.dzbs.util.http;

import java.io.IOException;  
import java.security.KeyManagementException;  
import java.security.KeyStore;  
import java.security.KeyStoreException;  
import java.security.NoSuchAlgorithmException;  
import java.security.cert.CertificateException;  
import java.security.cert.X509Certificate;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Map;  
  
  

import org.apache.http.*;  
import org.apache.http.client.ClientProtocolException;  
import org.apache.http.client.config.RequestConfig;  
import org.apache.http.client.methods.*;  
import org.apache.http.config.Registry;  
import org.apache.http.config.RegistryBuilder;  
import org.apache.http.conn.socket.ConnectionSocketFactory;  
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;  
import org.apache.http.conn.socket.PlainConnectionSocketFactory;  
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;  
import org.apache.http.conn.ssl.SSLContexts;  
import org.apache.http.conn.ssl.TrustStrategy;  
import org.apache.http.impl.client.CloseableHttpClient;  
import org.apache.http.impl.client.HttpClientBuilder;  
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;  
import org.apache.http.util.EntityUtils;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
  

import javax.net.ssl.SSLContext;  
  
  
public class HttpsRequest {  
    private static final Logger logger = LoggerFactory.getLogger(HttpsRequest.class);  
    private static int SocketTimeout = 3000;//3�? 
    private static int ConnectTimeout = 3000;//3�? 
    private static Boolean SetTimeOut = true;  
  
    private static CloseableHttpClient getHttpClient() {  
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create();  
        ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();  
        registryBuilder.register("http", plainSF);  
        
        //指定信任密钥存储对象和连接套接字工厂  
        try {  
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());  
            
            //信任任何链接  
            TrustStrategy anyTrustStrategy = new TrustStrategy() {  
                @Override  
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {  
                    return true;  
                }  
            };  
            SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy).build();  
            LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);  
            registryBuilder.register("https", sslSF);  
        } catch (KeyStoreException e) {  
            throw new RuntimeException(e);  
        } catch (KeyManagementException e) {  
            throw new RuntimeException(e);  
        } catch (NoSuchAlgorithmException e) {  
            throw new RuntimeException(e);  
        }  
        Registry<ConnectionSocketFactory> registry = registryBuilder.build();  
        
        //设置连接管理�? 
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);  
//      connManager.setDefaultConnectionConfig(connConfig);  
//      connManager.setDefaultSocketConfig(socketConfig);  
        
        //构建客户�? 
        return HttpClientBuilder.create().setConnectionManager(connManager).build();  
    }  
  
    /** 
     * get 
     * 
     * @param url     请求的url 
     * @param queries 请求的参数，在浏览器？后面的数据，没有可以传null 
     * @return 
     * @throws IOException 
     */  
    public static String get(String url, Map<String, String> queries) throws IOException {  
        String responseBody = "";  
        //CloseableHttpClient httpClient=HttpClients.createDefault();  
        //支持https  
        CloseableHttpClient httpClient = getHttpClient();  
  
        StringBuilder sb = new StringBuilder(url);  
  
        if (queries != null && queries.keySet().size() > 0) {  
            boolean firstFlag = true;  
            Iterator iterator = queries.entrySet().iterator();  
            while (iterator.hasNext()) {  
                Map.Entry entry = (Map.Entry<String, String>) iterator.next();  
                if (firstFlag) {  
                    sb.append("?" + (String) entry.getKey() + "=" + (String) entry.getValue());  
                    firstFlag = false;  
                } else {  
                    sb.append("&" + (String) entry.getKey() + "=" + (String) entry.getValue());  
                }  
            }  
        }  
  
        HttpGet httpGet = new HttpGet(sb.toString());  
        if (SetTimeOut) {  
            RequestConfig requestConfig = RequestConfig.custom()  
                    .setSocketTimeout(SocketTimeout)  
                    .setConnectTimeout(ConnectTimeout).build();//设置请求和传输超时时�? 
            httpGet.setConfig(requestConfig);  
        }  
        try {  
//            System.out.println("Executing request " + httpGet.getRequestLine());  
            //请求数据  
            CloseableHttpResponse response = httpClient.execute(httpGet);  
            System.out.println(response.getStatusLine());  
            int status = response.getStatusLine().getStatusCode();  
            if (status == HttpStatus.SC_OK) {  
                HttpEntity entity = response.getEntity();  
                // do something useful with the response body  
                // and ensure it is fully consumed  
                responseBody = EntityUtils.toString(entity);  
                //EntityUtils.consume(entity);  
            } else {  
                System.out.println("http return status error:" + status);  
                throw new ClientProtocolException("Unexpected response status: " + status);  
            }  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        } finally {  
            httpClient.close();  
        }  
        return responseBody;  
    }  
  
    /** 
     * httpRequest 
     * 
     * @param url     请求的url 
     * @param queries 请求的参数，在浏览器？后面的数据，没有可以传null 
     * @return 
     * @throws IOException 
     */  
    public static String httpRequest(String url,Map<String,String> queries) {
//    	url = "https://www.renrendai.com/checkEmail.action?username=18516637901";
    	String response = "";
    	try {
			response = get(url,queries);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return response;
    }
    
    //test
    public static void main(String[] arg){
    	String url = "http://stackoverflow.com/search?page=";
    	for(int i=0; i<1000; i++){
    		url = url + i + "&tab=relevance&q=spark";
        	Map<String,String> queries= new HashMap<String,String>();
        	String response = httpRequest(url,queries);
    		System.out.println("response:"+response);
    	}

    }
}  
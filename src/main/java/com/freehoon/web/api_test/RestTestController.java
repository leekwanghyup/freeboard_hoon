package com.freehoon.web.api_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/apiTest")
public class RestTestController {
	
	
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
	public String callAPIhtt() {
		StringBuffer result = new StringBuffer(); 
		try {
			String urlStr = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=903";
			URL url = new URL(urlStr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");
 
            BufferedReader br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
 
            String returnLine;
 
            while((returnLine = br.readLine()) != null) {
                result.append(returnLine);
                System.out.println(br.readLine());
            }
            urlconnection.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result.toString();
	}
}

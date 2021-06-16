package com.haris.sampleRestAPI.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;


@Controller
public class NetworkDAO {
	
	public String request(String url, HashMap<String, String> headers) throws IOException {
		StringBuilder sb = new StringBuilder();
		Builder builder = new Request.Builder();
		builder.url(url);
		for(Entry<String, String> each: headers.entrySet())
			builder.addHeader(each.getKey(), each.getValue());
		Request request = builder.build();
		
		OkHttpClient httpClient = new OkHttpClient();
		Response response = httpClient.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException(response.toString());
		else
			sb.append(response.body().string());
        return sb.toString();
	}

}

package com.tcInfo.service;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

@Service
public class ScriptService {

	public String execCommand(String command) {
		String result = null;
		try {
	        Runtime runtime = Runtime.getRuntime();
	        Process process = runtime.exec("/Users/kaju/.rbenv/shims/ruby /Users/kaju/WorkSpace/eclipse_work/Tcinformation/script/scraping.rb startups");
	        process.waitFor();
	        InputStream inputStream = process.getInputStream();
	        result = inputStream.toString();
	    } catch (IOException | InterruptedException ex) {
	    	// TODO: Exception: 実行時エラー
	    }
		return result;
	}

	public String buildCommand() {
		return null;
	}
}

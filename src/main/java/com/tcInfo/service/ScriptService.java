package com.tcInfo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import com.tcInfo.constant.ErrorConstant;
import com.tcInfo.error.TcInfoException;

/**
 * スクリプト実行 service クラス
 *
 * @author kaju
 */
@Service
public class ScriptService {

	public String execCommand(String command) {
		String result = null;
		try {
	        Runtime runtime = Runtime.getRuntime();
	        Process process = runtime.exec(command);
	        process.waitFor();
	        InputStream inputStream = process.getInputStream();
	        result = this.inputStreemToString(inputStream);
	    } catch (IOException | InterruptedException ex) {
	    	throw new TcInfoException(ErrorConstant.COMMAND_EXEC_ERROR,ex);
	    }
		return result;
	}

	public String buildCommand(String category) {
		String command = "/Users/kaju/.rbenv/shims/ruby /Users/kaju/WorkSpace/eclipse_work/Tcinformation/script/scraping.rb " + category;
		System.out.println(command);
		return command;
	}

	private String inputStreemToString(InputStream in) throws IOException{

        BufferedReader reader =
            new BufferedReader(new InputStreamReader(in, "UTF-8"));
        StringBuffer buf = new StringBuffer();
        String str;
        while ((str = reader.readLine()) != null) {
                buf.append(str);
                buf.append("\n");
        }
        return buf.toString();
    }
}

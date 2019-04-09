package com.tcInfo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcInfo.service.TcInfoEndpointService;

@RestController
public class TcInfoEndpoint {
	@Autowired
    TcInfoEndpointService endpointService;

	@RequestMapping(path = "/**", method = RequestMethod.GET)
    public ResponseEntity<String> getController() {
        ResponseEntity<String> response = this.endpointService.run();
        return response;
    }


}

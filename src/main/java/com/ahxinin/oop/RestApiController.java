package com.ahxinin.oop;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : hexin
 * @description: rest接口
 * @date : 2021-09-25
 */
@RestController
@RequestMapping("api")
public class RestApiController {

    @Autowired
    private com.ahxinin.apiauth.ApiAuthenticator apiAuthenticator;

    @GetMapping("index")
    public ResponseEntity<String> index(HttpServletRequest request){
        StringBuffer requestUrl = request.getRequestURL();
        String queryString = request.getQueryString();
        String url = requestUrl.append("?").append(queryString).toString();
        try {
            apiAuthenticator.auth(url);
        }catch (Exception e){
            return ResponseEntity.ok(e.getMessage());
        }
        return ResponseEntity.ok("this is index api");
    }
}

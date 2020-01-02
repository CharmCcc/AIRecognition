package com.baidu.main.service.impl;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Util;
import com.baidu.main.service.PlateLicenseService;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author chm
 * 车牌识别功能模块
 * @date 2020/1/2 9:04
 */
public class PlateLicenseServiceImpl implements PlateLicenseService {

    private AipOcr client;

    // 传入可选参数调用接口
    HashMap<String, String> options = new HashMap<String, String>();

    public PlateLicenseServiceImpl(AipOcr aipOcr){
        client = aipOcr;
    }

    // 开启或关闭检测多张车牌
    public void OnorOffMulti(){
        if(options.get("multi_detect").equals("true"))
            options.put("multi_detect", "false");
        else
            options.put("multi_detect", "true");
    }

    /**
     * 车牌识别暴露接口
     * @return
     */
    public String recognize(){

        // 开启检测多张车牌
        options.put("multi_detect", "true");

        // 参数为本地图片路径
        String image = "D:\\IDEA\\AI实训项目\\AIRecognition\\src\\main\\resources\\testPic\\plate3.jpg";
        JSONObject res = client.plateLicense(image, options);
        System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
        byte[] file = new byte[0];
        try {
            file = Util.readFileByBytes(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        res = client.plateLicense(file, options);
        return res.toString(2);
    }
}

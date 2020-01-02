package com.baidu.main.service.impl;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Util;
import com.baidu.main.service.ReceiptService;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author chm
 * 发票识别模块
 * @date 2020/1/2 9:45
 */
public class ReceiptServiceImpl implements ReceiptService {

    private AipOcr client;

    // 可选参数调用接口
    HashMap<String, String> options = new HashMap<String, String>();

    public ReceiptServiceImpl(AipOcr aipOcr) {
        client = aipOcr;

        options.put("recognize_granularity", "big");
        options.put("probability", "true");
        options.put("accuracy", "normal");
        options.put("detect_direction", "true");
    }

    /**
     * 开始识别
     *
     * @return
     */
    @Override
    public String recognize() {
        // 参数为本地图片路径
        String image = "D:\\IDEA\\AI实训项目\\AIRecognition\\src\\main\\resources\\testPic\\receipt2.jpg";
        JSONObject res = client.receipt(image, options);
        System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
        byte[] file = new byte[0];
        try {
            file = Util.readFileByBytes(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        res = client.receipt(file, options);
        return res.toString(2);
    }
}

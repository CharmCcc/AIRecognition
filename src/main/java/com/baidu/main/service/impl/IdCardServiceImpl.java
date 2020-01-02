package com.baidu.main.service.impl;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Util;
import com.baidu.main.service.IdCardService;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author chm
 * 身份证识别模块
 * @date 2020/1/2 9:55
 */
public class IdCardServiceImpl implements IdCardService {

    private AipOcr client;

    // 传入可选参数调用接口
    HashMap<String, String> options = new HashMap<String, String>();

    // 身份证的正反面，front：身份证含照片的一面；back：身份证带国徽的一面
    String idCardSide = "back";

    public IdCardServiceImpl(AipOcr aipOcr) {
        this.client = aipOcr;
    }

    // 转换识别身份证的正面还是反面
    public void OppositeSide(){
        if(idCardSide.equals("back"))
            idCardSide = "front";
        else
            idCardSide = "back";
    }

    /**
     * 开始识别
     *
     * @return
     */
    @Override
    public String recognize() {

        options.put("detect_direction", "true");
        options.put("detect_risk", "false");

        // 参数为本地图片路径
        String image = "D:\\IDEA\\AI实训项目\\AIRecognition\\src\\main\\resources\\testPic\\idcard1.jpg";
        JSONObject res = client.idcard(image, idCardSide, options);
        System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
        byte[] file = new byte[0];
        try {
            file = Util.readFileByBytes(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        res = client.idcard(file, idCardSide, options);
        return res.toString(2);
    }
}

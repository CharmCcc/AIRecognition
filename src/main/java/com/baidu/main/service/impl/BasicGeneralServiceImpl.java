package com.baidu.main.service.impl;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Util;
import com.baidu.main.service.BasicGeneralService;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author chm
 * 通用文字识别模块
 * @date 2020/1/2 9:12
 */
public class BasicGeneralServiceImpl implements BasicGeneralService {

    private AipOcr client;

    // 可选参数调用接口
    HashMap<String, String> options = new HashMap<String, String>();

    public BasicGeneralServiceImpl(AipOcr aipOcr){
        client = aipOcr;
    }


    /**
     * 开始识别
     * @return
     */
    @Override
    public String recognize() {

        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        // 参数为本地图片路径
        String image = "D:\\IDEA\\AI实训项目\\AIRecognition\\src\\main\\resources\\testPic\\words.jpg";
        JSONObject res = client.basicGeneral(image, options);
        System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
        byte[] file = new byte[0];
        try {
            file = Util.readFileByBytes(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        res = client.basicGeneral(file, options);
        System.out.println(res.toString(2));


        // 通用文字识别, 图片参数为远程url图片
        res = client.basicGeneralUrl(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577770520388&di=f737c8aca36fb576b370297b62d89830&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201606%2F05%2F20160605090104_FEAkT.jpeg"
                , options);
        return res.toString(2);
    }
}

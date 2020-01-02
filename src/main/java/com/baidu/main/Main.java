package com.baidu.main;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Util;
import com.baidu.main.service.BasicGeneralService;
import com.baidu.main.service.IdCardService;
import com.baidu.main.service.PlateLicenseService;
import com.baidu.main.service.ReceiptService;
import com.baidu.main.service.impl.BasicGeneralServiceImpl;
import com.baidu.main.service.impl.IdCardServiceImpl;
import com.baidu.main.service.impl.PlateLicenseServiceImpl;
import com.baidu.main.service.impl.ReceiptServiceImpl;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author chm
 *  主函数入口、新建AipOcr
 * @date 2019/12/31 10:22
 */
public class Main {
    //设置APPID/AK/SK
    public static final String APP_ID = "11469861";
    public static final String API_KEY = "2NmBChTTNG33BVixnbiZiMLR";
    public static final String SECRET_KEY = "l2gjFmGcxgnUUw6WIBQIGUVQkEqqnGNM";

    public static void main(String[] args) throws IOException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        BasicGeneralService basicGeneralService = new BasicGeneralServiceImpl(client);
        System.out.println("文字识别开始...");
        System.out.println(basicGeneralService.recognize());

//        PlateLicenseService plateLicenseService = new PlateLicenseServiceImpl(client);
//        System.out.println("车牌识别开始...");
//        System.out.println(plateLicenseService.recognize());

//        ReceiptService receiptService = new ReceiptServiceImpl(client);
//        System.out.println("发票识别开始...");
//        System.out.println(receiptService.recognize());

//        IdCardService idCardService = new IdCardServiceImpl(client);
//        System.out.println("身份证识别开始...");
//        System.out.println(idCardService.recognize());

    }
}

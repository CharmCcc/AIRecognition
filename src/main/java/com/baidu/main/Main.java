package com.baidu.main;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Util;
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

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "log4j.properties");

        // 1. 参数为本地图片路径
        String path = "D:\\IDEA\\AI实训项目\\AIRecognition\\src\\main\\resources\\testPic\\test.jpg";
        JSONObject res = client.basicGeneral(path, options);
        System.out.println(res.toString(2));

        // 2. 参数为本地图片二进制数组
//        byte[] file = Util.readFileByBytes("D:\\IDEA\\AI实训项目\\AIRecognition\\src\\main\\resources\\testPic\\test.jpg");
//        res = client.basicGeneral(file, options);
//        System.out.println(res.toString(2));

        // 3.通用文字识别, 图片参数为远程url图片
//        JSONObject res = client.basicGeneralUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577770520388&di=f737c8aca36fb576b370297b62d89830&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201606%2F05%2F20160605090104_FEAkT.jpeg", options);
//        System.out.println(res.toString(2));

    }
}

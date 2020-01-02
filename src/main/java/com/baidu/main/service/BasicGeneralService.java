package com.baidu.main.service;

/**
 * @author chm
 * @date 2020/1/2 9:19
 */
public interface BasicGeneralService extends RecognizationService {

    /**
     * 通用文字识别(高精度版)
     * @return
     */
    public String highPrecisionRecognization();

    /**
     * 生僻字识别
     * @return
     */
    public String uncommonWordsRecognization();


}

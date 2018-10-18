package com.qfedu.utils;


import com.qfedu.vo.R;

/**
 *1代表成功，0代表失败
 */
public class ResultUtil {
    //
    public static R setOK(String msg){
        return new R(1,msg,null);
    }
    public static R setERROR(String msg){
        return new R(0,msg,null);
    }
    public static R setRes(int count){
        if(count>0){
            return setOK("操作成功");
        }else {
            return setERROR("操作失败");
        }
    }

}

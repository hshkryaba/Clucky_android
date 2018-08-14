package com.studios.uio443.cluck.data.util;

//
// Created by Korotchenko Evgeny on 14.08.2018.
//

import android.util.Base64;
import android.util.Log;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class JWTUtils {
    public static void decoded(String JWTEncoded) throws Exception {
        try {
            String[] split = JWTEncoded.split("\\.");
            Log.d("JWT_DECODED", "Header: " + getJson(split[0]));
            Log.d("JWT_DECODED", "Body: " + getJson(split[1]));
        } catch (UnsupportedEncodingException e) {
            //Error
        }
    }

    private static String getJson(String strEncoded) throws UnsupportedEncodingException {
        byte[] decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE);
        return new String(decodedBytes, "UTF-8");
    }

    public static int getIntParamFromJWTBody(String JWTEncoded, String param) throws Exception {
        try {
            String[] split = JWTEncoded.split("\\.");
            String jsonBody = getJson(split[1]);

            JSONObject jsonObject = new JSONObject(jsonBody);

            return jsonObject.getInt(param);

        } catch (UnsupportedEncodingException e) {
            return 0;
        }
    }
}
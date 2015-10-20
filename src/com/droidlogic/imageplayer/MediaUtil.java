/**
 * @Package com.droidlogic.imageplayer
 * @Description
 *
 * Copyright (c) Inspur Group Co., Ltd. Unpublished
 *
 * Inspur Group Co., Ltd.
 * Proprietary & Confidential
 *
 * This source code and the algorithms implemented therein constitute
 * confidential information and may comprise trade secrets of Inspur
 * or its associates, and any use thereof is subject to the terms and
 * conditions of the Non-Disclosure Agreement pursuant to which this
 * source code was originally received.
 */
package com.droidlogic.imageplayer;

import android.content.Context;
import android.content.Intent;

import android.util.Log;


/**
 * @ClassName MediaUtil
 * @Description TODO
 * @Date 2014年5月20日
 * @Email
 * @Author
 * @Version V1.0
 */
public class MediaUtil {
    public static final String KEY_MEDIA_PATH = "media-path";
    public static final String KEY_PARENT_MEDIA_PATH = "parent-media-path";
    public static final String KEY_SET_CENTER = "set-center";
    public static final String KEY_AUTO_SELECT_ALL = "auto-select-all";
    public static final String KEY_SHOW_CLUSTER_MENU = "cluster-menu";
    public static final String KEY_EMPTY_ALBUM = "empty-album";
    public static final String KEY_RESUME_ANIMATION = "resume_animation";
    public static final String MIME_TYPE_PANORAMA360 = "application/vnd.google.panorama360+jpg";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final String MIME_TYPE_ALL = "*/*";
    public static final String MIME_TYPE_IMAGE = "image/*";
    private static final String DIR_TYPE_IMAGE = "vnd.android.cursor.dir/image";
    private static final String TOP_LOCAL_IMAGE_SET_PATH = "/local/image";
    private static final String TOP_IMAGE_SET_PATH = "/combo/{/local/image,/picasa/image}";
    public static final int INCLUDE_IMAGE = 1;
    public static final int INCLUDE_LOCAL_ONLY = 4;
    public static final int INCLUDE_LOCAL_IMAGE_ONLY = INCLUDE_LOCAL_ONLY |
        INCLUDE_IMAGE;
    private static final String TAG = "MediaUtil";

    public static int determineTypeBits(Context context, Intent intent) {
        int typeBits = 0;
        String type = intent.resolveType(context);

        if (MIME_TYPE_IMAGE.equals(type) || DIR_TYPE_IMAGE.equals(type)) {
            typeBits = INCLUDE_IMAGE;
        }

        Log.d(TAG, "determineTypeBits get type from type:" + type);

        if (ApiHelper.HAS_INTENT_EXTRA_LOCAL_ONLY) {
            if (intent.getBooleanExtra(Intent.EXTRA_LOCAL_ONLY, false)) {
                typeBits |= INCLUDE_LOCAL_ONLY;
            }
        }

        return typeBits;
    }
}
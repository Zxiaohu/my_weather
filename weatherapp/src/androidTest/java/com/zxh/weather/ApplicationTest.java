package com.zxh.weather;

import android.app.Application;
import android.test.ApplicationTestCase;

import org.xutils.x;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
        x.Ext.init(getApplication());
    }
}
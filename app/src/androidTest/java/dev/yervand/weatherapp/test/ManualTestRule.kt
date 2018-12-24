package dev.yervand.weatherapp.test

import android.app.Activity
import android.support.test.rule.ActivityTestRule

class ManualTestRule<T : Activity>(activityClass: Class<T>) : ActivityTestRule<T>(activityClass)
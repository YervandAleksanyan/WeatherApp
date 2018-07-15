package dev.yervand.weatherapp.splash

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import dev.yervand.weatherapp.base.BaseActivity
import dev.yervand.weatherapp.weather.WeatherActivity


class SplashActivity : BaseActivity() {


    companion object {
        const val RC = 1001
    }

    private val perms = arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requiresPermissions()
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        requiresPermissions()
    }

    private fun requiresPermissions() {
        if (checkPermission()) {
            startWeatherActivity()
        } else {
            requestPermissions()
        }
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(this, perms, RC)
    }


    private fun checkPermission(): Boolean {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true
        }
        for (permission in perms) {
            if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    private fun startWeatherActivity() {
        WeatherActivity.start(this)
        finish()
    }

}
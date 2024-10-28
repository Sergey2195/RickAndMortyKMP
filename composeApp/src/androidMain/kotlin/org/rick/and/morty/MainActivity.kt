package org.rick.and.morty

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import org.rick.and.morty.navigation.Navigator

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            enableEdgeToEdge(statusBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT))
            WindowCompat.getInsetsController((LocalView.current.context as Activity).window, LocalView.current).isAppearanceLightStatusBars = false
            val navHostController = rememberNavController()
            Navigator.setNavigator(navHostController)
            App(Navigator.getNavigator())
        }
    }
}
package org.lycancypher.navlayouts01.activities

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import org.lycancypher.navlayouts01.R
import org.lycancypher.navlayouts01.databinding.ActivityMainBinding

/*ESTA ES LA PANTALLA PRINCIPAL DE LA APP*/
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val fadeOut: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.fade_out) }
    private val fadeIn: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.fade_in) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupToolbar()
        setupNavigationView()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.topAppBar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    private fun setupNavigationView() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.bottomNavigation.itemIconTintList = null
        val options = NavOptions.Builder()
            .setLaunchSingleTop(false)
            .setPopUpTo(navController.graph.startDestinationRoute, true)
            .build()

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    navController.navigate(R.id.homeFragment, null, options)
                }
                R.id.storesFragment -> {
                    navController.navigate(R.id.storesFragment, null, options)
                }

                R.id.movsFragment -> {
                    navController.navigate(R.id.movsFragment, null, options)
                }

                R.id.promosFragment -> {
                    navController.navigate(R.id.promosFragment, null, options)
                }

                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment, null, options)
                }
            }
            true
        }

        binding.bottomNavigation.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    navController.navigate(R.id.homeFragment, null, options)
                }
                R.id.storesFragment -> {
                    navController.navigate(R.id.storesFragment, null, options)
                }

                R.id.movsFragment -> {
                    navController.navigate(R.id.movsFragment, null, options)
                }

                R.id.promosFragment -> {
                    navController.navigate(R.id.promosFragment, null, options)
                }

                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment, null, options)
                }
            }
            return@setOnItemReselectedListener
        }

        navController.addOnDestinationChangedListener(this)
    }

    private fun drawableBack(): Drawable {
        var drawable =
            ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_back,
                null)
        drawable = DrawableCompat.wrap(drawable!!)
        DrawableCompat.setTint(
            drawable,
            ContextCompat.getColor(this@MainActivity, R.color.white)
        )
        return drawable
    }

    private fun enableReturn(title: String) {
        binding.apply {
            if (imgLogo.visibility == View.VISIBLE) {
                imgLogo.startAnimation(fadeOut)
                imgLogo.visibility = View.GONE
            }
            if (bottomNavigation.visibility == View.VISIBLE) {
                bottomNavigation.startAnimation(fadeOut)
                bottomNavigation.visibility = View.GONE
            }
        }
        binding.topAppBar.apply {
            this.title = title
            navigationIcon = drawableBack()
            setNavigationOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    private fun disableReturn() {
        binding.topAppBar.apply {
            this.title = ""
            navigationIcon = null
        }
        binding.apply {
            if (imgLogo.visibility == View.GONE) {
                imgLogo.visibility = View.VISIBLE
                imgLogo.startAnimation(fadeIn)
            }
            if (appBar.visibility == View.GONE) {
                appBar.startAnimation(fadeIn)
                appBar.visibility = View.VISIBLE
            }
            if (bottomNavigation.visibility == View.GONE) {
                bottomNavigation.startAnimation(fadeIn)
                bottomNavigation.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?,
    ) {
        /*binding.topAppBar.menu.clear()
        onCreateOptionsMenu(binding.topAppBar.menu)
        binding.apply {
            topAppBar.setNavigationOnClickListener {
                atras()
            }
        }*/

        when (destination.id) {
            R.id.sendPhoneFragment,
                R.id.sendCodeFragment,
                R.id.registerUserFragment -> {
                if (binding.appBar.visibility == View.VISIBLE) {
                    binding.appBar.startAnimation(fadeOut)
                    binding.appBar.visibility = View.GONE
                }
                if (binding.bottomNavigation.visibility == View.VISIBLE) {
                    binding.bottomNavigation.startAnimation(fadeOut)
                    binding.bottomNavigation.visibility = View.GONE
                }
            }

            R.id.homeFragment,
            R.id.storesFragment,
            R.id.movsFragment,
            R.id.promosFragment,
            R.id.profileFragment -> {

                disableReturn()
            }

            R.id.scanCodeFragment -> {
                enableReturn(destination.label as String)
            }
        }
    }
}
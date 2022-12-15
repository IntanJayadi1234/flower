package intan203110029.flowers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.cupcake.R

/**
 * alur Activity untuk pembelian bunga
 */
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // menyiapkan pengontrol navigasi yang akan digunakan NavController dari NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // membuat instan yang akan meneruskan ke NavController
        setupActionBarWithNavController(navController)
    }
}
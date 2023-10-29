package com.lloydna.easysell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.lloydna.easysell.databinding.EsMainFrameBinding
import com.lloydna.easysell.ui.fragments.ESAboutUsFragment
import com.lloydna.easysell.ui.fragments.InventarioFragment

class ESMainFrame : AppCompatActivity() {
    lateinit var binding: EsMainFrameBinding

    lateinit var aboutUsFragment: Fragment
    lateinit var inventarioFragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = DataBindingUtil.setContentView(this, R.layout.es_main_frame)

        aboutUsFragment = ESAboutUsFragment()
        inventarioFragment = InventarioFragment()

        setCurrentFragment(aboutUsFragment)


        binding.mainNavigationBar.setOnNavigationItemSelectedListener{ selectedItem ->
            when(selectedItem.itemId){
                R.id.punto_de_venta_nav -> setCurrentFragment(aboutUsFragment) //TODO: change to corresponding fragment once they are created
                R.id.inventario_nav -> setCurrentFragment(inventarioFragment)
                R.id.usuarios_nav -> setCurrentFragment(aboutUsFragment)
                R.id.about_us_nav -> setCurrentFragment(aboutUsFragment)
            }

            true
        }

        setContentView(R.layout.es_main_frame)
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(binding.mainFragmentHolder.id, fragment)
            commit()
        }
}
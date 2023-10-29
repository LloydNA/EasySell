package com.lloydna.easysell.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lloydna.easysell.R

class InventarioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_inventario, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = ProductosAdapter() // Necesitas crear el adaptador según tus datos
        recyclerView.adapter = adapter

        val fab = view.findViewById<FloatingActionButton>(R.id.floating_action_button)
        fab.setOnClickListener {
            mostrarDialogoAgregarProducto()
        }

        return view.rootView
    }

    private fun mostrarDialogoAgregarProducto() {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.dialog_content, null)
        val editTextID = view.findViewById<EditText>(R.id.editTextID)
        val editTextNombre = view.findViewById<EditText>(R.id.editTextNombre)
        val editTextPrecio = view.findViewById<EditText>(R.id.editTextPrecio)
        val editTextCantidad = view.findViewById<EditText>(R.id.editTextCantidad)


        val alertDialog = MaterialAlertDialogBuilder(requireContext())
            .setTitle(resources.getString(R.string.title))
            .setView(view) // Establece el contenido del cuadro de diálogo
            .setNeutralButton(resources.getString(R.string.cancelar)) { dialog, which ->
                // Respond to neutral button press
            }
            .setNegativeButton(resources.getString(R.string.borrar)) { dialog, which ->
                // Respond to negative button press
            }
            .setPositiveButton(resources.getString(R.string.agregar)) { dialog, which ->
                // Respond to positive button press
                val ID = editTextID.text.toString()
                val nombre = editTextNombre.text.toString()
                val precio = editTextPrecio.text.toString()
                val cantidad = editTextCantidad.text.toString()

                // Aquí puedes procesar los datos ingresados y realizar la lógica para agregar el producto
            }
            .create()

    }

    // Define tu adaptador para el RecyclerView
    private class ProductosAdapter : RecyclerView.Adapter<ProductosViewHolder>() {
        // Implementa los métodos necesarios para el adaptador
        // ...

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
            // Infla el diseño del elemento de la lista y crea un ViewHolder
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
            return ProductosViewHolder(view)
        }

        override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {
            // Bind data to UI elements in the ViewHolder
            // ...
        }

        override fun getItemCount(): Int {
            // Return the size of your data list
            // ...
            return TODO("Provide the return value")
        }
    }

    // Define tu ViewHolder para el RecyclerView
    private class ProductosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define UI elements from item_producto.xml here using itemView.findViewById
        // ...
    }
}

package com.example.radiostations.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.radiostations.R
import com.example.radiostations.databinding.ResultItemBinding
import com.example.radiostations.model.BaseModel
import com.example.radiostations.model.linkbrand.Brand
import com.example.radiostations.utils.Constants.LOGO_KEY

class RadioAdapter : RecyclerView.Adapter<RadioAdapter.RadioListHolder>() {

    private var listRadios: BaseModel? = null


    class RadioListHolder(@param:NonNull val radioListItemBinding: ResultItemBinding) :
        RecyclerView.ViewHolder(radioListItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ResultItemBinding.inflate(layoutInflater, parent, false)
        return RadioListHolder(binding)
    }

    override fun onBindViewHolder(holder: RadioListHolder, position: Int) {

       val logoUrl = getLogoUrl(listRadios!!.items[position].links.brand)

        holder.apply {
         radioListItemBinding.tvName.text = listRadios!!.items[position].attributes.brand.name
            Glide.with(holder.itemView.context)
                .load(logoUrl)
                .into(radioListItemBinding.imgThumb)

        }


        holder.itemView.apply {
            setOnClickListener { view ->
                val name = listRadios!!.items[position].attributes.brand.name
                val frequency = listRadios!!.items[position].attributes.brand.frequency
                val marketCity = listRadios!!.items[position].attributes.brand.marketCity
                val band = listRadios!!.items[position].attributes.brand.band
                val tagline = listRadios!!.items[position].attributes.brand.tagline
                val bundle = bundleOf("name" to name,"frequency" to frequency, "marketCity" to marketCity,
                    "band" to band, "tagline" to tagline)
                view.findNavController().navigate(
                    R.id.action_radioListFragment_to_radioDetailFragment,
                    bundle
                )
            }
        }

    }

    override fun getItemCount(): Int {

        if (listRadios == null) {
            return 0
        }

        return listRadios?.items!!.size

    }

    private fun getLogoUrl(brands: List<Brand>):String{

        var logoUrl = ""

        brands.forEach lit@{
            if(it.rel.compareTo(LOGO_KEY) == 0) {
                logoUrl = it.href
                Log.d(it.href,"HREF")
                return@lit
            }
        }

        return logoUrl
    }

    fun setListRadios(_listRadios: BaseModel) {
        listRadios = _listRadios
        notifyDataSetChanged()
    }


}
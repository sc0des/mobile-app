package Exercises.inc

import Exercises.inc.model.UnsplashItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_details.view.*
import kotlinx.android.synthetic.main.image_info.view.*


class MainAdapter(private var images: List<UnsplashItem>, val onClick: (Int) -> Unit):
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        // Main Photo
        val image = itemView.iv_preview as ImageView

        //Location text
        val locationv = itemView.locationT as TextView

        // User
        val author = itemView.tv_author as TextView

        // Photo details
        val modelv = itemView.cam_name as TextView
        val aperturev = itemView.aperture_vv as TextView
        val focallengthv = itemView.flength_name as TextView
        val isov = itemView.tv_iso as TextView
        val shutterv = itemView.shutter_s as TextView
        val dims = itemView.widthv as TextView

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        // link to layout
        return MainViewHolder(inflater.inflate(R.layout.activity_details, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        // Request information
        val image = images[position]
        holder.image.setOnClickListener {
            onClick(position)
        }

        holder.locationv.text = image.user.location
        holder.author.text = image.user.name

        holder.aperturev.text = null
        holder.focallengthv.text = null
        holder.isov.text = null
        holder.modelv.text = null
        holder.shutterv.text = null
        holder.dims.text= (image.width.toString() + "x"+ image.height.toString())




    }

    fun submitList(newImages: List<UnsplashItem>) {
        images = newImages
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return images.size
    }
}
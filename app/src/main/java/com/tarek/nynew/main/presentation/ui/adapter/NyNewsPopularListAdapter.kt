package com.tarek.nynew.main.presentation.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tarek.nynew.R
import com.tarek.nynew.main.data.model.NewsResponseModel
import kotlinx.android.synthetic.main.viewholder_news_item.view.*

class NyNewsPopularListAdapter(
    private val activity: Activity,
    private val data: List<NewsResponseModel>
) : RecyclerView.Adapter<NyNewsPopularListAdapter.NewsItemViewHolder>() {

    private var onNewsItemClicked: ((newsResponseModel: NewsResponseModel) -> Any)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): NewsItemViewHolder {
        return NewsItemViewHolder(
            LayoutInflater.from(activity).inflate(R.layout.viewholder_news_item, null, false)
        )
    }

    fun setOnNewsItemClicked(onNewsItemClicked: ((newsResponseModel: NewsResponseModel) -> Any)): NyNewsPopularListAdapter {
        this.onNewsItemClicked = onNewsItemClicked
        return this
    }

    override fun onBindViewHolder(newsItemViewHolder: NewsItemViewHolder, i: Int) {
        val responseModel = data[i]

        newsItemViewHolder.bind(responseModel, i)

        newsItemViewHolder.setOnClickListener(View.OnClickListener {
            onNewsItemClicked?.invoke(responseModel)
        })
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class NewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(newsItem: NewsResponseModel, position: Int) {

            val formattedName = newsItem?.title
            (itemView.findViewById<View>(R.id.news_title) as TextView).text = formattedName?.trim()

            val abstractDesc = newsItem?.abstract

            if(!newsItem?.abstract.isNullOrBlank())
            (itemView.findViewById<View>(R.id.news_abstract) as TextView).text = abstractDesc?.trim()

            val media = newsItem?.media
            if (!media.isNullOrEmpty()) {
                val metadata = media?.get(0);
                if (!metadata.mediaMetaData.isNullOrEmpty()) {
                    val url = metadata.mediaMetaData?.get(0)?.url
                    Picasso.get().load(url).into(itemView.image)
                }
            }

            val source = newsItem?.source
            (itemView.findViewById<View>(R.id.news_source) as TextView).text = source?.toUpperCase()?.trim()

            val datePublished=newsItem?.publishedDate
            (itemView.findViewById<View>(R.id.news_date_published) as TextView).text = datePublished?.trim()
        }

        fun setOnClickListener(listener: View.OnClickListener) {
            itemView.setOnClickListener(listener)
        }
    }
}
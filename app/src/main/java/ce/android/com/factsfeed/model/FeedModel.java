package ce.android.com.factsfeed.model;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class FeedModel {

    private String title, description, imageHref;

    public FeedModel(String title, String description, String imageHref) {
        this.title = title;
        this.description = description;
        this.imageHref = imageHref;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageHref() {
        return imageHref;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView , String imageUrl) {
        Picasso.with(imageView.getContext()).load(imageUrl).placeholder(null).into(imageView);
    }
}

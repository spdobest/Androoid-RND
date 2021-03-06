package spinfotech.androidresearchdev.spm.adapters.viewholders;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import spinfotech.androidresearchdev.R;
import spinfotech.androidresearchdev.spm.model.home.Child;

public class ViewHolderPopularImage extends RecyclerView.ViewHolder {

	private static final String TAG = "ViewHolderPopularImage";
	
	private Child childData;
	
	@BindView( R.id.profile_image )
	public CircleImageView    profileImage;
	@BindView( R.id.textViewPopularFeedName )
	public AppCompatTextView  textViewPopularFeedName;
	@BindView( R.id.textViewPopularTime )
	public AppCompatTextView  textViewPopularTime;

	@BindView( R.id.imageViewPopular )
	public AppCompatImageView imageViewPopular;
	@BindView( R.id.imageViewUp )
	public AppCompatImageView imageViewUp;
	@BindView( R.id.textViewUpDownCount )
	public AppCompatTextView  textViewUpDownCount;
	@BindView( R.id.imageViewDown )
	public AppCompatImageView imageViewDown;
	@BindView( R.id.textViewComments )
	public AppCompatTextView  textViewComments;
	@BindView( R.id.textViewShare )
	public AppCompatTextView  textViewShare;

	public ViewHolderPopularImage( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}
	public void setData(Child object) {
		this.childData =  object;
		updateUi();
	}

	private void updateUi(){ 

	//	textViewPopularTitle.setText( childData.getData().getName() );
		textViewUpDownCount.setText( "" + childData.getData().getViewCount() );
		textViewPopularFeedName.setText( childData.getData().getTitle() );

		if ( childData != null && childData.getData() != null && childData.getData().getPreview() != null && childData.getData().getPreview().getImages() != null && childData.getData().getPreview().getImages().size() > 0 ) {

			Glide.with( imageViewPopular.getContext() ).load( childData.getData().getPreview().getImages().get( 0 ).getSource().getUrl() )
					.thumbnail( 0.5f )
					.crossFade()
					.diskCacheStrategy( DiskCacheStrategy.ALL )
					.into( imageViewPopular );
		}
		else {
			Glide.with( imageViewPopular.getContext() ).load( "http://www.gstatic.com/webp/gallery/1.jpg" )
					.thumbnail( 0.5f )
					.crossFade()
					.diskCacheStrategy( DiskCacheStrategy.ALL )
					.into( imageViewPopular );
		}
	}
}
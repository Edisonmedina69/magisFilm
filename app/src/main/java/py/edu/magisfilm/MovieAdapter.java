package py.edu.magisfilm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }
        Movie movie = (Movie) getItem(position);
        ImageView poster = convertView.findViewById(R.id.movie_poster);
        TextView title = convertView.findViewById(R.id.movie_title);
        TextView overview = convertView.findViewById(R.id.movie_overview);
        TextView releaseDate = convertView.findViewById(R.id.movie_release_date);
        TextView voteAverage = convertView.findViewById(R.id.movie_vote_average);

        title.setText(movie.getTitle());
        overview.setText(movie.getOverview());
        releaseDate.setText(movie.getReleaseDate());
        voteAverage.setText(String.valueOf(movie.getVoteAverage()));

        Picasso.get().load("https://image.tmdb.org/t/p/w185_and_h278_bestv2/9E2y5Q7WlCVNEhP5GiVTjhEhx1https://image.tmdb.org/t/p/w185_and_h278_bestv2/9E2y5Q7WlCVNEhP5GiVTjhEhx1o"+movie.getPosterPath().toLowerCase()+".jpg")
                .into(poster);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalleActivity.class);
                intent.putExtra("movie", movie);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}

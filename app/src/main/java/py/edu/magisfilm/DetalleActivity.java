package py.edu.magisfilm;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {
    ImageView photoImageView;
    TextView nameTextView;
    TextView overviewTextView;
    TextView releaseDateTextView;
    TextView voteAverageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        photoImageView = findViewById(R.id.imageViewPhoto);
        nameTextView = findViewById(R.id.textViewName);
        overviewTextView = findViewById(R.id.textViewOverview);
        releaseDateTextView = findViewById(R.id.textViewReleaseDate);
        voteAverageTextView = findViewById(R.id.textViewVoteAverage);

        Movie movie = (Movie) getIntent().getSerializableExtra("movie");
        assert movie != null;
        mostrarMovie(movie);
    }

    private void mostrarMovie(Movie movie) {
        Picasso.get().load("https://image.tmdb.org/t/p/w185_and_h278_bestv2/" + movie.getPosterPath())
                .into(photoImageView);

        nameTextView.setText(movie.getTitle());
        overviewTextView.setText(movie.getOverview());
        releaseDateTextView.setText(movie.getReleaseDate());
        voteAverageTextView.setText(String.valueOf(movie.getVoteAverage()));
    }
}

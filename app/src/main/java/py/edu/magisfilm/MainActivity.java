package py.edu.magisfilm;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProgressBar progressBar;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        progressBar = findViewById(R.id.progress_bar);

        fetchMovies();
    }

    private void fetchMovies() {
        progressBar.setVisibility(View.VISIBLE);  // Mostrar la barra de progreso
        TMDbApi apiService = RetrofitClient.getClient().create(TMDbApi.class);
        apiService.getPopularMovies(new Callback<MovieResponse>() {
            @Override
            public void success(MovieResponse movieResponse, Response response) {
                List<Movie> movies = movieResponse.getResults();
                adapter = new MovieAdapter(MainActivity.this, movies);
                listView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);  // Ocultar la barra de progreso
            }

            @Override
            public void failure(RetrofitError error) {
                progressBar.setVisibility(View.GONE);  // Ocultar la barra de progreso
                Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

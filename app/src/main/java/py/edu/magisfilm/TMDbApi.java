package py.edu.magisfilm;

import retrofit.Callback;
import retrofit.http.GET;

public interface TMDbApi {
    @GET("https://api.themoviedb.org/3/search/movie?api_key=40e8d5093949baad92536f8ae212989a&query=Jack")
    void getPopularMovies(Callback<MovieResponse> callback);
}

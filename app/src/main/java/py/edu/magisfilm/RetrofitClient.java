package py.edu.magisfilm;

import retrofit.RestAdapter;

public class RetrofitClient {
    private static final String BASE_URL = "https://api.themoviedb.org";
    private static RestAdapter retrofit = null;

    public static RestAdapter getClient() {
        if (retrofit == null) {
            retrofit = new RestAdapter.Builder()
                    .setEndpoint("BASE_URL")
                    .setLogLevel(RestAdapter.LogLevel.FULL)  // Añadir logging para depuración
                    .build();
        }
        return retrofit;
    }
}

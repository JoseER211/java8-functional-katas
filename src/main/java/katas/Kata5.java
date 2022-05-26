package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .reduce((conjunto, ratio) -> {
                            if (conjunto.getRating() > ratio.getRating()) {
                                return conjunto;
                            } else {
                                return ratio;
                            }
                        }
                ).get().getRating();
    }
}

package katas;

import model.MovieList;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();


        return movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream().flatMap(video -> video.getBoxarts().stream()))
                .reduce((conjunto, boxArt) -> conjunto.getWidth() * conjunto.getHeight() >
                        boxArt.getWidth() * boxArt.getHeight() ? conjunto : boxArt).get().getUrl();
    }
}
package katas;

import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream()
                        .map(video -> ImmutableMap.of("id", video.getId(), "title", video.getTitle(),
                                "boxart", video.getBoxarts().stream()
                                        .filter(boxArt -> boxArt.getWidth() > 150).findFirst())))
                .collect(Collectors.toList());


    }
}

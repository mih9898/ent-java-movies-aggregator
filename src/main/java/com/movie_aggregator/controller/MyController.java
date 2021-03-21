package com.movie_aggregator.controller;

import com.movie_aggregator.entity.Movie;
import com.movie_aggregator.entity.Search;
import com.movie_aggregator.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

/**
 * The type My controller.
 *
 * @author mturchanov
 */
@Controller
public class MyController {

    @Autowired
    private GenericService genericService;


    /**
     * Search movie string.
     *
     * @param searchVal the search val
     * @param model     the model
     * @return the string
     * @throws IOException the io exception
     */
    @RequestMapping("/searchMovie")
    public String searchMovie(@RequestParam("searchVal") String searchVal, Model model)
            throws IOException {
        Search existedSearch = genericService.getOneEntryByColumProperty("name", searchVal, Search.class);
        List<Movie> movies = genericService.getMovies(existedSearch, searchVal);
        System.out.println(movies);
        model.addAttribute("movies", movies);
        return "/result.jsp";
    }


    /**
     * Gets movie info.
     *
     * @param model the model
     * @return the movie info
     */
    @RequestMapping("/movie")
    public String getMovieInfo( @RequestParam int id, Model model) {
        //model.addAttribute("movie", movieService.getMovie(id));
        model.addAttribute("movie", genericService.get(Movie.class, id));

        return "/movie.jsp";
    }

    /**
     * Test string.
     *
     * @param model the model
     * @return the string
     */
//Testing time
    @RequestMapping("/test")
    public String test(Model model) throws IOException {
        //Movie newMovie = new Movie();
        //Search search = new Search( 14,"search11212");
        //newMovie.setName("m4 - 2 movied added as a list");
        //newMovie.setId(1234);
        //newMovie.setImage("https://ichef.bbci.co.uk/news/976/cpsprodpb/12A9B/production/_111434467_gettyimages-1143489763.jpg");
        //newMovie.addSearchToMovie(search);
        //genericService.save(newMovie);
        String searchVal = "Exam";
        Search existedSearch = genericService.getOneEntryByColumProperty("name", searchVal, Search.class);
        List<Movie> movies = genericService.getMovies(existedSearch, searchVal);
        model.addAttribute("movies", movies);
        return "/test.jsp";
    }


    /**
     * Show first view string.
     *
     * @return the string
     */
    @RequestMapping("/")
    public String showFirstView() {
        return "/index.jsp";
    }
}






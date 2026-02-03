import java.util.*;
class TrendingMovies {
    String name;
    double rating;
    int year;
    TrendingMovies(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }
    public String toString() {
        return name + " (" + year + ") Rating: " + rating;
    }
}
class Main {
    public static void main(String[] args) {
        List<TrendingMovies> movies = Arrays.asList(
            new TrendingMovies("Movie A", 8.9, 2024),
            new TrendingMovies("Movie B", 9.1, 2023),
            new TrendingMovies("Movie C", 7.8, 2022),
            new TrendingMovies("Movie D", 9.0, 2024),
            new TrendingMovies("Movie E", 8.5, 2021),
            new TrendingMovies("Movie F", 9.3, 2024),
            new TrendingMovies("Movie G", 8.8, 2023)
        );
        movies.stream()
              .filter(m -> m.rating >= 8.5)
              .sorted((m1, m2) -> {
                  if (m2.rating != m1.rating) {
                      return Double.compare(m2.rating, m1.rating);
                  }
                  return Integer.compare(m2.year, m1.year);
              })
              .limit(5)
              .forEach(System.out::println);
    }
}
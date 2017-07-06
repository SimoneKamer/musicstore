package com.github.shmvanhouten.musicstore.genre;

public class Genre {

    private final Long id;
    private final String name;

    public Genre(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static final class GenreBuilder {
        private Long id;
        private String name;

        private GenreBuilder() {
        }

        public static GenreBuilder aGenre() {
            return new GenreBuilder();
        }

        public GenreBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public GenreBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public Genre build() {
            Genre genre = new Genre(id, name);
            return genre;
        }
    }
}

package exercise_tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class E04_ArticlesVersion2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] articleInfo = scanner.nextLine().split(", ");
            String title = articleInfo[0];
            String content = articleInfo[1];
            String author = articleInfo[2];
            articles.add(new Article(title, content, author));
        }
        String input = scanner.nextLine();
        sortArticlesBy(input, articles);
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    static void sortArticlesBy(String criteria, List<Article> articles) {
        switch (criteria) {
            case "title":
                articles.sort(Comparator.comparing(Article::getTitle));
                break;
            case "content":
                articles.sort(Comparator.comparing(Article::getContent));
                break;
            case "author":
                articles.sort(Comparator.comparing(Article::getAuthor));
                break;
        }
    }

    static class Article {
        private final String title;
        private final String content;
        private final String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", title, content, author);
        }
    }
}

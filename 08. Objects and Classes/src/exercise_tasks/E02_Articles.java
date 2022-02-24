package exercise_tasks;

import java.util.Scanner;

public class E02_Articles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArticle = scanner.nextLine().split(", ");
        int lines = Integer.parseInt(scanner.nextLine());

        Article article = new Article(inputArticle[0], inputArticle[1], inputArticle[2]);

        for (int i = 0; i < lines; i++) {
            String[] commandArgs = scanner.nextLine().split(": ");
            String command = commandArgs[0];
            switch (command) {
                case "Edit":
                    article.edit(commandArgs[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(commandArgs[1]);
                    break;
                case "Rename":
                    article.rename(commandArgs[1]);
                    break;
            }
        }
        System.out.println(article);
    }

    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void edit(String content) {
            this.content = content;
        }

        public void changeAuthor(String author) {
            this.author = author;
        }

        public void rename(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s%n", title, content, author);
        }
    }
}

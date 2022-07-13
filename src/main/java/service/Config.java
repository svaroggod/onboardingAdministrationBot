package service;

public interface Config {

    String BOT_USERNAME =System.getenv("BOT_USERNAME");
    String BOT_TOKEN = System.getenv("BOT_TOKEN");

    String JDBC_URL = System.getenv("JDBC_URL");
    String JDBC_USERNAME = System.getenv("JDBC_USERNAME");
    String JDBC_PASSWORD = System.getenv("JDBC_PASSWORD");


}



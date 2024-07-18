package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class AutoCompleteApp extends Application {
    private Trie trie = new Trie();

    @Override
    public void start(Stage primaryStage) {
        trie.insert("hello");
        trie.insert("hell");
        trie.insert("heaven");
        trie.insert("heavy");
        trie.insert("hello");
        trie.insert("helipad");
        trie.insert("helen");

        TextField textField = new TextField();
        ListView<String> listView = new ListView<>();
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            List<String> results = trie.autocompleteWithFrequency(newValue);
            listView.getItems().setAll(results);
        });

        VBox vbox = new VBox(textField, listView);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Autocomplete System");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
